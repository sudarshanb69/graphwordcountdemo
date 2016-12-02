package org.sample.test.count;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {
	private String testFile = "src/test/resources/testfiles/story.txt";
	private WordCounter wordCounter;

	@Before
	public void setUp() throws Exception {
		wordCounter = new WordCounter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountWords() {
		String input = "This I and I and   some this	hello ";
		Map<String, Long> wordCounts = wordCounter.countWords(input);
		
		assertTrue(wordCounts.get("This") == 1);
		assertTrue(wordCounts.get("I") == 2);
		assertTrue(wordCounts.get("and") == 2);
		assertTrue(wordCounts.get("some") == 1);
		assertTrue(wordCounts.get("this") == 1);
		assertTrue(wordCounts.get("hello") == 1);
		
		wordCounter.printWords(wordCounts);
	}

	@Test
	public void testCountWordsInFile() {
		Map<String, Long> wordCounts = wordCounter.countWordsInFile(testFile);
		
		assertTrue(wordCounts.get("sky") == 3);
		assertTrue(wordCounts.get("Tom") == 3);
		assertTrue(wordCounts.get("and") == 3);
		assertTrue(wordCounts.get("Angela") == 3);
		assertTrue(wordCounts.get("fly") == 2);
		assertTrue(wordCounts.get("a") == 1);
		assertTrue(wordCounts.get("in") == 1);
		assertTrue(wordCounts.get("Texas") == 1);
		assertTrue(wordCounts.get("jet") == 1);
		assertTrue(wordCounts.get("to") == 1);
		assertTrue(wordCounts.get("travel") == 1);
		
		wordCounter.printWords(wordCounts);
	}

	@Test
	public void testCountWordsInInvalidFile() {
		Map<String, Long> wordCounts = wordCounter.countWordsInFile("invalidfile.txt");
		
		assertTrue(wordCounts.isEmpty());
	}
}
