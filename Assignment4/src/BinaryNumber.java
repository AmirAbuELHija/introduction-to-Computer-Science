/*
I, <Amir abu el hija > (<213034655>), assert that the work I submitted is entirely my own.
I have not received any part from any other student in the class,
nor did I give parts of it for use to others.
I realize that if my work is found to contain code that is not originally my own,
 a formal case will be opened against me with the BGU disciplinary committee.
 */

import java.util.Comparator;
import java.util.Iterator;

public class BinaryNumber implements Comparable<BinaryNumber> {
	private static final BinaryNumber ZERO = new BinaryNumber(0);
	private static final BinaryNumber ONE = new BinaryNumber(1);
	private BitList bits;

	// Copy constructor
	// Do not change this constructor
	public BinaryNumber(BinaryNumber number) {
		bits = new BitList(number.bits);
	}

	// Do not change this constructor
	private BinaryNumber(int i) {
		bits = new BitList();
		bits.addFirst(Bit.ZERO);
		if (i == 1)
			bits.addFirst(Bit.ONE);
		else if (i != 0)
			throw new IllegalArgumentException("This Constructor may only get either zero or one.");
	}

	// Do not chainge this method
	public int length() {
		return bits.size();
	}

	// Do not change this method
	public boolean isLegal() {
		return bits.isNumber() & bits.isReduced();
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.1
	// ================================================
	public BinaryNumber(char c) {
		if (c < '0' | c > '9') {
			throw new IllegalArgumentException("Wrong input");
		}

		int value = (c - '0');
		bits = new BitList();
		while (value > 0) {
			int digit = value % 2;
			bits.addLast(new Bit(digit));
			value = value / 2;
		}
		bits.addLast(Bit.ZERO);

	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.2
	// ================================================
	/* in this task u used the toString func from BitLis class */
	public String toString() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		return bits.toString().substring(1, bits.toString().length() - 1);
		//
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.3
	// ================================================
	/*
	 * in this task i first check if the other is instance of BN this go over all
	 * the Bits and check the value
	 */
	public boolean equals(Object other) {
		boolean answer = false;
		if (other instanceof BinaryNumber) {
			if (this.length() == ((BinaryNumber) other).length()) {
				answer = true;
				String a = this.toString();
				String b = ((BinaryNumber) other).toString();
				for (int i = 0; i < a.length() & answer; i++) {
					if (a.charAt(i) != b.charAt(i))
						answer = false;
				}

			}
		}
		return answer;

	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.4
	// ================================================
	/*
	 * in this task i used the two func from Bit class to sum Bits and check the
	 * carry from
	 */
	public BinaryNumber add(BinaryNumber addMe) {
		if (addMe == null)
			throw new IllegalArgumentException("Wrong input");
		BinaryNumber answer = new BinaryNumber(ZERO);
		BinaryNumber current = new BinaryNumber(this);
		BinaryNumber add = new BinaryNumber(addMe);
		answer.bits.clear();
		int addMeSize = addMe.length();
		int currentSize = this.length();
		current.bits.padding(addMeSize + currentSize);
		add.bits.padding(addMeSize + currentSize);
		Bit cin = new Bit(0);
		while (!current.bits.isEmpty()) {
			Bit currentFirst = current.bits.removeFirst();
			Bit addFirst = add.bits.removeFirst();
			answer.bits.addLast(Bit.fullAdderSum(currentFirst, addFirst, cin));
			cin = Bit.fullAdderCarry(currentFirst, addFirst, cin);
		}
		BinaryNumber temp = new BinaryNumber(answer);
		temp.bits.reduce();
		// answer.bits.clear();
		return temp;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.5
	// ================================================
	/* in this task i used a func from Bitlist class and the add func */
	public BinaryNumber negate() {
		BinaryNumber temp = new BinaryNumber(ZERO);
		temp.bits.clear();
		BitList answer = this.bits.complement();
		for (int i = 0; i < answer.size(); i++)
			temp.bits.addLast(answer.get(i));

		return temp.add(ONE);

	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.6
	// ================================================
	/* in this task i send the negate to the add func */
	public BinaryNumber subtract(BinaryNumber subtractMe) {// a-b=a+(-b)
		if (subtractMe == null)
			throw new IllegalArgumentException("Wrong input");
		return this.add(subtractMe.negate());
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.7
	// ================================================
	/*
	 * in this task i check the last Bit to give a number that show if he is a
	 * positive or negative
	 */
	public int signum() {
		int ans = 0;
		if (bits.getLast().toInt() == 0 & bits.size() > 1)
			ans = 1;
		else if (bits.getLast().toInt() == 1 & bits.size() > 1)
			ans = -1;

		return ans;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.8
	// ================================================
	/*
	 * in this task i used substract func to check if the answer is positive or
	 * negative
	 */
	public int compareTo(BinaryNumber other) {
		if (other == null)
			throw new IllegalArgumentException("Wrong input");
		return this.subtract(other).signum();
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.9
	// ================================================
	/*
	 * in this task i go on all Bits and convert them to decamil but first checking
	 * if the number in the range
	 */
	public int toInt() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		//

		if ((bits.size() > 33)
				| (bits.size() == 33 && bits.get(bits.size() - 2).toInt() == 1 & bits.getNumberOfOnes() == 1)
				| (bits.size() == 33 && bits.get(bits.size() - 2).toInt() == 0 & bits.getNumberOfOnes() == 32)
				| (bits.size() == 33 && bits.getLast().toInt() == 1 & bits.getFirst().toInt() == 1))
			throw new RuntimeException("number is too big to be converted to int");
		int ans = 0;
		int power = 1;
		BitList temp = new BitList();
		if (bits.getLast().toInt() == 1) {
			temp = negate().bits;
		} else
			temp = this.bits;
		for (int i = 0; i < bits.size() - 1; i++) {
			ans = ans + temp.get(i).toInt() * power;
			power = power * 2;
		}
		if (bits.getLast().toInt() == 1)
			ans = -ans;
		return ans;
	}
	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.10
	// ================================================

	// Do not change this method
	public BinaryNumber multiply(BinaryNumber multiplyMe) {
		if (multiplyMe == null)
			throw new IllegalArgumentException("Wrong input");

		if (this.signum() == -1 & multiplyMe.signum() == -1) {
			return this.negate().multiplyPositive(multiplyMe.negate());
		} else if (this.signum() == -1 & multiplyMe.signum() == 1)
			return (this.negate().multiplyPositive(multiplyMe)).negate();
		else if (this.signum() == 1 & multiplyMe.signum() == -1)
			return (this.multiplyPositive(multiplyMe.negate())).negate();
		else
			return multiplyPositive(multiplyMe);
	}

	private BinaryNumber multiplyPositive(BinaryNumber multiplyMe) {
		BinaryNumber temp = multiplyMe;
		BinaryNumber ans = new BinaryNumber('0');
		if (this.equals(new BinaryNumber('0')) | multiplyMe.equals(new BinaryNumber('0')))
			return new BinaryNumber('0');
		for (int i = 0; i < this.bits.size() - 1; i++) {
			if (this.bits.get(i).toInt() == 1) {
				ans = ans.add(temp);
			}
			temp = temp.multiplyBy2();
			ans.bits.reduce();
		}

		return ans;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.11
	// ================================================
	// Do not change this method
	public BinaryNumber divide(BinaryNumber divisor) {
		if (divisor == null)
			throw new IllegalArgumentException("Wrong input");

		// Do not remove or change the next two lines
		if (divisor.equals(ZERO)) // Do not change this line
			throw new RuntimeException("Cannot divide by zero."); // Do not change this line
		//
		if (this.signum() == -1 & divisor.signum() == -1) {
			return this.negate().dividePositive(divisor.negate());
		} else if (this.signum() == -1 & divisor.signum() == 1)
			return (this.negate().dividePositive(divisor)).negate();
		else if (this.signum() == 1 & divisor.signum() == -1)
			return (this.dividePositive(divisor.negate())).negate();
		else if (this.equals(divisor))
			return new BinaryNumber('1');
		else
			return dividePositive(divisor);
	}

	private BinaryNumber dividePositive(BinaryNumber divisor) {
		BinaryNumber ans = new BinaryNumber('0');
		BinaryNumber current = new BinaryNumber(this);
		ans.bits.clear();
		BinaryNumber test = new BinaryNumber('0');
		if (this.equals(ZERO))
			return new BinaryNumber('0');

		while (!current.bits.isEmpty()) {
			Bit currentLast = current.bits.removeLast();
			test.bits.addFirst(currentLast);
			if (divisor.compareTo(test) == 1) {
				ans.bits.addFirst(Bit.ZERO);
			} else {
				test = test.subtract(new BinaryNumber(divisor));
				ans.bits.addFirst(Bit.ONE);
			}
			ans.bits.reduce();
			test.bits.reduce();
		}
		BinaryNumber temp = new BinaryNumber(ans);
		return temp;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.12
	// ================================================
	/*
	 * in this task i go on all the string and the value of the char in his place
	 * and sum all the chars value
	 */
	public BinaryNumber(String s) {
		if (s == null)
			throw new IllegalArgumentException("Wrong input");
		BinaryNumber Ten = new BinaryNumber('9').add(ONE);
		BinaryNumber Power = new BinaryNumber('1');
		BinaryNumber ans = new BinaryNumber('0');
		char c = s.charAt(0);
		if (c == '-') {
			s = s.substring(1);
		}
		if (!legalNumericString(s, 10))
			throw new IllegalArgumentException("Wrong input");
		for (int i = s.length() - 1; i >= 0; i--) {
			char a = s.charAt(i);
			ans = ans.add(new BinaryNumber(a).multiply(Power));
			Power = Power.multiply(Ten);
		}
		if (c == '-')
			this.bits = ans.negate().bits;
		else
			this.bits = ans.bits;

	}

	public static int toInt(char c) {
		return "0123456789".indexOf(c);
	}

	public static boolean legalNumericString(String s, int b) {
		/*
		 * in this task at first i check the input and then start working on the string
		 * by going over every char in the string and check if the char is less than
		 * base if we fund a char is larger than our base we return false an stop going
		 * over the rest of the string
		 */
		if (s == null | b < 2 | b > 10)
			throw new IllegalArgumentException("Wrong input");
		boolean ans = true;
		if (s.length() == 0)
			ans = false;
		for (int i = 0; i < s.length() & ans; i++) {
			if (toInt(s.charAt(i)) >= b | toInt(s.charAt(i)) == -1)
				ans = false;
		}
		// Task 3.1
		return ans;
	}

	// =========================== Intro2CS 2021, ASSIGNMENT 4, TASK 3.13
	// ================================================
	/*
	 * in this task i took the List and divide the current number to ten and again
	 * multibly it by ten to get the last number of the string till i get to Zero
	 */
	public String toIntString() {
		// Do not remove or change the next two lines
		if (!isLegal()) // Do not change this line
			throw new RuntimeException("I am illegal.");// Do not change this line
		//
		BinaryNumber Ten = new BinaryNumber("10");
		BinaryNumber temp = this;
		String answer = "";
		if (this.signum() == -1)
			this.negate().toIntString();
		while (!temp.equals(new BinaryNumber('0'))) {
			BinaryNumber divideTenMultiplyTen = temp.divide(Ten).multiply(Ten);

			BinaryNumber subtractresult = temp.subtract(divideTenMultiplyTen);
			int a = subtractresult.toInt();
			if (a < 0)
				a = -a;
			answer = a + answer;
			temp = temp.divide(Ten);

		}
		if (this.signum() == -1)
			answer = "-" + answer;
		else if (this.equals(ZERO))
			answer = "0";
		return answer;
	}

	// Returns this * 2
	public BinaryNumber multiplyBy2() {
		BinaryNumber output = new BinaryNumber(this);
		output.bits.shiftLeft();
		output.bits.reduce();
		return output;
	}

	// Returns this / 2;
	public BinaryNumber divideBy2() {
		BinaryNumber output = new BinaryNumber(this);
		if (!equals(ZERO)) {
			if (signum() == -1) {
				output.negate();
				output.bits.shiftRight();
				output.negate();
			} else
				output.bits.shiftRight();
		}
		return output;
	}

}
