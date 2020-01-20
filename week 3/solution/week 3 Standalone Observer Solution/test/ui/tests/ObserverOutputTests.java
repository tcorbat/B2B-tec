package ui.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bl.DomainModel;
import ui.UserInterface;

class ObserverOutputTests {

	private final static String linebreak = System.lineSeparator();

	private static String useSystemLineSeparators(String input) {
		return input.replaceAll("\\n", linebreak);
	}

	private final ByteArrayOutputStream outTestStream = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outTestStream));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	void testUIPrintsChangedData() {
		var model = new DomainModel();
		new UserInterface(model);
		model.setData("XYZ");
		String expected = useSystemLineSeparators("UI: XYZ\n");
		assertEquals(expected, outTestStream.toString());
	}

}
