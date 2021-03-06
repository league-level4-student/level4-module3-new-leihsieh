package _02_Rainbow_Zombie_Conga_Line;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class RainbowZombieCongaLine {

	/*
	 * You are hosting a rainbow zombie conga dance party! Zombies are not very
	 * smart(maybe that's why they crave brains) and need your help to direct them
	 * through the choreography.
	 * 
	 * Each method is a dance move you will need to implement.
	 * 
	 * When you think you've gotten your zombies trained well enough you can start
	 * the party by running the main method in RainbowZombieDanceParty and typing
	 * how many rounds you want in the console to see if they followed your
	 * choreography correctly.
	 * 
	 * Note: The party will always start with a rainbow brains and every 5 rounds
	 * the head and tail of the dance line will be removed.
	 */

	private LinkedList<Zombie> congaLine;
	private ZombieHatColor[] zombieHats;

	public RainbowZombieCongaLine() {

		congaLine = new LinkedList<Zombie>();
		zombieHats = ZombieHatColor.values();

	}

	// Make the passed in zombie the first Zombie in the conga line!
	public void engine(Zombie dancer) {
		Zombie zomb = new Zombie(dancer.getZombieHatColor());
		jumpInTheLine(zomb, 1);
	}

	// Make the passed in zombie the last Zombie in the conga line!
	public void caboose(Zombie dancer) {
		congaLine.add(dancer);
	}

	// Place the zombie at the designated position in the conga line!
	public void jumpInTheLine(Zombie dancer, int position) {
		Node<Zombie> newNode = new Node<Zombie>(dancer);
		newNode.setNext(null);
		if (position == 1) {
			LinkedList<Zombie> tempList = new LinkedList<Zombie>();
			while(congaLine.getHead()!=null) {
				tempList.add(congaLine.getHead().getValue());
				congaLine.remove(0);
			}
			congaLine.add(dancer);
			while(tempList.getHead()!=null) {
				congaLine.add(tempList.getHead().getValue());
				tempList.remove(0);
			}
		} else {
			Node<Zombie> temp = new Node<Zombie>(dancer);
			temp = congaLine.getHead();
			for (int i = 1; i < position - 1; i++) {
				if (temp != null) {
					temp = temp.getNext();
				}
			}
			if (temp != null) {
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
			}
		}
	}

	/*
	 * Remove all zombies with the same hat color as the passed in zombie from the
	 * conga line!
	 */
	public void everyoneOut(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		LinkedList<Zombie> tempList = new LinkedList<Zombie>();
		while(congaLine.getHead().getNext()!=null) {
			if(congaLine.getHead().getValue().getZombieHatColor() != hatColor) {
				tempList.add(congaLine.getHead().getValue());
			}
			congaLine.setHead(congaLine.getHead().getNext());
		}
		tempList.add(congaLine.getHead().getValue());
		congaLine.remove(0);
		while(tempList.getHead().getNext() != null) {
			congaLine.add(tempList.getHead().getValue());
			tempList.remove(0);
		}
		congaLine.add(tempList.getHead().getValue());
	}

	/*
	 * Remove the first zombie with the same hat color as the passed in zombie from
	 * the conga line!
	 */
	public void youAreDone(Zombie dancer) {
		ZombieHatColor hatColor = dancer.getZombieHatColor();
		LinkedList<Zombie> temp = new LinkedList<Zombie>();
		Node<Zombie> congaHead = congaLine.getHead();
		int counter = 0;
		while(congaHead!=null) {
			if(congaHead.getValue().getZombieHatColor() != hatColor) {
				temp.add(congaHead.getValue());
			}
			else if(congaHead.getValue().getZombieHatColor() == hatColor && counter==0) {
				counter++;
			}
			else if(counter == 1) {
				temp.add(congaHead.getValue());
			}
			else {}
			congaHead = congaHead.getNext();
			congaLine.remove(0);
		}
		Node<Zombie> tempHead = temp.getHead();
		while(tempHead!=null) {
			congaLine.add(tempHead.getValue());
			tempHead=tempHead.getNext();
			temp.remove(0);
		}
	}

	/*
	 * Make two more zombies with the same hat color as the passed in zombie and add
	 * one to the front, one to the end and one in the middle.
	 */
	public void brains(Zombie dancer) {
		jumpInTheLine(dancer, 1);
		congaLine.add(dancer);
		jumpInTheLine(dancer, congaLine.size()/2);
	}

	/*
	 * Add the passed in zombie to the front and then add one zombie of each hat
	 * color to the end of the line.
	 */
	public void rainbowBrains(Zombie dancer) {
		LinkedList<Zombie> temp = new LinkedList<Zombie>();
		temp.add(dancer);
		Node<Zombie> congaHead = congaLine.getHead();
		while(congaHead!=null) {
			temp.add(congaHead.getValue());
			congaHead = congaHead.getNext();
			congaLine.remove(0);
		}
		ZombieHatColor[] hatColors = ZombieHatColor.values();
		for(ZombieHatColor hatColor : hatColors) {
			temp.add(new Zombie(hatColor));
		}
		
		Node<Zombie> tempHead = temp.getHead();
		while(tempHead!=null) {
			congaLine.add(tempHead.getValue());
			tempHead=tempHead.getNext();
			temp.remove(0);
		}
	}

	public LinkedList<Zombie> getCongaLine() {
		return congaLine;
	}
}
