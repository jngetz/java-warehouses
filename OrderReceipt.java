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

    public static void main(String[] args) {
	OrderReceipt order = new OrderReceipt();
	for(int j = 4; j < 20; j += 5){
	    ItemReceipt receipt = new ItemReceipt(j - 4);
	    for(int i = 1; i < 15; i++){
		Warehouse warehouse = new Warehouse(i);
		Item item = new Item(j-4, i, 0, j-i, 0);
		warehouse.addItem(item);
		receipt.addPurchase(warehouse, 15-i);
	    }
	    order.addItemReceipt(receipt);
	}
	order.print();
    }
}


