package ch.b2btec.bl.services.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.GsonBuilder;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.services.CatalogService;

public class JsonCatalogService implements CatalogService {

	private final Catalog catalog;

	public JsonCatalogService(String catalogFileName) throws IOException {
		catalog = readCatalog(catalogFileName);
	}
	
	@Override
	public Catalog loadCatalog() {
		return catalog;
	}
	
	private static Catalog readCatalog(String fileName) throws IOException {
		var catalogFile = new File(fileName);
		try (var reader = new FileReader(catalogFile)) {
			var builder = new GsonBuilder();
			var gson = builder.create();
			return gson.fromJson(reader, Catalog.class);
		} 
	}
}
