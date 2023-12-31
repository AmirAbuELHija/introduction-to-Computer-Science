//version 1.0.4
import java.util.*;
public class Test {
    public static void main(String[] args) {
        //runAllTests();    //Runs all the tests
        //testPartA();
        //testPartB();
        //testPartC();
//        testQ1E1();       //Runs tests for 1.1
//        testQ1E2();       //Runs tests for 1.2
//        testQ2E1a();      //Runs tests for 2.1 addFirst
//        testQ2E1b();      //Runs tests for 2.1 addLast
//        testQ2E1c();      //Runs tests for 2.1 removeFirst
//        testQ2E1d();      //Runs tests for 2.1 removeLast
//        testQ2E2a();      //Runs tests for 2.2 addFirst - requires the implementation of toString in BitList
//        testQ2E2b();      //Runs tests for 2.2 addLast - requires the implementation of toString in BitList
//        testQ2E2c();      //Runs tests for 2.2 removeFirst - requires the implementation of toString in BitList
//        testQ2E2d();      //Runs tests for 2.2 removeLast - requires the implementation of toString in BitList
//        testQ2E3();       //Runs tests for 2.3
//        testQ2E4();       //Runs tests for 2.4
//        testQ2E5a();      //Runs tests for 2.5 isReduced
//        testQ2E5b();      //Runs tests for 2.5 reduce
//        testQ2E6();       //Runs tests for 2.6
//        testQ2E7a();      //Runs tests for 2.7 shiftRight
//        testQ2E7b();      //Runs tests for 2.7 shiftLeft
//        testQ2E8();       //Runs tests for 2.8
//        testQ3E1();       //Runs tests for 3.1 requires the implementation of toString in BinaryNumber
//        testQ3E3();       //Runs tests for 3.3
//        testQ3E4();       //Runs tests for 3.4
//        testQ3E5a();      //Runs tests for 3.5 tests negation only
//        testQ3E5b();      //Runs tests for 3.5 tests correct form of addition with negation
//        testQ3E6();       //Runs tests for 3.6
//        testQ3E7();       //Runs tests for 3.7
//        testQ3E8();       //Runs tests for 3.8
//        testQ3E9();       //Runs tests for 3.9
//        testQ3E10();       //Runs tests for 3.10
//        testQ3E11();       //Runs tests for 3.11
//        testQ3E12();       //Runs tests for 3.12
//        testQ3E13();       //Runs tests for 3.13
//      BinaryNumber a=new BinaryNumber("-6549876567893233234");
//      System.out.print(a.toIntString());
      
    }

    private static void runAllTests() {
        testPartA();
        testPartB();
        testPartC();
    }

    private static void testPartA() {
        testQ1E1();
        testQ1E2();
    }

    private static void testPartB() {
        testQ2E1a();
        testQ2E1b();
        testQ2E1c();
        testQ2E1d();
        testQ2E2a();
        testQ2E2b();
        testQ2E2c();
        testQ2E2d();
        testQ2E3();
        testQ2E4();
        testQ2E5a();
        testQ2E5b();
        testQ2E6();
        testQ2E7a();
        testQ2E7b();
        testQ2E8();
    }

    private static void testPartC() {
        testQ3E1();
        testQ3E3();
        testQ3E4();
        testQ3E5a();
        testQ3E5b();
        testQ3E6();
        testQ3E7();
        testQ3E8();
        testQ3E9();
        testQ3E10();
        testQ3E11();
        testQ3E12();
        testQ3E13();
    }

