package com.artisandwich.type;

import com.artisandwich.interfaces.Price;

public abstract class Bread implements Price {

	private int size;
	private String name;

	
	protected Bread(String name, int size) {
		this.name = name;
		this.size = size;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return this.size;
	};
	
	@Override
	public double getTotalPrice() {
		if (size == 4) {
			return 5.50;
		} else if (size == 8) {
			return 7.50;
		} else {
			return 8.50;
		}

	}
}
