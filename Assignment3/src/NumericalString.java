public class NumericalString {
	public static boolean legalNumericString(String s, int b) {
	    /* in this task at first i check the input  and then start 
	    working on the string by going over every char in the string 
	    and check if the char is less than base if we fund a char is
	    larger than our base  we return false an stop going over 
	    the rest of the string */
    	if(s==null | b<2 | b>10 )
    		throw new IllegalArgumentException("Wrong input");
        boolean ans = true;
      //  if(s.length()>=2 & toInt(s.charAt(s.length()-1))==0){
       // 	ans=false;
      //  }
        if(s.length()==0)
        	ans=false;
        for(int i=0;i<s.length()& ans;i++){
            if( toInt(s.charAt(i))>=b | toInt(s.charAt(i))==-1)
            ans=false;
        }
        if(s.length()>=2 & ans && toInt(s.charAt(s.length()-1))==0){
        	ans=false;
        }
        //Task 3.1
        return ans;
    }


	public static String decimalIncrement(String s) {
	    /* in this task i used help func that contains a
	    new int that help checking if we found a place 
	    for the one if the firs num was 9 we put 0 and
	    go to the second number in the string till we 
	    found a place that can hold the hand */
    	if(!legalNumericString(s,10)) {
    		throw new IllegalArgumentException("Wrong input");
    	}
        String ans = "";
        if(s.length()==1 & toInt(s.charAt(0))<9){
            ans=ans+(toInt(s.charAt(0))+1);
        }
        else{
            ans=decimalIncrement(s,1);
        }
        //Task 3.2
        return ans;
    }
    
    public static String decimalIncrement(String s,int hand) {
        String  answer="";
        if(s.length()==0 & hand==0){
            answer="";
        }
        else if(s.length()==0 & hand==1){
            answer="1";
            
        }
        else if(toInt(s.charAt(0))==9 ){
            answer="0"+decimalIncrement(s.substring(1),1);
        }
        else{
            answer=answer+(toInt(s.charAt(0))+hand)+s.substring(1);
        }
        
        return answer;
    }

	public static String decimalDouble(String s) {
	    /* in this task i also got some help from int hand
	    in help func and go over every char and multibly it
	    by 2 and but 1 if the total was mor than 9 and send
	    the hand to the next char */
    	if(!legalNumericString(s,10)) {
    		throw new IllegalArgumentException("Wrong input");
    	}
        String ans = "";
        if(s.length()==1 & toInt(s.charAt(0))*2<9){
            ans=ans+(toInt(s.charAt(0))*2);
        }
        else{
            ans=decimalDouble(s,0);
        }
        //Task 3.2
        return ans;
    }
    
    public static String decimalDouble(String s,int hand) {
        String  answer="";
        if(s.length()==0 & hand==0){
            answer="";
        }
        else if(s.length()==0 & hand==1){
            answer="1";
            
        }
        else if(toInt(s.charAt(0))*2>9){
            answer=(toInt(s.charAt(0))*2%10+hand)+decimalDouble(s.substring(1),1);
        }
        else{
            answer=answer+(toInt(s.charAt(0))*2 +hand)+decimalDouble(s.substring(1),0);
        }
        
        return answer;
    }

    public static String binary2Decimal(String s) {
        /* in this task i used help func and the two 
        func that i did in the last tasks(decimalDouble+decimalIncrement)
        at first i start with the first char if it's 0 i send the rest of
        the string to the decimalDouble, if it's 1 i send the rest of the 
        string to the decimalDouble and decimalIncrement if we have 1011
        its like (1+2*(0+2*(1+2*(1))))*/
    	if(!legalNumericString(s,2)) {
    		throw new IllegalArgumentException("Wrong input");
    	}
        String ans = "";
        if(s.length()==1&s.charAt(0)==0){
            ans="0";
        }
        else{
          ans=  binary2Decima(s);
        }

        //Task 3.4
        return ans;
    }
        public static String binary2Decima(String s) {
        String answer = "";
        if(s.length()==1)
        answer=answer+s.charAt(0); 
        else{
            if(toInt(s.charAt(0))==0)
            answer= decimalDouble(binary2Decima(s.substring(1)));
            else if(toInt(s.charAt(0))==1)
            answer= decimalIncrement(decimalDouble(binary2Decima(s.substring(1))),1);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("hellow world");
    }
    public static int toInt(char c) {
        return "0123456789".indexOf(c);
    }
}
