import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	// Complete the following methods
	public void balance(){
		// task 5b
		Iterator<BankAccount> inorder=super.iterator();
		List<BankAccount> BankAccountsList=new DynamicArray<BankAccount>();
		while(inorder.hasNext()) {
			BankAccount test=inorder.next();
			BankAccountsList.add(test);
			super.remove(test);
		}
		buildBalancedTree(BankAccountsList,0,BankAccountsList.size()-1);
	}
	
	private void buildBalancedTree(List<BankAccount> list, int low, int high){
		// task 5b
		if(low>high)
			return;
		int mid=(low+high+1)/2;

		super.insert(list.get(mid));
		buildBalancedTree(list,mid+1,high);
		buildBalancedTree(list,low,mid-1);
	}
	
}
