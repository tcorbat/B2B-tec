import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSingletonDemo {

	@BeforeEach
	void resetGlobalCounter() {
		GlobalCounter.getInstance().reset();
	}

	@Test
	void testMyMethodInputZero() {
		var demo = new SingletonDemo();
		assertEquals(42, demo.myMethod(0));
	}

	@Test
	void testMyMethodInputOne() {
		var demo = new SingletonDemo();
		assertEquals(43, demo.myMethod(1));
	}

}
