
import java.util.Scanner;

public class Task4d {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans1 = 0;
        int ans2 = 0;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        int temp=n-1;
        int s=0;
        int d=0;
        int test =1;
        n=n-1;
        while(n!=0) {
        	if(n%2==0) {//loop to calculate s value
        	 	s=s+1;
        	 	ans1=s;
         	 	n=n/2;
        	}
        	else {
        		while( s!=0 ) {//loop to calculate d value
        			test=test*2;
        			s=s-1;
        		}
        		ans2=temp/test;
        		n=0;
        	}
        } 
        //---------------write your code ABOVE this line only!--------------
 
        System.out.println(ans1);
        System.out.println(ans2);
		scanner.close();
    }
}