    private static void testQ1E1() {
        boolean passed = true;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ZERO},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            output = Bit.fullAdderSum(inputs[i][0], inputs[i][1], inputs[i][2]);
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q1E1");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ1E2() {
        boolean passed = true;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ZERO},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            output = Bit.fullAdderCarry(inputs[i][0], inputs[i][1], inputs[i][2]);
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q1E2");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E1a() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.getFirst();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E1a");
                System.out.println("When using addFirst only on these inputs, getFirst() should return: " + expectedOutputs[i] + " But output was: " + output);
            }
            if (bitList.getNumberOfOnes() != 1) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E1a");
                System.out.println("Expected numberOfOnes: " + 1 + " But output was: " + bitList.getNumberOfOnes());
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E1b() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addLast(element);
            output = bitList.getFirst();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E1b");
                System.out.println("When using addLast only on these inputs, getFirst() should return: " + expectedOutputs[i] + " But output was: " + output);
            }
            if (bitList.getNumberOfOnes() != 1) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E1b");
                System.out.println("Expected numberOfOnes: " + 1 + " But output was: " + bitList.getNumberOfOnes());
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E1c() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.removeFirst();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+ " in Q2E1c");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E1d() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.removeLast();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E1d");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E2a() {
        boolean passed = true;
        BitList output;
        Bit[][] inputs = {{},
                {null},
                {Bit.ZERO, null, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ZERO},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<>", "java.lang.IllegalArgumentException", "java.lang.IllegalArgumentException", "<000>", "<001>", "<010>", "<011>", "<100>", "<101>", "<110>", "<111>"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = new BitList();
                for (Bit element : inputs[i])
                    output.addFirst(element);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2a");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2a");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E2b() {
        boolean passed = true;
        BitList output;
        Bit[][] inputs = {{},
                {null},
                {Bit.ZERO, null, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ZERO},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<>", "java.lang.IllegalArgumentException", "java.lang.IllegalArgumentException", "<000>", "<100>", "<010>", "<110>", "<001>", "<101>", "<011>", "<111>"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = new BitList();
                for (Bit element : inputs[i])
                    output.addLast(element);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E2c() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO, Bit.ONE, Bit.ZERO, Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.removeFirst();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2c");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E2d() {
        boolean passed = true;
        BitList bitList;
        Bit output;
        Bit[][] inputs = {{Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE}};
        Bit[] expectedOutputs = {Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.removeLast();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E2d");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E3() {
        boolean passed = true;
        BitList bitList, output;
        Bit[][] inputs = {null,
                {},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ZERO},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "<>", "<000>", "<001>", "<010>", "<011>", "<100>", "<101>", "<110>", "<111>"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                if (inputs[i] != null) {
                    bitList = new BitList();
                    for (Bit element : inputs[i])
                        bitList.addFirst(element);
                } else
                    bitList = null;
                output = new BitList(bitList);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E3");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
                if (output.getNumberOfOnes() != bitList.getNumberOfOnes()) {
                    passed = false;
                    System.out.println("Failed: numberOfOnes isn't correct" +" in Q2E3");
                }
                output.addFirst(Bit.ZERO);
                if (output.equals(bitList)) {
                    passed = false;
                    System.out.println("Failed: Copy isn't a deep copy"+" in Q2E3");
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E3");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E4() {
        boolean passed = true;
        BitList bitList;
        boolean output;
        Bit[][] inputs = {{},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO}};
        boolean[] expectedOutputs = {false, true, true, false, true, true};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.isNumber();
            if (output != expectedOutputs[i]) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E4");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E5a() {
        boolean passed = true;
        BitList bitList;
        boolean output;
        Bit[][] inputs = {{},
                {Bit.ONE},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE}};
        boolean[] expectedOutputs = {false, false, true, true, false, true, true, false, true, false, false, false};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.isReduced();
            if (output != expectedOutputs[i]) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E5a");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E5b() {
        boolean passed = true;
        BitList output;
        Bit[][] inputs = {{},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<>", "<0>", "<01>", "<1000>", "<101>", "<110>", "<11>", "<101100>", "<0>", "<11000>", "<0111>"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = new BitList();
                for (Bit element : inputs[i])
                    output.addFirst(element);
                output.reduce();
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E5b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E5b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E6() {
        boolean passed = true;
        BitList bitList, output;
        Bit[][] inputs = {{},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<>", "<1>", "<10>", "<01>", "<010>", "<001>", "<000000>", "<010011>", "<1111111>", "<000111>", "<111000>"};
        for (int i = 0; i < inputs.length; i++) {
            bitList = new BitList();
            for (Bit element : inputs[i])
                bitList.addFirst(element);
            output = bitList.complement();
            if (!output.toString().equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E6");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }


    private static void testQ2E7a() {
        boolean passed = true;
        BitList output;
        Bit shift;
        Bit[][] inputs = {{},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<>", "<>", "<>", "<>", "<>", "<>", "<111>", "<101>", "<0000>", "<111>", "<000>"};
        Bit[][] expectedShifts = {{null, null, null},
                {Bit.ZERO, null, null},
                {Bit.ONE, Bit.ZERO, null},
                {Bit.ZERO, Bit.ONE, null},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ZERO, Bit.ZERO, Bit.ONE},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE}};
        for (int i = 0; i < inputs.length; i++) {
            output = new BitList();
            for (Bit element : inputs[i])
                output.addFirst(element);
            for (int j = 0; j < 3; j++) {
                shift = output.shiftRight();
                if (shift == null) {
                    if (expectedShifts[i][j] != null) {
                        passed = false;
                        System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E7a");
                        System.out.println("Expected return at rightShift number " + (j + 1) + ": " + expectedShifts[i][j] + " But output was: " + shift);
                    }
                } else if (!shift.equals(expectedShifts[i][j])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E7a");
                    System.out.println("Expected return at rightShift number " + (j + 1) + ": " + expectedShifts[i][j] + " But output was: " + shift);
                }
            }
            if (!output.toString().equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E7a");
                System.out.println("Expected output after 3 right shifts: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E7b() {
        boolean passed = true;
        BitList output;
        Bit[][] inputs = {{},
                {Bit.ZERO},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ZERO, Bit.ZERO},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ONE, Bit.ONE, Bit.ONE}};
        String[] expectedOutputs = {"<000>", "<0000>", "<01000>", "<10000>", "<101000>", "<110000>", "<111111000>", "<101100000>", "<0000000000>", "<111000000>", "<000111000>"};
        for (int i = 0; i < inputs.length; i++) {
            output = new BitList();
            for (Bit element : inputs[i])
                output.addFirst(element);
            output.shiftLeft();
            output.shiftLeft();
            output.shiftLeft();
            if (!output.toString().equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E7b");
                System.out.println("Expected output after 3 left shifts: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ2E8() {
        boolean passed = true;
        BitList output;
        Bit[][] inputs = {
                {Bit.ZERO},
                {Bit.ONE},
                {Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO},
                {Bit.ONE, Bit.ZERO, Bit.ONE},
                {Bit.ONE, Bit.ZERO, Bit.ZERO},
                {Bit.ONE, Bit.ONE, Bit.ONE, Bit.ONE},
                {Bit.ONE, Bit.ONE, Bit.ZERO, Bit.ONE, Bit.ONE},
                {Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO, Bit.ZERO}};
        String[] expectedOutputs = { "<00000>", "<11111>", "<00001>", "<11110>", "<11101>", "<11100>", "<11111>", "<11011>", "<0000000>"};
        for (int i = 0; i < inputs.length; i++) {
            output = new BitList();
            for (Bit element : inputs[i])
                output.addFirst(element);
            try {
                output.padding(5);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E8");
                    System.out.println("Expected output after padding to 5: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + Arrays.toString(inputs[i])+" in Q2E8");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E1() {
        boolean passed = true;
        BinaryNumber output;
        char[] inputs = {'!', 'a', '0', '1', '2', '7', '9'};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "java.lang.IllegalArgumentException", "0", "01", "010", "0111", "01001"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = new BinaryNumber(inputs[i]);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E1");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E1");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E3() {
        boolean passed = true;
        boolean output;
        BinaryNumber[] inputs = {new BinaryNumber('1'), new BinaryNumber('1'), new BinaryNumber('1'), new BinaryNumber('1'), new BinaryNumber('2'), new BinaryNumber('6'), new BinaryNumber('7')};
        Object[] inputs2 = {'!', 123, "aa", new BinaryNumber('1'), new BinaryNumber('1'), new BinaryNumber('2'), new BinaryNumber('7')};
        boolean[] expectedOutputs = {false, false, false, true, false, false, true};
        for (int i = 0; i < inputs.length; i++) {
            output = inputs[i].equals(inputs2[i]);
            if (output != expectedOutputs[i]) {
                passed = false;
                System.out.println("Failed on input: " + inputs[i] + ".equals(" + inputs2[i] + ")"+" in Q3E3");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E4() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('7'), new BinaryNumber('7'), new BinaryNumber('2'), new BinaryNumber('0'), new BinaryNumber('0'), new BinaryNumber('7')};
        BinaryNumber[][] inputs2 = {{null},
                {new BinaryNumber('1')},
                {new BinaryNumber('9'), new BinaryNumber('9')},
                {new BinaryNumber('1')},
                {new BinaryNumber('0')},
                {new BinaryNumber('1'), new BinaryNumber('9'), new BinaryNumber('9'), new BinaryNumber('9'), new BinaryNumber('9')}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "01000", "010100", "01", "0", "0101100"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = inputs[i];
                for (BinaryNumber number : inputs2[i])
                    output = output.add(number);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    String additionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            additionChain = " + null" + additionChain;
                        else
                            additionChain = " + " + number + additionChain;
                    System.out.println("Failed on input: " + inputs[i] + additionChain+" in Q3E4");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
                if (!inputs2[i][0].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return arguments back to legal state" +" in Q3E4");
                }
                if (!inputs[i].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return calling object back to legal state" +" in Q3E4");
                }
            } catch (Exception e) {
                if (!inputs[i].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return calling object back to legal state" +" in Q3E4");
                }
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    String additionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            additionChain = " + null" + additionChain;
                        else
                            additionChain = " + " + number + additionChain;
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i] + additionChain+" in Q3E4");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E5a() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('0'), new BinaryNumber('1'), new BinaryNumber('8'), new BinaryNumber('9').add(new BinaryNumber('7'))};
        String[] expectedOutputs = {"0", "11", "11000", "110000"};
        for (int i = 0; i < inputs.length; i++) {
            output = inputs[i].negate();
            if (!output.toString().equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + inputs[i]+" in Q3E5a");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
            if (!inputs[i].isLegal()) {
                passed = false;
                System.out.println("Failed: didn't return calling object back to legal state" +" in Q3E5a");
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E5b() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('7'), new BinaryNumber('7').negate(), new BinaryNumber('2'), new BinaryNumber('0'), new BinaryNumber('0'), new BinaryNumber('1')};
        BinaryNumber[][] inputs2 = {{null},
                {new BinaryNumber('1')},
                {new BinaryNumber('9').negate(), new BinaryNumber('9').negate()},
                {new BinaryNumber('1').negate()},
                {new BinaryNumber('0').negate()},
                {new BinaryNumber('1').negate(), new BinaryNumber('9'), new BinaryNumber('9').negate(), new BinaryNumber('9').negate(), new BinaryNumber('9')}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "1010", "110000", "11", "0", "0"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = inputs[i];
                for (BinaryNumber number : inputs2[i])
                    output = output.add(number);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    String additionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            additionChain = " + null" + additionChain;
                        else
                            additionChain = " + " + number + additionChain;
                    System.out.println("Failed on input: " + inputs[i] + additionChain+" in Q3E5b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
                if (!inputs2[i][0].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return arguments back to legal state" +" in Q3E5b");
                }
                if (!inputs[i].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return calling object back to legal state" +" in Q3E5b");
                }
            } catch (Exception e) {
                if (!inputs[i].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return calling object back to legal state" +" in Q3E5b");
                }
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    String additionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            additionChain = " + null" + additionChain;
                        else
                            additionChain = " + " + number + additionChain;
                    System.out.println("Failed on input: " + inputs[i] + additionChain+" in Q3E5b");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E6() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('7'), new BinaryNumber('7'), new BinaryNumber('2'), new BinaryNumber('0'), new BinaryNumber('0'), new BinaryNumber('7')};
        BinaryNumber[][] inputs2 = {{null},
                {new BinaryNumber('1')},
                {new BinaryNumber('9'), new BinaryNumber('9')},
                {new BinaryNumber('1')},
                {new BinaryNumber('0')},
                {new BinaryNumber('1'), new BinaryNumber('9'), new BinaryNumber('9'), new BinaryNumber('9'), new BinaryNumber('9')}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "0110", "110000", "11", "0", "100010"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = inputs[i];
                for (BinaryNumber number : inputs2[i])
                    output = output.subtract(number);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    String subtractionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            subtractionChain = " - null" + subtractionChain;
                        else
                            subtractionChain = " - " + number + subtractionChain;
                    System.out.println("Failed on input: " + inputs[i] + subtractionChain+" in Q3E6");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
                if (!inputs2[i][0].isLegal()) {
                    passed = false;
                    System.out.println("Failed: didn't return arguments back to legal state"+" in Q3E6");
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    String subtractionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            subtractionChain = " - null" + subtractionChain;
                        else
                            subtractionChain = " - " + number + subtractionChain;
                    System.out.println("Failed on input: " + inputs[i] + subtractionChain+" in Q3E6");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E7() {
        boolean passed = true;
        int output;
        BinaryNumber[] inputs = {new BinaryNumber('7'), new BinaryNumber('0'), new BinaryNumber('4').negate(), new BinaryNumber('7').negate()};
        int[] expectedOutputs = {1, 0, -1, -1};
        for (int i = 0; i < inputs.length; i++) {
            output = inputs[i].signum();
            if (output != expectedOutputs[i]) {
                passed = false;
                System.out.println("Failed on input: " + inputs[i]+" in Q3E7");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E8() {
        boolean passed = true;
        String output;
        BinaryNumber[] inputs = {new BinaryNumber('7'), new BinaryNumber('7'), new BinaryNumber('0'), new BinaryNumber('4').negate(), new BinaryNumber('7'), new BinaryNumber('7')};
        BinaryNumber[] inputs2 = {null, new BinaryNumber('7'), new BinaryNumber('0').negate(), new BinaryNumber('4'), new BinaryNumber('7').negate(), new BinaryNumber('6')};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "0", "0", "-1", "1", "1"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = String.valueOf(inputs[i].compareTo(inputs2[i]));
                if (!output.equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i] + " compared to " + inputs2[i]+" in Q3E8");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i] + " compared to " + inputs2[i]+" in Q3E8");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E9() {
        boolean passed = true;
        String output;
        BinaryNumber[] inputs = {new BinaryNumber('7'),
                new BinaryNumber('0'),
                new BinaryNumber('4').negate(),
                new BinaryNumber('8').add(new BinaryNumber('8')).add(new BinaryNumber('8')).add(new BinaryNumber('8')).negate(),
                calculate2Power31(),
                calculate2Power31Minus1(),
                calculate2Power31().negate(),
                calculate2Power31().negate().subtract(new BinaryNumber('1')),
                calculate2Power31().negate().add(new BinaryNumber('1')),
                calculate2Power32Minus1().negate()};
        String[] expectedOutputs = {"7", "0", "-4", "-32", "java.lang.RuntimeException", "2147483647", "-2147483648", "java.lang.RuntimeException", "-2147483647", "java.lang.RuntimeException"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = String.valueOf(inputs[i].toInt());
                if (!output.equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E9");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E9");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static BinaryNumber calculate2Power32Minus1() {
        BinaryNumber binaryNumber = new BinaryNumber('8');
        for (int i = 0; i < 29; i++) {
            binaryNumber = binaryNumber.add(binaryNumber);
        }
        return binaryNumber.subtract(new BinaryNumber('1'));
    }

    private static BinaryNumber calculate2Power31Minus1() {
        BinaryNumber binaryNumber = new BinaryNumber('8');
        for (int i = 0; i < 28; i++) {
            binaryNumber = binaryNumber.add(binaryNumber);
        }
        return binaryNumber.subtract(new BinaryNumber('1'));
    }

    private static BinaryNumber calculate2Power31() {
        BinaryNumber binaryNumber = new BinaryNumber('8');
        for (int i = 0; i < 28; i++) {
            binaryNumber = binaryNumber.add(binaryNumber);
        }
        return binaryNumber;
    }

    private static void testQ3E10() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('7'),
                new BinaryNumber('7'),
                new BinaryNumber('0'),
                new BinaryNumber('4'),
                new BinaryNumber('8').add(new BinaryNumber('8')).add(new BinaryNumber('8')).add(new BinaryNumber('8')).negate(),
                new BinaryNumber('8').add(new BinaryNumber('8')).add(new BinaryNumber('8')).add(new BinaryNumber('8'))};
        BinaryNumber[][] inputs2 = {{null},
                {new BinaryNumber('7')},
                {new BinaryNumber('8')},
                {new BinaryNumber('4').negate()},
                {new BinaryNumber('8'), new BinaryNumber('2'), new BinaryNumber('2').negate()},
                {new BinaryNumber('8'), new BinaryNumber('0').negate()}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "0110001", "0", "110000", "010000000000", "0"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = inputs[i];
                for (BinaryNumber number : inputs2[i])
                    output = output.multiply(number);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    String multiplicationChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            multiplicationChain = " * null" + multiplicationChain;
                        else
                            multiplicationChain = " * " + number + multiplicationChain;
                    System.out.println("Failed on input: " + inputs[i] + multiplicationChain+" in Q3E10");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    String multiplicationChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            multiplicationChain = " * null" + multiplicationChain;
                        else
                            multiplicationChain = " * " + number + multiplicationChain;
                    System.out.println("Failed on input: " + inputs[i] + multiplicationChain+" in Q3E10");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E11() {
        boolean passed = true;
        BinaryNumber output;
        BinaryNumber[] inputs = {new BinaryNumber('7'),
                new BinaryNumber('7'),
                new BinaryNumber('0'),
                new BinaryNumber('8'),
                new BinaryNumber('8').add(new BinaryNumber('8')).add(new BinaryNumber('8')).add(new BinaryNumber('8')).negate(),
                new BinaryNumber('8').add(new BinaryNumber('8')).add(new BinaryNumber('8')).add(new BinaryNumber('8')),
                calculate2Power31Minus1(),
                calculate2Power31().negate()};
        BinaryNumber[][] inputs2 = {{null},
                {new BinaryNumber('7')},
                {new BinaryNumber('8')},
                {new BinaryNumber('4').negate()},
                {new BinaryNumber('8'), new BinaryNumber('2').negate()},
                {new BinaryNumber('8'), new BinaryNumber('0').negate()},
                {new BinaryNumber('8')},
                {new BinaryNumber('2')}};
        String[] expectedOutputs = {"java.lang.IllegalArgumentException", "01", "0", "110", "010", "java.lang.RuntimeException", "01111111111111111111111111111", "11000000000000000000000000000000"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = inputs[i];
                for (BinaryNumber number : inputs2[i])
                    output = output.divide(number);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    String divisionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            divisionChain = " / null" + divisionChain;
                        else
                            divisionChain = " / " + number + divisionChain;
                    System.out.println("Failed on input: " + inputs[i] + divisionChain+" in Q3E11");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    String divisionChain = "";
                    for (BinaryNumber number : inputs2[i])
                        if (number == null)
                            divisionChain = " / null" + divisionChain;
                        else
                            divisionChain = " / " + number + divisionChain;
                    System.out.println("Failed on input: " + inputs[i] + divisionChain+" in Q3E11");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E12() {
        boolean passed = true;
        BinaryNumber output;
        String[] inputs = {"0", "-32", "a", null, "-", "-4923456", "1216543424684948123215", "-354224848179261915075"};
        String[] expectedOutputs = {"0", "1100000","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException","java.lang.IllegalArgumentException", "101101001101111111000000", "010000011111001011101110011101110011101001000111100000101110111001001111", "1011001100110000100100100010010101100000111010011010110100000000111101"};
        for (int i = 0; i < inputs.length; i++) {
            try {
                output = new BinaryNumber(inputs[i]);
                if (!output.toString().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E12");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
                }
            } catch (Exception e) {
                if (!e.getClass().getCanonicalName().equals(expectedOutputs[i])) {
                    passed = false;
                    System.out.println("Failed on input: " + inputs[i]+" in Q3E12");
                    System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + e.getClass().getCanonicalName());
                }
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }

    private static void testQ3E13() {
        boolean passed = true;
        String output;
        BinaryNumber[] inputs = {new BinaryNumber('7'),
                new BinaryNumber('8').negate(),
                new BinaryNumber("100"),
                new BinaryNumber("354224848179261915075"),
                new BinaryNumber("354224848179261915075").negate(),
                new BinaryNumber("0").negate()};
        String[] expectedOutputs = {"7", "-8", "100", "354224848179261915075", "-354224848179261915075", "0"};
        for (int i = 0; i < inputs.length; i++) {
            output = inputs[i].toIntString();
            if (!output.equals(expectedOutputs[i])) {
                passed = false;
                System.out.println("Failed on input: " + inputs[i]+" in Q3E13");
                System.out.println("Expected output: " + expectedOutputs[i] + " But output was: " + output);
            }
        }
        if (passed)
            System.out.println("Passed all tests");
    }
}