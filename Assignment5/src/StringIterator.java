import java.util.Iterator;

public class StringIterator implements Iterator<String> {

	// Complete the following methods
	private String start;
	private String after;
	private int first;

	public StringIterator(String start) {
		if (start == null)
			throw new IllegalArgumentException("Wrong OutPut");
		this.start = start;
		after = start;
		first = 1;

	}

	public boolean hasNext() {
		boolean answer = true;
		if (after.length() == 2147483647)
			answer = false;
		return answer;
	}

	public String next() {
		if (!hasNext())
			throw new IllegalArgumentException("thats it no other String");
		String next = "";
		if (first == 1) {
			next = start;
			first = 0;
		} else
			next = prepareNext();
		return next;

	}

	private String prepareNext() {
		String next = "";
		boolean checkifdone = false;
		for (int i = after.length() - 1; i >= 0; i--) {
			if (this.after.charAt(i) != 'Z' & !checkifdone) {
				next = giveMeTheNextChar(this.after.charAt(i)) + next;
				checkifdone = true;
			} else if (this.after.charAt(i) == 'Z')
				next = giveMeTheNextChar(this.after.charAt(i)) + next;
			else if (checkifdone)
				next = String.valueOf(this.after.charAt(i)) + next;
		}
		if (checkifdone == false)
			next = "a" + next;
		this.after = next;

		return after;

	}

	private String giveMeTheNextChar(char c) {
		if (c >= 'a' & c < 'z') {
			c = (char) (c + 1);
			return String.valueOf(c);
		}
		if (c == 'z')
			return "A";
		else if (c >= 'A' & c < 'Z') {
			c = (char) (c + 1);
			return String.valueOf(c);
		} else
			return "a";
	}

}
