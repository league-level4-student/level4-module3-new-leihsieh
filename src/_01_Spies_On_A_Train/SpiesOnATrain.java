package _01_Spies_On_A_Train;

import java.util.ArrayList;
import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

    /*
     * A spy has made off with important intel from your intelligence agency!
     * You know the spy is somewhere on this train(LinkedList). Your job is to
     * find the suspect that matches the description given to you by the list of
     * clues(the array).
     * 
     * Walk through the train, questioning each of the passengers about what
     * they have seen and return the name of the most likely suspect.
     * 
     * The results are randomly generated each time so you should have a general
     * case solution that carefully compares the clues to each passenger's
     * testimony. Remember to use String methods to break up the passengers'
     * statements.
     */
    String findIntel(LinkedList<TrainCar> train, String[] clues) {
    	train.print();
    	for(int i = 0; i < clues.length; i++) {
    		System.out.print(clues[i] + ", ");
    	}
    	System.out.println("\n");
    	Node<TrainCar> head = train.getHead();
    	ArrayList<String> evidenceArr = new ArrayList<String>();
    	while(head!=null) {
    		String question = head.getValue().questionPassenger().toString();
    		int subStart = question.indexOf("saw ");
    		String evidence = question.substring(subStart+4);
    		evidenceArr.add(evidence);
    		System.out.println(evidence + "\n");
    		head=head.getNext();
    	}
    	ArrayList<String> cluesArr = new ArrayList<String>();
    	cluesArr.add(clues[0]);
    	cluesArr.add(clues[1]);
    	cluesArr.add(clues[2]);
    	ArrayList<String> names = new ArrayList<String>();
    	for(String ev : evidenceArr) {
    		int subStart = ev.indexOf(' ');
    		String name = ev.substring(0,subStart);
    		String evidence = ev.substring(subStart+1,ev.length()-1);
    		if(cluesArr.contains(evidence)) {
    			names.add(name);
    		}
    	}
    	ArrayList<String> temp = new ArrayList<String>();
    	ArrayList<Integer> count = new ArrayList<Integer>();
    	for(String name : names) {
    		if(temp.contains(name)==true) {
    			int val = count.get(temp.indexOf(name));
    			count.set(temp.indexOf(name), val+1);
    		}
    		else {
    			temp.add(name);
    			count.add(1);
    		}
    	}
    	String sus = temp.get(count.indexOf(3));
        return sus;
    }

}
