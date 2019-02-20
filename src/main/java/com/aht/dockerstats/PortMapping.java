package com.aht.dockerstats;

import java.io.Serializable;

public class PortMapping implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String host;
	private int srcPort;
	private int dstPort;
	private String protocol;
	

	public PortMapping(String[] parts) {
		this.host = parts[2];
		this.srcPort = Integer.parseInt(parts[3]);
		this.dstPort = Integer.parseInt(parts[0]);
		this.protocol = parts[1];
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getSrcPort() {
		return srcPort;
	}
	public void setSrcPort(int srcPort) {
		this.srcPort = srcPort;
	}
	public int getDstPort() {
		return dstPort;
	}
	public void setDstPort(int dstPort) {
		this.dstPort = dstPort;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}


}
