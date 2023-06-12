import java.math.BigInteger;
import java.util.Random;

class Assignment3BigInteger{

    public static BigInteger sumSmaller(BigInteger n){
   /*in this task I defined two BigIntegers one(sum) for taking
   the total of the numbers and the second one(i) is to go over
   the positve numbers from 1 to n-1 and i used compareTo func 
   to check if the BigInteger(i) still less than n*/
    BigInteger sum =  new BigInteger("0");
    BigInteger i =  new BigInteger("1");
    while (i.compareTo(n)<0){
        sum=sum.add(i);
        i=i.add(BigInteger.ONE);
    } 
    //Task 1.1
    return sum;
    }

    public static void printRandoms(int n){
    /*in this task i used a func in Random 
    class that give me a random numbers*/
    Random a= new Random();
    for (int i=1;i<=n ;i++ ){
        System.out.println(a.nextInt());
    } 
    //Task 1.2
}

	public static boolean isPrime(BigInteger n){
	/*in this task i used the algorithm that we 
	learned in the class to check if the number 
	is prime but in BigInteger but i do it in a 
	way that's it works in a big numbers like 
	using compareTo & mod & multiply func in
	BigInteger class*/
    boolean ans= true;
    if(n.intValue()==0 | n.intValue()==1){
        ans= false;
    }
    BigInteger p=new BigInteger("2");
    BigInteger temp=p.multiply(p);
    while(temp.compareTo(n)<=0  & ans){
        if((n.mod(p)).compareTo(BigInteger.ZERO)==0){
            ans=false;
        }
        p=p.add(BigInteger.ONE);
        temp=p.multiply(p);
        
    }
  //Task 1.3
    return ans;
    
}

	   public static BigInteger randomPrime(int n){
	       /*in this task i used isPrime func and the Constructor 
	       BigInteger(int numBits, Random rnd) to generated BigInteger
	       that in a range 0-2^numBits-1 and then i add one to make the 
	       range from 1 to 2^numBits and check if this BigInteger isPrime
	       and i return it if isPrime  else i do it again till i found one
	       this range */ 
		    Random a= new Random();
	        BigInteger randBig = new BigInteger("0");
	        while(!isPrime(randBig)){
	        BigInteger a1=new BigInteger(n,a);
	        a1=a1.add(BigInteger.ONE);
	        randBig=a1;
	        }
	        //Task 1.4
	        return randBig;
	    }

}