public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;
	public FilterByBalance(int balanceThreshold) {
        // task 5c
        this.balanceThreshold=balanceThreshold;
	}
	@Override
	public boolean accept(BankAccount elem) {
		// task 5c
		if(elem.getBalance()>=balanceThreshold)
			return true;
		else
			return false;
	}
}
