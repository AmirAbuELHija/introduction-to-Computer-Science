

public class Assignment2 {

	/*-----------------------
	 *| Part A - tasks 1-11 |
	 * ----------------------*/
    public static void main(String args[])
    
    {
    	boolean[] []ans=	{{false, true, true, true, false, false, false, false, false, false, false, false},
   			 {true, false, true, false, true, false, false, false, false, false, false, false}, 
   			 {true, true, false, false, false, true, false, false, false, false, false, false},
   			 {true, false, false, false, true, false, true, false, false, false, false, false}, 
   			 {false, true, false, true, false, false, false, true, false, false, false, false},
   			 {false, false, true, false, false, false, false, false, true, true, false, false}, 
   			 {false, false, false, true, false, false, false, false, true, false, true, false}, 
   			 {false, false, false, false, true, false, false, false, false, false, true, true}, 
   			 {false, false, false, false, false, true, true, false, false, false, false, true}, 
   			 {false, false, false, false, false, true, false, false, false, false, true, true}, 
   			 {false, false, false, false, false, false, true, true, false, true, false, false},
   			 {false, false, false, false, false, false, false, true, true, true, false, false}};
    	System.out.print(solve2(ans));
    	int[] a=solve(ans);
    	for(int i=0;i<a.length;i++) {
    		System.out.print(a[i]);
    	}
    }
    
	// task 1
	public static boolean isSquareMatrix(boolean[][] matrix) {
		boolean answer=true;//A variable that returns the answer
		if(matrix==null || matrix.length==0) 
		    answer = false;
		else {
		   for(int i=0;i<matrix.length;i++) {//checking if the lines equals the columns
			   if(matrix[i].length!=matrix.length) 
			   	answer=false;
			
		   }
		}
		return answer;
	}
	
	// task 2
	public static boolean isSymmetricMatrix(boolean[][] matrix) {
		boolean answer=true;//A variable that returns the answer
		for(int i=0;i<matrix.length & answer;i++) {
			for(int j=0;j<matrix.length & answer;j++) {
				if(matrix[i][j]!=matrix[j][i])//checking if it's Symmetric Matrix
					answer=false;
			}
		}
		return answer;
	}

