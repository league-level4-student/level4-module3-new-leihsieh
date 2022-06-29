package _04_Morse_Code;

import java.util.ArrayList;
import java.util.Scanner;

import _03_Intro_to_Binary_Trees.Node;
import _03_Intro_to_Binary_Trees.BinaryTree;

public class MorseDecoder {

	BinaryTree<MorseCode> mcTree = new BinaryTree<MorseCode>();

	public static void main(String[] args) {

		MorseDecoder md = new MorseDecoder();
		md.initialize();
		md.decode("-.-- --- ..- .- .-. . .- -- .- --.. .. -. --.");
		do{
			md.translator();
		}
		while(true);
	}

	public void initialize() {

		mcTree.insert(new MorseCode("start", ""));
		mcTree.insert(new MorseCode("e", "."));
		mcTree.insert(new MorseCode("t", "-"));

		mcTree.insert(new MorseCode("i", ".."));
		mcTree.insert(new MorseCode("a", ".-"));
		mcTree.insert(new MorseCode("n", "-."));
		mcTree.insert(new MorseCode("m", "--"));

		mcTree.insert(new MorseCode("s", "..."));
		mcTree.insert(new MorseCode("u", "..-"));
		mcTree.insert(new MorseCode("r", ".-."));
		mcTree.insert(new MorseCode("w", ".--"));
		mcTree.insert(new MorseCode("d", "-.."));
		mcTree.insert(new MorseCode("k", "-.-"));
		mcTree.insert(new MorseCode("g", "--."));
		mcTree.insert(new MorseCode("o", "---"));

		mcTree.insert(new MorseCode("h", "...."));
		mcTree.insert(new MorseCode("v", "...-"));
		mcTree.insert(new MorseCode("f", "..-."));
		mcTree.insert(new MorseCode("l", ".-.."));
		mcTree.insert(new MorseCode("p", ".--."));
		mcTree.insert(new MorseCode("j", ".---"));
		mcTree.insert(new MorseCode("b", "-..."));
		mcTree.insert(new MorseCode("x", "-..-"));
		mcTree.insert(new MorseCode("c", "-.-."));
		mcTree.insert(new MorseCode("y", "-.--"));
		mcTree.insert(new MorseCode("z", "--.."));
		mcTree.insert(new MorseCode("q", "--.-"));

		mcTree.printVertical();

	}

	/*
	 * 1.) See if you can decode the following message using the binary tree and
	 * print it to the console:
	 * 
	 * -.-- --- ..- .- .-. . .- -- .- --.. .. -. --.
	 * 
	 * 2.) Then use the binary tree and the scanner class to create a morse code
	 * translator. The user should be able to type multiple letters in morse code on
	 * a single line and have it repeated back to them, decoded into the english
	 * alphabet.
	 * 
	 */
	void decode(String morseCode) {
		char[] morseArr = morseCode.toCharArray();
		ArrayList<String> morseChar = new ArrayList<String>();
		int prevLength = 0;
		for(int j = 0; j < morseArr.length; j++) {
			if (morseArr[j] == ' ') {
				morseChar.add(morseCode.substring(prevLength, j));
				prevLength = j+1;
			}
		}
		morseChar.add(morseCode.substring(prevLength, morseCode.length()));
		String decodedMorse = "";
        for(int i = 0; i < morseChar.size(); i++) {
        	decodedMorse += mcTree.search(new MorseCode(null, morseChar.get(i))).getValue().getDecoded();
        }
        System.out.println(decodedMorse + "\n");
	}
	
	void translator() {
		System.out.println("Enter a line of morse code to be translated");
		Scanner sc = new Scanner(System.in);
		String morse = sc.nextLine();
		decode(morse);
	}
}
