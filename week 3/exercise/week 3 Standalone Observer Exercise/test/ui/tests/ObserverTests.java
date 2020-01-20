package ui.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import bl.DomainModel;
import ui.UserInterface;

class ObserverTests {
	private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
	private final PrintStream stream = new PrintStream(outputContent);
	private final static String linebreak = System.lineSeparator();

	private static String useSystemLineSeparators(String input) {
		return input.replaceAll("\\n", linebreak);
	}

	@Test
	void testUIPrintsChangedData() {
		var model = new DomainModel();
		new UserInterface(model);
		model.setData("XYZ");
		String expected = useSystemLineSeparators("XYZ\n");
		assertEquals(expected, outputContent.toString());
	}

}
