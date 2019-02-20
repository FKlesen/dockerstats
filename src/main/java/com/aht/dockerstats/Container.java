package com.aht.dockerstats;

import java.io.Serializable;
import java.util.ArrayList;

public class Container implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String memory;
	private String mem_perc;
	private String cpu_perc;
	private String net_io;
	private String block_io;
	private int pids;
	private ArrayList<PortMapping> portmappings;
	
	public Container() {
		super();
		this.portmappings = new ArrayList<PortMapping>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getMem_perc() {
		return mem_perc;
	}
	public void setMem_perc(String mem_perc) {
		this.mem_perc = mem_perc;
	}
	public String getCpu_perc() {
		return cpu_perc;
	}
	public void setCpu_perc(String cpu_perc) {
		this.cpu_perc = cpu_perc;
	}
	public String getNet_io() {
		return net_io;
	}
	public void setNet_io(String net_io) {
		this.net_io = net_io;
	}
	public String getBlock_io() {
		return block_io;
	}
	public void setBlock_io(String block_io) {
		this.block_io = block_io;
	}
	public int getPids() {
		return pids;
	}
	public void setPids(int pids) {
		this.pids = pids;
	}
	public ArrayList<PortMapping> getPortmappings() {
		return portmappings;
	}
	public void setPortmappings(ArrayList<PortMapping> portmappings) {
		this.portmappings = portmappings;
	}
	public void addPortmapping(PortMapping portmapping) {
		this.portmappings.add(portmapping);
	}

}
