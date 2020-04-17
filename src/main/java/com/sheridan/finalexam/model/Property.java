package com.sheridan.finalexam.model;

import com.sheridan.finalexam.constants.ApplicationConstant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Property {	
	
	private String name;
	private String type;
	private int totalRooms;
	private int totalStaffRooms;
	
	public Property() {
		super();
		this.name="Ship";
		this.type="Ship";
		this.totalRooms = ApplicationConstant.TOTAL_ROOMS;
		this.totalStaffRooms = ApplicationConstant.ROOMS_RESERVED_FOR_STAFF;
	}
	
}
