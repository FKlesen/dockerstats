package DockerStats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		while((line = input.readLine()) != null) {
			System.out.println(line); // debug
			Container test = new ObjectMapper().readerFor(Container.class).readValue(line);
			System.out.println(test.getCpu_perc()); // debug
		}
	}

}
