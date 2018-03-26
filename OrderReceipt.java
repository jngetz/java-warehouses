import java.util.ArrayList;

public class OrderReceipt {
    private ArrayList<ItemReceipt> items;
    private int totalProfit;

    public OrderReceipt() {
	totalProfit = 0;
	items = new ArrayList<ItemReceipt>(0);
    }
    
    public void addItemReceipt(ItemReceipt item){
	this.totalProfit = this.totalProfit + item.totalProfit;
	this.items.add(item);
    }

    public void print(){
	System.out.println("----------------------------------------");
	System.out.println("ORDER RECEIPT");
	System.out.println("--------------------");
	System.out.println();
	for(int i = 0; i < this.items.size(); i++){
	    this.items.get(i).print();
	    System.out.println("--------------");
	}
	System.out.println("Total Profit: " + this.totalProfit);
	System.out.println("----------------------------------------");
    }
}


