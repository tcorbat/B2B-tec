package ch.b2btec.bl.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.GsonBuilder;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.services.CatalogManagement;

public class CatalogManagementService implements CatalogManagement {

	private final Catalog shopCatalog;
	
	public CatalogManagementService(String filePath) throws FileNotFoundException, IOException {
		var catalogFile = new File(filePath);
		try (var reader = new FileReader(catalogFile)) {
			var builder = new GsonBuilder();
			var gson = builder.create();
			shopCatalog = gson.fromJson(reader, Catalog.class);
		}
	}
	
	@Override
	public Catalog getCatalog() {
		return shopCatalog;
	}

}
