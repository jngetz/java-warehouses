import java.util.ArrayList;
import java.lang.Throwable;

public class Inventory {
    private ArrayList<Warehouse> inventory;

    public Inventory() {
	inventory = new ArrayList<Warehouse>();
    }

    public Inventory(ArrayList<Warehouse> inv) {
	inventory = inv;
    }

    public String toString() {
	String str = "";
	for (Warehouse warehouse : inventory) {
	    str += "Warehouse "+warehouse.ID+":\n";
	    str += warehouse.toString()+"\n";
	}
	return str;
    }

    public boolean addWH(Warehouse w) {
	return inventory.add(w);
    }

    public boolean removeWH(int index) {
	try {
	    inventory.remove(index);
	    return true;
	}
	catch (IndexOutOfBoundsException e) {
	    return false;
	}
    }

    public Warehouse get(int index) {
	Warehouse rv;
	if ((index < inventory.size()) && (index >= 0)) {
	    rv = inventory.get(index);
	}
	else {
	    rv = new Warehouse(-1); // error will be id < 0
	}
	return rv;
    }

    public OrderReceipt fillOrder(ArrayList<IntPair> order) {
	OrderReceipt receipt = new OrderReceipt();
	for(IntPair request : order){
	    int remaining = request.second;
	    ItemReceipt itemReceipt = new ItemReceipt(request.first);
	    while(remaining > 0){
		ArrayList<Warehouse> WH = this.getItems(request.first);
		Warehouse warehouse = WH.get(0);
		Item item = warehouse.get(request.first);
		int amount = item.numToBuy(remaining);
		int profit = item.profitNextBuy();
		itemReceipt.addPurchase(warehouse, amount);
		item.setCS(item.getCS() - amount);
	    }
	    OrderReceipt.addItemReceipt(itemReceipt);
	}
	return receipt;
    }
  public ArrayList<Warehouse> getItems(int id) {
    ArrayList<Warehouse> newlist = new ArrayList<Warehouse>();
    for (Warehouse wh : inventory) {
      Item item = wh.get(id);
      if (item.ID != -1) {
        int count = 0;
          count++;
        while(item.profitNextBuy() < wh.getIndex(count)) {
        }
        newlist.add(count, wh);
      }
    }
  }
  public int getAllItem(int id) {
    int sum = 0;
    for (Warehouse : inventory) {
      Item item = wh.get(id);
      if (item.ID != -1) {
        sum += item.getCS();
      }
    }
    return sum;
  }
}
