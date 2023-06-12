
import java.util.Scanner;

public class Task3a {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        ans=1;
        while(n!=0) {//loop to calculate 2^n
        	ans=ans*2;
        	n=n-1;
        }
        //---------------write your code ABOVE this line only!--------------
        System.out.println(ans);
		scanner.close();
    }
}