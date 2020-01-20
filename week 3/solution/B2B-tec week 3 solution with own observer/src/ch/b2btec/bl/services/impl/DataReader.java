package ch.b2btec.bl.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.GsonBuilder;

public class DataReader {

	private final String fileName;

	public DataReader(String fileName) {
		this.fileName = fileName;

	}

	public <Type> Type read(Class<Type> clazz) throws FileNotFoundException, IOException {
		var catalogFile = new File(fileName);
		try (var reader = new FileReader(catalogFile)) {
			var builder = new GsonBuilder();
			var gson = builder.create();
			return gson.fromJson(reader, clazz);
		}
	}
}
