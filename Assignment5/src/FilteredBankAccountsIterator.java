import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

	private BinaryTreeInOrderIterator<BankAccount> iterator;
	private Filter<BankAccount> filter;
    private BankAccount current;
    
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, Filter<BankAccount> filter) {
        // task 5c
    	this.filter=filter;
    	this.iterator=new BinaryTreeInOrderIterator<BankAccount>(bankAccountsTree.root);
    	this.current=iterator.next();
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        // task 5c
    	return iterator.hasNext();	
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        // task 5c
    	   BankAccount temp=iterator.next();
    	   if(filter.accept(temp))
    		   return temp;
    	   else
    		   throw new NoSuchElementException("amer");
    	   
       
    	   
    }
}
