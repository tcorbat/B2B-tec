package ch.hsr.examples.simplefactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleFactoryTest {

	@Test
	void test_create_unknown_subject() {
		Subject subject = SubjectFactory.create(null);

		assertEquals("", subject.keyOf(), "Factory must create 'unknown' subjects if key is null.");
	}

	@Test
	void test_create_subject() {
		Subject subject = SubjectFactory.create("key");

		assertEquals("key", subject.keyOf(), "Factory must create subjects with given key.");
	}
}
