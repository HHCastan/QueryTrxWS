package com.lineai.posappframework.util.userdefined.WS_FALSolutions;

public class Version {
	private static final String SYSTEM_VERSION = "V 1.3.3";

	private static final String SYSTEM_VENDOR = "Linea Datascan S.A";

	private static final String SYSTEM_NAME = "WS_FALSolutionsActor";

	private static final String SYSTEM_COPYRIGH = "(C) Copyright 2012";

	/** Creates a new instance of Version */
	public Version() {
	}

	public static void print() {
		System.out.println("______________________________________________");
		System.out.println(getSystemVendor());
		System.out.println(getSystemName() + " " + getSystemVersion());
		System.out.println(getSystemCopyrigh());
		System.out.println("______________________________________________");
	}

	public static void print(String name) {
		System.out.println("______________________________________________");
		System.out.println(getSystemVendor());
		System.out.println(name + getSystemVersion());
		System.out.println(getSystemCopyrigh());
		System.out.println("______________________________________________");
	}

	public static String getSystemVersion() {
		return SYSTEM_VERSION;
	}

	public static String getSystemVendor() {
		return SYSTEM_VENDOR;
	}

	public static String getSystemName() {
		return SYSTEM_NAME;
	}

	public static String getSystemCopyrigh() {
		return SYSTEM_COPYRIGH;
	}
}
