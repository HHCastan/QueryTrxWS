package com.linea.loadLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;

public class AddLibraries {

	public static Vector moduleFiles = new Vector();

	public static void init() {
		String libPath = "/cdrive/f_drive/derby/lib/";
		try {
			URLClassLoader urlClassL = ((URLClassLoader) ClassLoader.getSystemClassLoader());
			URL[] urls = urlClassL.getURLs();
			loadFiles(libPath);
			commitLoadFiles();

			URL[] urls2 = urlClassL.getURLs();
			System.out.println("Classpath2:");
			for (int i = 0; i < urls2.length; i++) {
				System.out.println("\t" + urls2[i].getFile());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadFiles(String path) throws IOException {
		Properties p = new Properties();
		String filters = "jar zip JAR ZIP";
		Vector vfilters = new Vector();
		StringTokenizer cadena = new StringTokenizer(filters);
		int numTokens = cadena.countTokens();
		for (int i = 0; i < numTokens; i++) {
			String filter = cadena.nextToken();
			vfilters.addElement(filter);
		}
		File modulesFolder = new File(path);

		File[] f = modulesFolder.listFiles();
		if (f != null)
			for (int j = 0; j < f.length; j++)
				if (f[j].isDirectory())
					loadFilesFilter(f[j].getAbsolutePath(), vfilters);
				else
					politicaPAF(f[j], vfilters);
	}

	public static void loadFilesFilter(String path, Vector filter) throws IOException {
		File modulesFolder = new File(path);
		File[] f = modulesFolder.listFiles();
		if (f != null)
			for (int i = 0; i < f.length; i++)
				if (f[i].isDirectory())
					loadFilesFilter(f[i].getAbsolutePath(), filter);
				else
					politicaPAF(f[i], filter);
	}

	public static void politicaPAF(File file, Vector filter) {
		String extension = file.getName().substring(file.getName().lastIndexOf('.') + 1).toUpperCase().trim();
		String name = file.getName();
		if (name.indexOf('.') != -1) {
			name = file.getName().substring(0, file.getName().lastIndexOf('.')).trim();
		}
		for (int i = 0; i < filter.size(); i++) {
			String sfilter = (String) filter.get(i);
			if (sfilter.toUpperCase().equals(extension))
				if (extension.equals("JAR")) {
					int position = searchFileVector(name);
					if (position == -1) {
						moduleFiles.addElement(file);
					} else if (extension.equals("PAF")) {
						moduleFiles.setElementAt(file, position);
					}
				} else if (extension.equals("PAF")) {
					int position = searchFileVector(name);
					if (position != -1) {
						File tmpFile = (File) moduleFiles.get(position);
						String ext = tmpFile.getName().substring(tmpFile.getName().lastIndexOf('.') + 1).toUpperCase();
						if (ext.equals("JAR"))
							moduleFiles.setElementAt(file, position);
					} else {
						moduleFiles.addElement(file);
					}
				} else {
					moduleFiles.addElement(file);
				}
		}
	}

	public static int searchFileVector(String nameFile) {
		for (int i = 0; i < moduleFiles.size(); i++) {
			String name = ((File) moduleFiles.elementAt(i)).getName()
					.substring(0, ((File) moduleFiles.elementAt(i)).getName().lastIndexOf('.')).trim();
			if (nameFile.toUpperCase().equals(name.toUpperCase())) {
				return i;
			}
		}
		return -1;
	}

	public static void commitLoadFiles() throws IOException {
		for (int i = 0; i < moduleFiles.size(); i++) {
			ModuleLoader.addFile((File) moduleFiles.get(i));
		}
		moduleFiles.removeAllElements();
	}
}
