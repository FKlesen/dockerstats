package com.aht.dockerstats;

import java.io.Serializable;
import java.util.ArrayList;

public class Containers implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Container> containers;

	public Containers() {
		super();
		this.containers = new ArrayList<Container>();
	}
	
	public void addContainer(Container con) {
		containers.add(con);
	}
	
	public ArrayList<Container> getContainers(){
		return containers;
	}

}
