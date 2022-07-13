package de.tum.in.ase.eist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class QueryProcessorTest {

	private final QueryProcessor queryProcessor = new QueryProcessor();

	@Test
	void testEmptyStringIfCannotProcessQuery() {
		assertEquals("", queryProcessor.process("test"));
	}

	@Test
	void testKnowsAboutShakespeare() {
		String actual = queryProcessor.process("Shakespeare");
		if (!actual.contains("playwright")) {
			fail("The QueryProcessor does not know about Shakespeare.");
		}
	}

	@Test
	void isNotCaseSensitive() {
		String actual = queryProcessor.process("shakespeare");
		if (!actual.contains("playwright")) {
			fail("Your QueryProcessor should not be case sensitive.");
		}
	}

	@Test
	void knowsHowToAdd() {
		String actual = queryProcessor.process("what is 6 plus 19");
		if (!(actual == "25")) {
			fail("Your QueryProcessor is not adding properly.");
		}//
	}

	@Test
	void knowsHowToIdentifyLargestNumber() {
		String actual = queryProcessor.process("which of the following is the largest: 0, 10, 100");
		if (!(actual == "100")) {
			fail("Your QueryProcessor is not identifying the largest number properly.");
		}
	}

}
