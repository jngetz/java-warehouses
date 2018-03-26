import java.util.ArrayList;

public class ItemReceipt {
    int ID;
    int totalProfit;
    int numberSold;
    ArrayList<IntPair> breakdown;

    //Constructor for a receipt for a specific item
    public ItemReceipt(int itemID){
	this.ID = itemID;
	this.totalProfit = 0;
	this.numberSold = 0;
	this.breakdown = new ArrayList<IntPair>();
    }

    public void addPurchase(Warehouse warehouse, int amount) {
	int WHID = warehouse.ID;
	Item item = warehouse.get(this.ID);
	this.totalProfit = this.totalProfit + (item.profitNextBuy() * amount);
	this.numberSold = this.numberSold + amount;
	IntPair purchase = new IntPair(WHID, amount);
	if(this.breakdown.contains(purchase)){
	    int index = this.breakdown.indexOf(purchase);
	    IntPair prev = this.breakdown.get(index);
	    int new_amount = (int) prev.second + (int) purchase.second;
	    IntPair updated = new IntPair(WHID, new_amount);
	    this.breakdown.set(index, updated);
	}
	else{
	    this.breakdown.add(purchase);
	}
    }
    
    public void print() {
	System.out.println("Item " + this.ID);
	System.out.println("Number Sold: " + this.numberSold);
	System.out.println("Profit: $" + this.totalProfit);
	for(int i = 0; i < breakdown.size(); i++){
	    System.out.println("Warehouse " + this.breakdown.get(i).first +
			       " : " + this.breakdown.get(i).second);	
	}
    }

}
