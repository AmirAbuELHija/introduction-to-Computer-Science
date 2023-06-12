
public class Bit {

    private boolean value;

    public Bit(boolean value){
    /*constructor puts value for this value*/
    	  this.value=value;    	
        //Task 4.1
    }

    public int toInt(){ 
    	/* func return  1 if value==true else 0*/
        int ans = 0;
        if(value) {
        	ans=1;
        }
        //Task 4.2
        return ans;

    }

    public String toString(){
    	/* func prints  1 if value==true else 0*/
        String ans = "0";
        if(value)
        	ans="1";
        
        //Task 4.3
        return ans;
    }
}

