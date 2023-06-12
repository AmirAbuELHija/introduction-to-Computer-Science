public class BitVector {
    private Bit[] bits;
    public BitVector(String s) {
    	/*in this func i checked the input and puts the string in the Bit[] array
    	  by going on every char and ask hes value if 1 we define a new bits according
    	   to this value*/
    	if(!NumericalString.legalNumericString(s,2)) {
    		throw new IllegalArgumentException("Wrong input");
    	}
    	
    	bits=new Bit[s.length()];
    	for(int i=0;i<bits.length;i++) {
    		if(NumericalString.toInt(s.charAt(i))==1)
    		bits[i]=new Bit(true);
    		else
    	    bits[i]=new Bit(false);
    	}
        //Task 4.4
    }
    public String flip(String s) {
    	/*help func that flip a string (if s="13" it will be "31")*/
    	String answer="";
    	if(s.length()==0)
    		answer="";
    	else
    		answer=flip(s.substring(1))+s.charAt(0);
    	
    	
    	return answer;
    	
    }
    
	public String toString() {
		/*in this func i used the NumericalString funcs to bring
		 *  the the answer and then flip it using flip func but first 
		 *  i define a new string that contains every bits */
        String ans = "";
        for(int i=0;i<bits.length;i++) {
        	ans=ans+bits[i].toString();
        }
        ans=flip(NumericalString.binary2Decima(ans));
        
        //Task 4.5
        return ans;
    }


}
