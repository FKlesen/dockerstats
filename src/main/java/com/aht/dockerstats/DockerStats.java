package com.aht.dockerstats;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DockerStats {

	public static void main(String[] args) throws IOException {

		String query = "docker stats --no-stream --format " +
			"\"{" + 
				"\\\"id\\\":\\\"{{ .ID }}\\\"," +
				"\\\"name\\\":\\\"{{ .Name }}\\\"," +
				"\\\"memory\\\":\\\"{{ .MemUsage }}\\\"," +
				"\\\"mem_perc\\\":\\\"{{ .MemPerc }}\\\"," +
				"\\\"cpu_perc\\\":\\\"{{ .CPUPerc }}\\\"," +
				"\\\"net_io\\\":\\\"{{ .NetIO }}\\\"," +
				"\\\"block_io\\\":\\\"{{ .BlockIO }}\\\"," +
				"\\\"pids\\\":\\\"{{ .PIDs }}\\\"" +
			"}\"";
		
		Process process = Runtime.getRuntime().exec(query);		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String line;
		Containers containers = new Containers();
		
		while((line = input.readLine()) != null) {
//			System.out.println(line); // debug
			Container con = new ObjectMapper().readerFor(Container.class).readValue(line);

			Process process2 = Runtime.getRuntime().exec("docker container port " + con.getId());
			BufferedReader input2 = new BufferedReader(new InputStreamReader(process2.getInputStream()));
			String line2;
			while((line2 = input2.readLine()) != null) {
				if (line2 != "") {
//					System.out.println(line2); // debug
					con.addPortmapping(new PortMapping(line2.split("/| \\-\\> |:")));
				}
			}
			
			containers.addContainer(con);
		}
		
		try (
			FileOutputStream fos = new FileOutputStream ("containers.ser");
			ObjectOutputStream oos = new ObjectOutputStream (fos)
		) {
			oos.writeObject (containers);
		}
	}

}
