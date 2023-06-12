import java.util.Scanner;

public class Task4f {

    public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------
        int n=scanner.nextInt();
        int s=scanner.nextInt();
        int d=scanner.nextInt();
        int k=scanner.nextInt();
        ans =false;
        int temp=d;
        while(ans==false && k>1) {
        	int b=(int)(Math.random()*(n-3)+2);
        	int test=1;
        	while(d!=0) {//to calculate (b^d)%n
        		test=test*(b%n)%n;
        		d=d-1;
        	}
        	d=temp;
        	if(test==1) {
        		ans=true;
        	}
        	if(ans==false) {//to check b^((2^i)*d)%n
            	for(int i=0 ; i<=s-1 ; i++) {//to calculate b^((2^i)*d)%n
            		int temp1=i;
            		int os=1;
            		test=1;
            		while (temp1>0) {
            			os=os*2;
            			temp1=temp1-1;
            		}
                    os=os*d;
                	while (os!=0) {
                		test=test*(b%n)%n;
                		os=os-1;
                	}
                	
            		if( (test) == (n-1) ) {
            			ans=true;
            		}
            	}
        	}
        	k=k-1;
        }
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}