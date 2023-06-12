
import java.util.Scanner;

public class Task4b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        if(n<=0) {
        	ans=0;
        }
        else {
         while(n!=0) {
        	int p=2;
        	boolean isprime =true;
        	while( p*p <= n ) {//checking if n is prime
        		if(n%p==0) {
        			isprime=false;
        		}
        		p=p+1;
         	}
        	if(isprime==true) {
        		ans=ans+1;
        	}
        	n=n-1;
         }
        ans=ans-1;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);    
		scanner.close();    
    }
}
