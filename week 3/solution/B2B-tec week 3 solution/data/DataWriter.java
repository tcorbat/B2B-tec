import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.GsonBuilder;

public class DataWriter {

	private final String fileName;

	public DataWriter(String fileName) {
		this.fileName = fileName;
	}

	public void write(Object objectToWrite) throws IOException {
		var builder = new GsonBuilder();
		builder.serializeNulls();
		builder.setPrettyPrinting();
		var gson = builder.create();
		var catalogFile = new File(fileName);
		try (var writer = new FileWriter(catalogFile)) {
			writer.write(gson.toJson(objectToWrite));
		}
	}
}
