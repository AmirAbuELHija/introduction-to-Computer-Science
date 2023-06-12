/*
I, <Amir abu el hija > (<213034655>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
 */

import java.util.LinkedList;
import java.util.Iterator;

public class BitList extends LinkedList<Bit> {
	private int numberOfOnes;

	// Do not change the constructor
	public BitList() {
		numberOfOnes = 0;
	}

	// Do not change the method
	public int getNumberOfOnes() {
		return numberOfOnes;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.1
	// ================================================
	/* in this task i used func from the LinkedList functions to remove/add Bits */
	public void addLast(Bit element) {
		if (element == null)
			throw new IllegalArgumentException("input argument is null");
		super.addLast(element);
		if (element.toInt() == 1)
			numberOfOnes = numberOfOnes + 1;
	}

	public void addFirst(Bit element) {
		if (element == null)
			throw new IllegalArgumentException("input argument is null");
		super.addFirst(element);
		if (element.toInt() == 1)
			numberOfOnes = numberOfOnes + 1;

	}

	public Bit removeLast() {
		if (super.isEmpty())
			throw new IllegalArgumentException("the list is empty");
		Bit toremove = super.removeLast();
		if (toremove.toInt() == 1)
			numberOfOnes = numberOfOnes - 1;

		return toremove;

	}

	public Bit removeFirst() {
		if (super.isEmpty())
			throw new IllegalArgumentException("the list is empty");
		Bit toremove = super.get(0);
		if (toremove.toInt() == 1)
			numberOfOnes = numberOfOnes - 1;
		if (super.remove(toremove)) {
			return toremove;
		}
		return toremove;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.2
	// ================================================
	/*
	 * in this task i used an iterator do go over all the Bits on this list an print
	 * them
	 */
	public String toString() {
		String output = "";
		Iterator<Bit> iter = super.iterator();
		while (iter.hasNext()) {
			output = iter.next().toString() + output;
		}

		output = "<" + output + ">";
		return output;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.3
	// ================================================
	/* in this task i copied the list using for-each to go on all the linkedlist */
	public BitList(BitList other) {
		if (other == null)
			throw new IllegalArgumentException("input argument is null");
		numberOfOnes = 0;
		for (Bit element : other)
			addLast(element);

	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.4
	// ================================================
	/* in this task i follow the definition to check if the number is correct */
	public boolean isNumber() {
		boolean answer = false;

		if (size() > 0) {
			Bit test = getLast();
			if (test.toInt() == 0 | numberOfOnes > 1)
				answer = true;
		}
		return answer;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.5
	// ================================================
	/* in this task i follow the definition to check if the number is reduced */
	public boolean isReduced() {
		boolean answer = false;
		if (isNumber()) {
			if ((super.size() == 1 && super.get(0).toInt() == 0))
				answer = true;
			else if (super.size() == 2
					&& ((super.get(super.size() - 1).toInt() == 0 & super.get(super.size() - 2).toInt() == 1)
							| (super.get(super.size() - 1).toInt() == 1 & super.get(super.size() - 2).toInt() == 1)))
				answer = true;
			else if (super.size() > 2) {
				if ((super.get(super.size() - 1).toInt() == 1 & super.get(super.size() - 2).toInt() == 1
						& numberOfOnes == 2)
						|| (super.get(super.size() - 1).toInt() == 0 & super.get(super.size() - 2).toInt() == 1)
								| super.get(super.size() - 1).toInt() == 1 & super.get(super.size() - 2).toInt() == 0) {
					answer = true;
				}
			}
		}

		return answer;
	}

	public void reduce() {

		if (isNumber())
			while (isReduced() == false) {
				removeLast();
			}
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.6
	// ================================================
	/*
	 * in this task i go in each Bit in this list and add a the opposite to a new
	 * List
	 */
	public BitList complement() {
		BitList answer = new BitList();
		for (Bit element : this) {
			if (element.toInt() == 1)
				answer.addLast(Bit.ZERO);
			else
				answer.addLast(Bit.ONE);
		}
		return answer;

	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.7
	// ================================================

	public Bit shiftRight() {
		if (isEmpty())
			return null;

		return removeFirst();
	}

	public void shiftLeft() {
		addFirst(Bit.ZERO);
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 2.8
	// ================================================
	public void padding(int newLength) {

		while (size() < newLength & !isEmpty()) {
			addLast(getLast());
		}

	}

	// ----------------------------------------------------------------------------------------------------------
	// The following overriding methods must not be changed.
	// ----------------------------------------------------------------------------------------------------------
	public boolean add(Bit e) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public void add(int index, Bit element) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public Bit remove(int index) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public boolean offer(Bit e) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public boolean offerFirst(Bit e) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public boolean offerLast(Bit e) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public Bit set(int index, Bit element) {
		throw new UnsupportedOperationException("Do not use this method!");
	}

	public boolean remove(Object o) {
		throw new UnsupportedOperationException("Do not use this method!");
	}
}
