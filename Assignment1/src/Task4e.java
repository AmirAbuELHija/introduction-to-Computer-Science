
import java.util.Scanner;

public class Task4e {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans1 = true;
        int ans2 = 0;
 
        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        int b=scanner.nextInt();
        int s=scanner.nextInt();
        int d=scanner.nextInt();
        int temp=d;
        int test1=1;
        ans1=false;
        ans2=b;
        while ( d!=0 ) {//to calculate (b^d)%n
        	test1=test1*(b%n)%n;
        	d=d-1;
        }
        if (test1==1) {
            ans1=true;
            ans2=-1;
        } 
        if(ans1 == false) {//to check b^((2^i)*d)%n
        	for(int i=0 ; i<=s-1 ; i++) {//to calculate b^((2^i)*d)%n
        		int temp1=i;
        		int os=1;
        		int test2=1;
        		while (temp1>0) {
        			os=os*2;
        			temp1=temp1-1;
        		}
        		os=os*temp;
        		while (os!=0) {
        			test2=test2*(b%n)%n;
        			os=os-1;
        		}
        		if( (test2) == (n-1) ) {
        			ans1=true;
        			ans2=-1;
        		}

        	}
               
        	
        }
 
     
        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans1);
        System.out.println(ans2);
		scanner.close();
    }
}
