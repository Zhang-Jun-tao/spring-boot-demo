package com.yx.statistics.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
@ConfigurationProperties(prefix="auther")
public class AuthorProperties {
	private static String name;
	private static String phone;

	
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		AuthorProperties.name = name;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		AuthorProperties.phone = phone;
	}
	
}
