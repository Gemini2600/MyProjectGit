package com.neusoft.entity;

import java.util.UUID;

public class Test {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().substring(0, 8));
	}
}