	// task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix) {
	    boolean answer=true;//A variable that returns the answer
	    for(int i=0;i<matrix.length;i++) {
	    	if(matrix[i][i]!=false)//checking if it's Anti Reflexive Matrix
	    		answer=false;
	    }
	    return answer;
    }
	
	// task 4
	public static boolean isLegalInstance(boolean[][] matrix) {
		boolean answer=false;//A variable that returns the answer
		if( isSquareMatrix(matrix) & isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix))
			answer=true;
		return answer;	
	}
	
	// task 5
	public static boolean isPermutation(int[] array) {
		boolean answer=true;//A variable that returns the answer
	    for(int i=0;i<array.length;i++){
	       for(int j=i+1;j<array.length;j++){
	           if(array[i]==array[j])
	              answer = false;
	       }
     	}
	    if(answer) {
	       for(int i=0;i<array.length;i++) {
	               if(array[i]<0||array[i]>=array.length){
	                   answer= false;
	               }
	       }
	    }
	    return answer;
    }
	
	// task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour) {
	    boolean answer=true;//A variable that returns the answer
	    for(int i=0;i<flights.length-1;i++){
	        if(flights[tour[i]][tour[i+1]]!=true & flights[flights.length-1][0]!=true){
	            answer =false;
	        }
	    }
	    return answer;
		
	}
	
	// task 7
	public static boolean isSolution(boolean[][] flights, int[] tour) {
	    boolean answer = false;//A variable that returns the answer
	    if(isPermutation(tour)&tour[0]==0&hasLegalSteps(flights,tour)){
	        answer = true;
	    }
	    return answer;

	}
	// task 8
	public static boolean evaluate(int[][] cnf, boolean[] assign) {
	    boolean answer=true;//A variable that returns the answer
     	for(int i=0;i<cnf.length;i++){
     	    if(evaluateClause(cnf[i],assign)==false){
     	        answer=false;
     	    }
     	    
     	}
     	return answer;

	}
	
	//Auxiliary functions
	public static boolean evaluateLiteral(int literal, boolean[] assign){
	    boolean answer;//A variable that returns the answer
	    if(literal<0){
	       answer=!assign[-literal];
	    }
	    else{
	        answer=assign[literal];
	    }
	    return answer;
	}
	
	public static boolean evaluateClause(int[] clause, boolean[] assign){
	    boolean answer=false;//A variable that returns the answer
	    for (int i=0;i<clause.length;i++){
	        if(evaluateLiteral(clause[i],assign)){
	            answer=true;
	        }
	    }
	    return answer;
	}
	public static boolean isConsiderations(int[] a,int[] b) {
		boolean answer=true;//A variable that returns the answer
		for(int i=1; i<a.length;i++) {
			if(a[i]!=b[a.length-i]) {
				answer=false;
			}
		}
		return answer;
	}
	//Auxiliary functions
	

	// task 9
	public static int[][] atLeastOne(int[] lits){
	    int[][] answer=new int[1][];//A variable that returns the answer
        answer[0]=lits;
        return answer;
	}

	// task 10
	public static int[][] atMostOne(int[] lits) {
	    int k=((lits.length)*(lits.length-1))/2;
	    int[][] cnf=new int[k][2];//A variable that returns the answer
	    int idx=0;//index that help adding clause to the cnf
		for(int i=0;i<lits.length;i++){
		    for(int j=i+1;j<lits.length;j++){
		        int[] clause={-lits[i],-lits[j]};
		        cnf[idx]=clause;
		        idx++;
		    }
		    
		}
		return cnf;
	}
	
	// task 11
	public static int[][] exactlyOne(int[] lits) {
	    int k=((lits.length)*(lits.length-1))/2+1;
	    int[][] cnf=new int[k][];//A variable that returns the answer
	    int[][] firstmatrix=atMostOne(lits);//matrix that contains atmostone on the lits
	    int[][] secondmatrix=atLeastOne(lits);//matrix that contains atleastone on the lits
        for(int i=0;i<k-1;i++){
            cnf[i]=firstmatrix[i];
        }
        cnf[k-1]=secondmatrix[0];
	    return cnf;
	
}
	
	/*------------------------
	 *| Part B - tasks 12-20 |
	 * -----------------------*/
	
	// task 12a
	public static int map(int i, int j, int n){
	    int answer=0;//A variable that returns the answer
	    answer=(i*n)+j+1;
	    return answer;
	}
	
	// task 12b
	public static int[] reverseMap(int k, int n){
	    int counter=1;//variable that help gitting the i & j of the litral
	    boolean test=false;//variable that help stopping the loop when it finds the i & j
	    int[] reverse=new int[2];//A variable that returns the answer
	    for(int i=0;i<n & !test;i++){
	        for(int j=0;j<n & !test;j++){
	            if(counter==k){
	               reverse[0]=i;
	               reverse[1]=j;
	               test=true;
	            }
	            else
	            counter=counter+1;
	        }
	    }
	    return reverse;
	}
	
	// task 13
	public static int[][] oneCityInEachStep(int n) {
		int[][] cnf=new int[0][];//A variable that returns the answer
	    int[][] literal=new int[n][n];//helping variables
	    int x=1;//helping variables
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            literal[i][j]=x;
	            x=x+1;
	        }
	    }
	    for(int i=0;i<n;i++){
	        cnf=newMatrix(cnf,exactlyOne(literal[i]));
	    }
	    return cnf;
	    
	}
	public static int[][] newMatrix(int[][] a, int[][] b){//function that compain two matrixs
	    int[][] answer=new int[a.length+b.length][];//A variable that returns the answer
	    int i=0;
	    for(i=0;i<a.length;i++){
	        answer[i]=a[i];
	    }
	    for(int j=0;j<b.length;j++){
	        answer[i]=b[j];
	        i++;  
	    }
	    return answer;
	}
	

	// task 14
	public static int[][] eachCityIsVisitedOnce(int n){
		int[][] cnf=new int[0][];//A variable that returns the answer
	    int[][] literal=new int[n][n];////matrix that contains the litrals
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            literal[i][j]=map(j,i,n);
	           
	        }
	    }
	    for(int i=0;i<n;i++){
	        cnf=newMatrix(cnf,exactlyOne(literal[i]));
	    }
	    return cnf;
	}
	
	// task 15
	public static int[][] fixSourceCity(int n){
	    int cnf[][]={{map(0,0,n)}};//A variable that returns the answer
	    return cnf;
	}
	
	// task 16
	public static int[][] noIllegalSteps(boolean[][] flights){
	    int[][] cnf=new int[0][];//A variable that returns the answer
	    for(int i=0;i<flights.length-1;i++){
	        for(int j=0;j<flights.length;j++){
	            for(int k=0;k<flights.length;k++){
                   if(flights[j][k]==false&j!=k){
                       int[][] tempcnf={{-map(i,j,flights.length),-map(i+1,k,flights.length)}};
                       cnf=newMatrix(cnf,tempcnf);
                   }
                   
	            }
	        }
	    }
	    for(int k=1;k<flights.length;k++){
	        if(flights[k][0]==false){
	            int[][] tempcnf={{-map(flights.length-1,k,flights.length)}};
	            cnf=newMatrix(cnf,tempcnf);
	        }
	    }
	    return cnf;
	}
	
	// task 17
	public static int[][] encode(boolean[][] flights){
	    int[][] cnf=new int[0][];//A variable that returns the answer
	    cnf=newMatrix(cnf,oneCityInEachStep(flights.length));
	    cnf=newMatrix(cnf,eachCityIsVisitedOnce(flights.length));
	    cnf=newMatrix(cnf,fixSourceCity(flights.length));
	    cnf=newMatrix(cnf,noIllegalSteps(flights));
	    return cnf;
	}

	// task 18
	public static int[] decode(boolean[] assignment, int n){
	    int[] tour=new int[n];//A variable that returns the answer
	    if(assignment==null)
	        throw new IllegalArgumentException();
	    if(assignment.length!=n*n+1)
	        throw new IllegalArgumentException();
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(assignment[map(i,j,n)]==true){
	                tour[i]=j;
	            }
	        }
	    }

	    return tour;
	}
	
	// task19
	public static int[] solve(boolean[][] flights){
		if(!isLegalInstance(flights))
			throw new IllegalArgumentException();
	    int[] tour;//A variable that returns the answer
	    int nVars = (flights.length*flights.length);
	    SATSolver.init(nVars);
	    int[][] cnf=encode(flights);
	    SATSolver.addClauses(cnf); 
	    boolean[] assignment = SATSolver.getSolution();
	    if (assignment == null)
	    	throw new IllegalArgumentException();
	    if(assignment.length == nVars+1){
	        tour=decode(assignment,flights.length);
	        if(isSolution(flights,tour))
	           return tour;
	       else
              throw new IllegalArgumentException();
	       
	    }
	    else
	       return null;
	}
	// task20
	public static boolean solve2(boolean[][] flights) { /*in this function i took the 
	         cnf and did a changes that can help me gitting the 
		second tour like changing the first step of the tour that we got from solve */
		if(!isLegalInstance(flights))
			throw new IllegalArgumentException();
		boolean answer=true;
	    int[] tour=solve(flights);
	    for(int i=1;i<flights.length-1&answer;i++) {
	    int nVars2 = (flights.length*flights.length);
	    SATSolver.init(nVars2);
	    int[] cnf1= {-map(i,tour[i],flights.length)};
	    int[][] cnf2=encode(flights);
	    SATSolver.addClauses(cnf2); 
	    int[] tour2;
	    SATSolver.addClause(cnf1);
	    boolean[] assignment1 = SATSolver.getSolution();
	    if (assignment1 == null)
	    	throw new IllegalArgumentException();
	    if(assignment1.length == nVars2+1){
	        tour2=decode(assignment1,flights.length);
	        if(isSolution(flights,tour2)& isConsiderations(tour,tour2))
	        	answer=false;

	        
	    }
	}
	    return answer;
	}

}
