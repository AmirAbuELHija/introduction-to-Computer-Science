import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class test2 {

	public static void main(String[] args) {
		runAllTests();    //Runs all the tests
		//testPartA();      //Runs all tests for part A
		//testPartB();      //Runs all tests for part B
		//testPartC();      //Runs all tests for part C
		//testPartD();      //Runs all tests for Part D
		//testQ1E1();       //Runs tests for 1.1
		//testQ1E2();       //Runs tests for 1.2
		//testQ1E3();       //Runs tests for 1.3
		//testQ1E4();       //Runs tests for 1.4, needs parameter n to run n times
		//testQ2E1();       //Runs tests for 2.1
		//testQ2E2();       //Runs tests for 2.2
		//testQ2E3();       //Runs tests for 2.3
		//testQ2E4();       //Runs tests for 2.4
		//testQ2E5();       //Runs tests for 2.5
		//testQ3E1();       //Runs tests for 3.1
		//testQ3E2();       //Runs tests for 3.2
		//testQ3E3();       //Runs tests for 3.3
		//testQ3E4();       //Runs tests for 3.4
		//testQ4E1E2E3();   //Runs tests for 4.1, 4.2, 4.3
		//testQ4E4E5();     //Runs tests for 4.4, 4.5


	}


	private static void runAllTests() {
		testPartA();
		testPartB();
		testPartC();
		testPartD();
	}


	private static void testPartA() {
		System.out.println("Testing 1.1: ");
		testQ1E1();
		System.out.println();
		System.out.println("Testing 1.2: ");
		testQ1E2();
		System.out.println();
		System.out.println("Testing 1.3: ");
		testQ1E3();
		System.out.println();
		int n = 2 + (int) (Math.random() * 5);
		System.out.println("Testing 1.4 " + n + " times: ");
		testQ1E4(n);
		System.out.println();

	}

	private static void testPartB() {
		System.out.println("Testing 2.1: ");
		testQ2E1();
		System.out.println();
		System.out.println("Testing 2.2: ");
		testQ2E2();
		System.out.println();
		System.out.println("Testing 2.3: ");
		testQ2E3();
		System.out.println();
		System.out.println("Testing 2.4: ");
		testQ2E4();
		System.out.println();
		System.out.println("Testing 2.5: ");
		testQ2E5();
		System.out.println();
	}
	
	private static void testPartC() {
		System.out.println("Testing 3.1: ");
		testQ3E1();
		System.out.println();
		System.out.println("Testing 3.2: ");
		testQ3E2();
		System.out.println();
		System.out.println("Testing 3.3: ");
		testQ3E3();
		System.out.println();
		System.out.println("Testing 3.4: ");
		testQ3E4();
		System.out.println();
	}
	
	private static void testPartD() {
		System.out.println("Testing 4.1 ,4.2 ,4.3: ");
		testQ4E1E2E3();
		System.out.println();
		System.out.println("Testing 4.4, 4.5: ");
		testQ4E4E5();
		System.out.println();
	}


	private static void testQ1E1() {
		boolean passed = true;
		BigInteger output;
		String[] inputs = {"-10", "0", "7", "99999"};
		String[] expectedOutputs = {"0", "0", "21", "4999850001"};
		for (int i = 0; i < inputs.length; i++) {
			output = Assignment3BigInteger.sumSmaller(new BigInteger(inputs[i]));
			if (!output.equals(new BigInteger(expectedOutputs[i]))) {
				passed = false;
				System.out.println("Failed on input: " + inputs[i]);
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static void testQ1E2() {
		int n = (int) (Math.random() * 11);
		System.out.println("Expected " + n + " random integers");
		Assignment3BigInteger.printRandoms(n);
	}

	private static void testQ1E3() {
		boolean passed = true;
		boolean output;
		String[] inputs = {"274876858367", "4398042316799", "3576702497", "5915587277"};
		boolean[] expectedOutputs = {true, true, false, true};
		for (int i = 0; i < inputs.length; i++) {
			output = Assignment3BigInteger.isPrime(new BigInteger(inputs[i]));
			if (output != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + inputs[i]);
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static void testQ1E4(int timesToTest) {
		boolean passed = true;
		BigInteger bi, twoToThePowerOfN;
		for (int i = 0; i < timesToTest; i++) {
			int n = 2 + (int) (Math.random() * 14);
			twoToThePowerOfN = twoToThePowerOfN(n);
			bi = Assignment3BigInteger.randomPrime(n);
			if (!Assignment3BigInteger.isPrime(bi)) {
				passed = false;
				System.out.println("Failed: The returned number " + bi + " isn't prime according to your function Assignment3BigInteger.isPrime");
			}
			if (bi.compareTo(twoToThePowerOfN) != -1) {
				passed = false;
				System.out.println("Failed: The returned number " + bi + " isn't smaller than 2^" + n + "=" + twoToThePowerOfN);
			}
			if (bi.compareTo(BigInteger.ONE) != 1) {
				passed = false;
				System.out.println("Failed: The returned number " + bi + " isn't bigger than 1");
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static BigInteger twoToThePowerOfN(int n) {
		byte[] bits;
		byte activeBit = 1;
		int count = 1 + (n / 8);
		for (int i = 0; i < n % 8; i++) {
			activeBit *= 2;
		}
		if (activeBit < 0) {
			count += 1;
			bits = new byte[count];
			bits[1] = activeBit;
		} else {
			bits = new byte[count];
			bits[0] = activeBit;
		}
		return new BigInteger(bits);
	}

	private static void testQ2E1() {
		boolean passed = true;
		boolean output;
		int[][] inputs = {{2, 3}, {8, 9}, {2, 5, 10}, {2, 5, 10}, {2, 10, 20, 100}};
		int[] inputs2 = {2, 59, 13, 16, 15};
		boolean[] expectedOutputs = {true, true, true, true, false};
		for (int i = 0; i < inputs.length; i++) {
			output = Change.change(inputs[i], inputs2[i]);
			if (output != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " , " + inputs2[i]);
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static void testQ2E2() {
		boolean passed = true;
		boolean output;
		int[][] inputs = {{2, 3}, {2, 3}, {3, 7, 8, 9, 12}, {3, 56, 164, 167}, {7, 8, 9, 12, 13, 17, 19, 21, 26, 38}, {2, 3}};
		int[] inputs2 = {3, 2, 165, 165, 165, 2};
		int[] inputs3 = {1, 1, 15, 54, 23, 1};
		boolean[] expectedOutputs = {true, true, true, false, true, true};
		for (int i = 0; i < inputs.length; i++) {
			output = Change.changeLimited(inputs[i], inputs2[i], inputs3[i]);
			if (output != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " , " + inputs2[i] + " , " + inputs3[i]);
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static void testQ2E3() {
		int[][] inputs = {{2, 3}, {2, 3}, {3, 7, 8, 9, 12}, {3, 7, 8, 9, 12, 13, 17, 19, 21, 26, 38}, {7, 8, 9, 12, 13, 17, 19, 21, 26, 38}, {2, 3}};
		int[] inputs2 = {3, 2, 165, 165, 165, 2};
		int[] inputs3 = {1, 1, 15, 3, 23, 1};
		boolean[] expectedOutputs = {true, true, true, false, true, true};
		for (int i = 0; i < inputs.length; i++) {
			if (expectedOutputs[i]) {
				System.out.println("A solution should be printed:");
				Change.printChangeLimited(inputs[i], inputs2[i], inputs3[i]);
				System.out.println("Check if the sum of the printed sequence =" + inputs2[i] + ", that there is no ',' at the end, no spaces AND that it is sorted");
			} else {
				System.out.println("No solution should be printed:");
				Change.printChangeLimited(inputs[i], inputs2[i], inputs3[i]);
				System.out.println("If a sequence has been printed your code is defective");
			}
			System.out.println();
		}
	}

	private static void testQ2E4() {
		boolean passed = true;
		int output;
		int[][] inputs = {{1, 2, 3}, {5, 10, 20, 50, 100}, {5, 10, 50}};
		int[] inputs2 = {4, 100, 65};
		int[] inputs3 = {2, 5, 2};
		int[] expectedOutputs = {2, 6, 0};
		for (int i = 0; i < inputs.length; i++) {
			output = Change.countChangeLimited(inputs[i], inputs2[i], inputs3[i]);
			if (output != expectedOutputs[i]) {
				passed = false;
				System.out.println("Failed on input: " + Arrays.toString(inputs[i]) + " , " + inputs2[i] + " , " + inputs3[i]);
				System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
			}
		}
		if (passed)
			System.out.println("Passed all tests");
	}

	private static void testQ2E5() {
		int[][] inputs = {{1, 2, 3}, {5, 10, 20, 50, 100}, {5, 10, 50}};
		int[] inputs2 = {4, 100, 65};
		int[] inputs3 = {2, 5, 2};
		int[] expectedOutputs = {2, 6, 0}; //number of lines we expect as output
		for (int i = 0; i < inputs.length; i++) {
			System.out.println("We expect a print of " + expectedOutputs[i] + " lines:");
			Change.printAllChangeLimited(inputs[i], inputs2[i], inputs3[i]);
			System.out.println("Check if " + expectedOutputs[i] + " unique sequences have been printed,");
			System.out.println("if the sum of each printed sequences =" + inputs2[i] + " , that there is no ',' at the end, no spaces AND that it is sorted");
			System.out.println();
		}
	}

	private static void testQ3E1(){
		boolean passed=true;
		int[] Binputs= { -1, 0, 1, 11, 12};

		try{
			boolean ans=NumericalString.legalNumericString(null,5);
			System.out.println("Failed on input: s = null" + " expected java.lang.IllegalArgumentException" +"but output was: "+ans );
			passed=false;
		}catch (Exception e) {
			if(!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")) {
				System.out.println("Failed on input: s = null" + " expected java.lang.IllegalArgumentException");
				passed=false;
			}
		}


		for(int i=0;i<Binputs.length;i++) {
			try{
				NumericalString.legalNumericString("2",Binputs[i]);
				System.out.println("Failed on input: b ="+Binputs[i] + "expected java.lang.IllegalArgumentException" );
				passed=false;
			}catch (Exception e) {
				if(!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")) {
					System.out.println("Failed on input: b ="+Binputs[i] + "expected java.lang.IllegalArgumentException" );
					passed=false;
				}
			}
		}

		String[] inputs1 = {"0", "10", "18388", "1", "9999999", "21414235441","","ax","123x123"};
		boolean[][] expectedOutputs = { { true, true, true, true, true, true, true, true ,true},
				{ false, false, false, false, false, false, false, false,false},
				{false, false,false,false,false,false,false,true,true},
				{ true, true, true, true, true, true, true, true,true},
				{false, false,false,false,false,false,false,false,true},
				{ false, false, false, false, true, true, true, true,true},
				{ false, false, false, false, false, false, false, false,false},
				{ false, false, false, false, false, false, false, false,false},
				{ false, false, false, false, false, false, false, false,false}};
		
		for(int i=0;i<inputs1.length;i++) {
			for(int j=2 ; j<=10 ; j++) {
				if(NumericalString.legalNumericString(inputs1[i],j)!=expectedOutputs[i][j-2]) {
					
					System.out.println("Failed on inputs "+inputs1[i] + " "+j + "expected output was: "+expectedOutputs[i][j-2] );
					passed=false;
				}
			}
		}

		if(passed) {
			System.out.println("Passed all tests");	
		}

	}



	private static void testQ3E2(){
		boolean passed=true;

		String[] inputs= {"0100","","ax","123x123","6","54321","9999999999999999999999999999999999999999999999999999999999999999999999"};
		String[] expectedOutputs = {"java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","7","64321","00000000000000000000000000000000000000000000000000000000000000000000001"};
		for(int i=0;i<inputs.length;i++) {
			try {
				String ans = NumericalString.decimalIncrement(inputs[i]);
				if(!ans.equals(expectedOutputs[i])) {
					passed=false;
					System.out.println("Failed on input "+inputs[i]+" expected: "+expectedOutputs[i]);
				}
			}catch(Exception e) {
				if(!e.getClass().getCanonicalName().equals(expectedOutputs[i])){
					passed=false;
					System.out.println("Failed on input "+inputs[i]+" expected: "+expectedOutputs[i]);
				}
			}
		}
		if(passed)
			System.out.println("passed all tests");
	}

	private static void testQ3E3(){
		boolean passed=true;

		String[] inputs= {"0100","","ax","123x123","6","54321","9999999999999999999999999999999999999999999999999999999999999999999999"};
		String[] expectedOutputs = {"java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","21","09642","89999999999999999999999999999999999999999999999999999999999999999999991"};

		for(int i=0;i<inputs.length;i++) {
			try {
				String ans = NumericalString.decimalDouble(inputs[i]);
				if(!ans.equals(expectedOutputs[i])) {
					passed=false;
					System.out.println("Failed on input "+inputs[i]+" expected: "+expectedOutputs[i]);
				}
			}catch(Exception e) {
				if(!e.getClass().getCanonicalName().equals(expectedOutputs[i])){
					passed=false;
					System.out.println("Failed on input "+inputs[i]+" expected: "+expectedOutputs[i]);
				}
			}
		}
		if(passed)
			System.out.println("passed all tests");
	}

	private static void testQ3E4() {
		boolean passed=true;

		String[] inputs= {"0100","","ax","123x123","6",};

		for(int i=0;i<inputs.length;i++) {
			try {
				String ans = NumericalString.binary2Decimal(inputs[i]);

				passed=false;
				System.out.println("Failed on input "+inputs[i]+" expected: "+"java.lang.IllegalArgumentException but output was" +ans);

			}catch(Exception e) {
				if(!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")){
					passed=false;
					System.out.println("Failed on input "+inputs[i]+" expected: "+"java.lang.IllegalArgumentException but Exception was " +e.getClass().getCanonicalName());
				}
			}
		}

		String[] inputs2= {"0","1","11111111","011111111","1011","0011"};
		String[] expectedOutputs= {"0", "1", "552", "015","31","21"};
		for(int i=0;i<inputs2.length;i++) {
			String ans= NumericalString.binary2Decimal(inputs2[i]);
			if(!ans.equals(expectedOutputs[i])) {
				passed=false;
				System.out.println("Failed on input "+inputs[i]+" expected: "+expectedOutputs[i]+" but output was " +ans);
			}
		}
		String s="";
		for (int i=0; i<100; i=i+1) {
			s = s+"1";
		}
		String ans= NumericalString.binary2Decimal(s);
		if(!ans.equals("5735023076941049228220060567621")) {
			passed = false;
			System.out.println("Failed on input "+s+" expected: "+"5735023076941049228220060567621"+" but output was " +ans);
		}

		if(passed) {
			System.out.println("passed all tests");
		}
	}


	private static void testQ4E1E2E3() {
		boolean passed= true;
		
		Bit one = new Bit(true);
		Bit zero = new Bit(false);
		
		if(one.toInt()!=1) {
			passed = false;
			System.out.println("Failed with bit true, expected output: " +1+ " but output was " +one.toInt());
		}
		
		if(zero.toInt()!=0) {
			passed = false;
			System.out.println("Failed with bit false, expected output: " +0+ " but output was " +zero.toInt());
		}
		
		if(!one.toString().equals("1")) {
			passed = false;
			System.out.println("Failed with bit true, expected output: 1 but output was " +one.toString());
		}
		
		if(!zero.toString().equals("0")) {
			passed = false;
			System.out.println("Failed with bit false, expected output: 0 but output was " +zero.toString());
		}
		
		if(passed) {
			System.out.println("Passed all tests");
		}
		
	}


	private static void testQ4E4E5() {
		boolean passed=true;
		
		String[] inputs= {"",null,"00","2","s","11d0","111110000111161111"};
		for(int i=0;i<inputs.length;i++) {
			try {
				BitVector vector=new BitVector(inputs[i]);
				System.out.println("constructor failed, expected java.lang.IllegalArgumentException but value is: "+vector.toString());
				passed=false;
			}catch(Exception e) {
				if(!e.getClass().getCanonicalName().equals("java.lang.IllegalArgumentException")) {
					System.out.println("expected java.lang.IllegalArgumentException but exception is: "+e.getClass().getCanonicalName());
					passed=false;
				}
			}
		}
		
		String[] inputs2= {"0","1","11111111","011111111","1011","0011"};
		String[] expectedOutputs= {"0", "1", "255", "510","13","12"};
		BitVector vector;
		for(int i=0;i<inputs2.length;i++) {
			vector=new BitVector(inputs2[i]);
			if(!vector.toString().equals(expectedOutputs[i])) {
				System.out.println("Failed on input: "+inputs2[i]);
				System.out.println("Expected output: "+expectedOutputs[i]+" but output is: "+vector.toString());
				passed=false;
			}
		}
		
		String s="";
		for (int i=0; i<100; i=i+1) {
			s = s+"1";
		}
		
		String output="";
		String temp="5735023076941049228220060567621";
		for(int i=0;i<temp.length();i++) {
			output=output+temp.charAt(temp.length()-1-i);
		}
		
		vector = new BitVector(s);
		if(!(vector.toString()).equals(output)) {
			passed = false;
			System.out.println("Failed on input "+s+" expected: "+output+" but output was " +vector.toString());
		}

		if(passed) {
			System.out.println("passed all tests");
		}
		
	}

}
