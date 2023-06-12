
import java.util.Scanner;


public class Task3b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 5;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        int k=scanner.nextInt();
        int test=1;
        while( n!=0 ) {//loop to calculate (2^n)%k
        	test=((2%k)*test)%k;
        	n=n-1;
        }
        ans=test;
        //---------------write your code ABOVE this line only!--------------
 
        System.out.println(ans);
		scanner.close();
    }
}