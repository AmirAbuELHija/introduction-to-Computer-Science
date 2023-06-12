public class TestStringIterator {

	public static void main(String[] args) {
		StringIterator iter = new StringIterator("");
		for (int i = 1; i < 21; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
	}

}
