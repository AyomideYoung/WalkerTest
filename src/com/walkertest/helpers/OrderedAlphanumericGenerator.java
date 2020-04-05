package com.walkertest.helpers;

public class OrderedAlphanumericGenerator {
	
	public static int[] generateNumbersFromZero(int maxValue) {
		int[] generatedNumbers = new int[maxValue];
		for(int i = 0; i < maxValue; i++) {
			generatedNumbers[i] = i;
		}
		return generatedNumbers;
	}
	
	public static int[] generateNumbersFromAMinimum(int min, int maxValue) {
		int[] generatedNumbers = new int[maxValue];
		for(int i = min; i < (min + maxValue); i++) {
			generatedNumbers[i] = i;
		}
		return generatedNumbers;
	}
	
	public static String[] generateAlphabets(int generatedArrayLength) {
		int numberOfCharSlots = 0;
		int numberOfCompletelyOccupiedSlots = Math.abs(generatedArrayLength / 26);
		boolean willHavePartiallyOccupiedSlot = ((generatedArrayLength % 26) != 0) ? true: false;
		
		if(willHavePartiallyOccupiedSlot) {
			numberOfCharSlots = numberOfCompletelyOccupiedSlots + 1;
		} else {
			numberOfCharSlots = numberOfCompletelyOccupiedSlots;
		}
		
		String[] filledSlots = fillSlots(numberOfCharSlots, generatedArrayLength);
		return filledSlots;
	}

	private static String[] fillSlots(int numberOfCharSlots, int generatedArrayLength) {
		Character firstAlphabet = 'A';
		String[] sequenceOfStrings = new String[generatedArrayLength];
		String previousString = null;
		String currentString = null;
		
		for(int i = 0; i < generatedArrayLength; i++) {
			if(i == 0) {
				currentString = new String(firstAlphabet.toString());
				sequenceOfStrings[i] = currentString;
				previousString = currentString;
				continue;
			} else {
				currentString = incrementString(previousString, numberOfCharSlots);
				sequenceOfStrings[i] = currentString;
				previousString = currentString;
			}
		}
		return sequenceOfStrings;
	}

	private static String incrementString(String stringToIncrement, int numberOfCharSlots) {
		for(int i = stringToIncrement.length() - 1; i > -1; i--) {
			Character charAtIndex = stringToIncrement.charAt(i);
			char[] tempCharArray = stringToIncrement.toCharArray();
			boolean qualifiesForExtension = (i == 0 && charAtIndex.equals('Z') && stringToIncrement.length() < numberOfCharSlots);
			
			if(qualifiesForExtension) {
				stringToIncrement = stringToIncrement + "A";
				tempCharArray = stringToIncrement.toCharArray();
			}
			
			if(charAtIndex.equals('Z')) {
				stringToIncrement = changeCharZ_To_A_AtIndex(tempCharArray, i);
				continue;
			} else {
				stringToIncrement = incrementCharacterByOneAtIndex(tempCharArray, i);
				break;
			}
		}
		return stringToIncrement;
	}
	
	private static String changeCharZ_To_A_AtIndex(char[] charArray,int index) {
				charArray[index] = 'A';
				String resultString = new String(charArray);
				resultString = resultString.toUpperCase();
				
				return resultString;
	}
	
	private static String incrementCharacterByOneAtIndex(char[] charArray, int index) {
		char charAtIndex = charArray[index];
		charArray[index] = Character.forDigit(Character.getNumericValue(charAtIndex) + 1, 32);
		String resultString = new String(charArray);
		resultString = resultString.toUpperCase();
		
		return resultString;
	}
	
}
