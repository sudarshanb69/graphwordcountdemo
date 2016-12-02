package org.sample.test.count;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author Sudarshan Bandi
 *
 * Provides word count functionality
 */
public class WordCounter {

	/**
	 * Takes a string and splits it into words separated by white spaces, counts
	 * frequency for each word
	 * 
	 * @param input
	 * @return a map with word counts
	 */
	public Map<String, Long> countWords(String input) {
		String[] words = input.split("\\s+");

		Map<String, Long> wordCounts = Arrays.asList(words).stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return wordCounts;
	}

	/**
	 * Takes filename as input, reads lines, splits them into words,
	 * and counts how many times each word occured
	 * 
	 * @param inputFile
	 * @return a map with word counts
	 */
	public Map<String, Long> countWordsInFile(String inputFile) {
		Map<String, Long> wordCounts;
		try {
			wordCounts = Files.lines(Paths.get(inputFile)).map(line -> line.split("\\s+")).flatMap(Arrays::stream)
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		} catch (IOException e) {
			// Log for now
			System.out.println("Error in reading file...");
			System.out.println(e);

			wordCounts = new HashMap<>();
		}

		return wordCounts;
	}

	/**
	 * Prints words with count starting from the word which occurs most to
	 * the word that occurs least.
	 * @param countMap
	 */
	public void printWords(Map<String, Long> countMap) {
		countMap.entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
				.forEach(e -> System.out.println(e.getValue() + " " + e.getKey()));
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			WordCounter wordCounter = new WordCounter();

			Map<String, Long> wordCounts = wordCounter.countWordsInFile((args[0]));
			wordCounter.printWords(wordCounts);
		} else {
			System.out.println("Error: Filename to process word counts is not provided.");
			System.out.println("Usage: java -cp target\\graphwordcounts-0.0.1-SNAPSHOT.jar org.sample.test.count.WordCounter <filename>");
		}

	}
}
