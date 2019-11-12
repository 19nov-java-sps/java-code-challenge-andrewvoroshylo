package com.revature.eval;

import java.util.*;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return 
	 * @return
	 */
	public String reverse(String string) {
		if (string == null)
		{return string;
		}
		ArrayList<Character> chars = new ArrayList<>();
		String reverse = "";
		for (int i = 0; i < string.length(); i++) {
			chars.add(string.charAt(i));
		}
		for (int i = 1;i <= string.length(); i++) {
			reverse = reverse + chars.get(string.length()-i);
		}
		return reverse;
	}



	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		if (phrase == null)
		{return phrase;
		}
		String[] spliter = null;
		String acronym = "";
		char converter = 'a';
		spliter = phrase.split("\\W+");
		for (int i = 0;i < spliter.length; i++) {
			converter = spliter[i].charAt(0);
			acronym = acronym + Character.toUpperCase(converter);
			
		}
		return acronym;
	}
	
	
	/**
	 * 3. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	boolean contains(char c, char[] array) {
	    for (char x : array) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}
	public int getScrabbleScore(String string) {
		List<Character> score = new ArrayList<>();
		char[] onePoint = new char[]{'A', 'a','E','e','I','i','O','o','U','u','L','l','N','n','R','r','S','s','T','t'};
		char[] twoPoint = new char[]{'D','d','G','g'};
		char[] threePoint = new char[]{'B','b','C','c','M','m','P','p'};
		char[] fourPoint = new char[] {'F','f','H','h','V','v','W','w','Y','y'};
		char[] fivePoint = new char[]{'K','k'};
		char[] eightPoint = new char[]{'J','j','X','x'};
		char[] tenPoint = new char[]{'Z','z','Q','q'};
		int totalPoints = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (contains(c, onePoint)) {
				totalPoints = totalPoints + 1;
			}
			if(contains(c, twoPoint)) {
				totalPoints = totalPoints + 2;
			}
			if (contains(c, threePoint)) {
				totalPoints = totalPoints + 3;
			}
			if  (contains(c, fourPoint)) {
				totalPoints = totalPoints + 4;
			}
			if (contains(c, fivePoint)) {
				totalPoints = totalPoints + 5;
			}
			if (contains(c, eightPoint)) {
				totalPoints = totalPoints + 8;
			}
			if (contains(c, tenPoint)) {
				totalPoints = totalPoints + 10;
			}
			else {
				totalPoints = totalPoints + 0;
			}
		}
		return totalPoints;
	}
	
	
	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return 
	 */
	public Map<String, Integer> wordCount(String string) {
		if (string == null)
		{return null;
		}
		String[] spliter = null;
		if (string.contains(",")) {
		spliter = string.split(",");
		}
		else {
		spliter = string.split("\\s");}
		Map<String,Integer> counter = new LinkedHashMap<String,Integer>();
		for (int i = 0;i < spliter.length;i++) {
			counter.put(spliter[i], 1);
		}
		return counter;
	}
	
	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	    static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {
	//		List<T> sortedList = getSortedList();
	//		int startIndex = 0;
	//		int endIndex = sortedList.size()-1;
	//		while (startIndex <= endIndex) {
	//			int middleIndex = (endIndex-startIndex) / 2;
	//			T actualValue = sortedList.get(middleIndex);
	//			int comparisonResult = t.compareTo(actualValue);
	//			if (comparisonResult == 0) {
	//				return middleIndex;
	//			}
	//			if(comparisonResult < 0 ) {
	//				endIndex = middleIndex-1;
	//			}
	//			else {
	//				startIndex = middleIndex+1;
	//		}
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	
}