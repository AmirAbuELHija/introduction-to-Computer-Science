
class Change{

    public static boolean change(int [] coins, int n){
        /*in this task id used a help func that hase new
        variable to help me check if i can chnge n from the
        coins i have this int(i) help me go over the coins 
        and check if i can change the n by these coins, by checking 
        every sulotin and it stops when the func founds answer  */
        boolean ans = false;
        ans=change(coins,n,0);
        //Task 2.1
        return ans;
    }
       public static boolean change(int [] coins, int n, int i)
       {
        boolean answer = false;
        if(n==0){
	        answer =true;
	    }
	    else if(n<0 | i==coins.length){
	          answer = false;                                                         
	    }
	    else {
	        answer=change(coins,n-coins[i],i) 
	        || change(coins,n,i+1);
	        
	    }
        
        return answer;
    }

       public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        /*in this task id used a help func that hase new
        variable to help me check if i can chnge n from the
        coins i have this int(i) help me go over the coins 
        and check if i can change the n by these coins and 
        the numOfCoinsToUse that i have to use, by checking 
        every sulotin and it stops when the func founds answer  */
           boolean ans = false;
           ans=changeLimited(coins,n,numOfCoinsToUse,0);
           //Task 2.1
           return ans;
       }
       public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse,int i){
           boolean answer = false;
           if(n==0 & numOfCoinsToUse>=0){
   	        answer =true;
   	    }
   	    else if(n<0 | i==coins.length){
   	          answer = false;                                                         
   	    }
   	    else {
   	        answer=changeLimited(coins,n-coins[i],numOfCoinsToUse-1,i) 
   	        || changeLimited(coins,n,numOfCoinsToUse,i+1);
   	        
   	    }
           
           return answer;
       }

   	public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        /*in this task id used a help func that hase new
        variable(acc) that i printed if i found an answer.
        check if i can change n from the coins i have this 
        int(i) help me go over the coins and check if i can
        change the n by these coins and the numOfCoinsToUse that
        i have to use, by checking  every sulotin and it stops when 
        the func founds answer and print it */
	    boolean a=printChangeLimited(coins,n,numOfCoinsToUse,0 ,"");
        //Task 2.3
    }
    public static boolean printChangeLimited(int[] coins, int n, int numOfCoinsToUse,int i ,String acc){
           boolean answer = false;
           if(n==0 & numOfCoinsToUse>=0){
            System.out.println(acc.substring(0,acc.length()-1));
   	        answer =true;
   	    }
   	    else if(n<0 | i==coins.length){
   	          answer = false;                                                         
   	    }
   	    else {
   	        answer=printChangeLimited(coins,n-coins[i],numOfCoinsToUse-1,i,acc+coins[i]+",") 
   	        || printChangeLimited(coins,n,numOfCoinsToUse,i+1,acc);
   	        
   	    }
           
           return answer;
       }

	public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
	    /* in this task i used a help func that returns the number of answers 
	    that i have (change the n from coins by specific numOfCoinsToUse) the help func
	    go for all the sulotins and return 1 for every answer she found and 0 else*/
		   return countChangeLimited(coins,n,numOfCoinsToUse ,0);
	        //Task 2.5
	    }
	    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse ,int i){
	        int answer=0;
	        if(n==0 & numOfCoinsToUse>=0){
	   	        answer= 1;
	   	    }
	   	    else if(n<0 | i==coins.length){
	   	          answer=0;                                                        
	   	    }
	   	    else {
	   	       answer= countChangeLimited(coins,n-coins[i],numOfCoinsToUse-1,i)
	   	        +countChangeLimited(coins,n,numOfCoinsToUse,i+1);
	   	        
	   	    }
	   	    return answer;
	       }

	public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
	    /* in this task i used a help func that print the answers 
	    that i have (change the n from coins by specific numOfCoinsToUse) the help func
	    go for all the sulotins and print the sulotin if it meet our conditions */
	    printAllChangeLimited(coins,n,numOfCoinsToUse ,0,"");
        //Task 2.5
    }
    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse ,int i, String acc){
        if(n==0 & numOfCoinsToUse>=0){
   	        System.out.println(acc.substring(0,acc.length()-1));
   	    }
   	    else if(n<0 | i==coins.length){
   	          return;                                                        
   	    }
   	    else {
   	        printAllChangeLimited(coins,n-coins[i],numOfCoinsToUse-1,i,acc+coins[i]+","); 
   	        printAllChangeLimited(coins,n,numOfCoinsToUse,i+1,acc);
   	        
   	    }
   	    
       }
 

}
