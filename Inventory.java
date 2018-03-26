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

  public void printWarnings() {
    boolean warning = false;
    for(Warehouse wh : this.inventory) {
      boolean whWarning = false;
      for(Item item : wh.getInventory()) {
        if(item.getCS() < item.getMS()){
          if(!warning){
            warning = true;
            System.out.println("---------------------------------");
            System.out.println("Items are below minimum stock");
            System.out.println("---------------------------------");
          }
          if(!whWarning){
            whWarning = true;
            System.out.println("Warehouse " + wh.ID + " Shortages");
            System.out.println("----------");
          }
          System.out.println("Item " + item.ID);
        }
      }
      if(whWarning){
        System.out.println("---------------------------------");
      }
    }
  }

  public OrderReceipt fillOrder(ArrayList<IntPair> order) {
    OrderReceipt receipt = new OrderReceipt();
    for(IntPair request : order){
      int remaining = request.second;
      if(this.getAllItem(request.first) < remaining){
        System.out.println("Can't meet request for item " + request.first);
      }
      else{
        ItemReceipt itemReceipt = new ItemReceipt(request.first);
        while(remaining > 0){
          ArrayList<Warehouse> WH = this.getItems(request.first);
          Warehouse warehouse = WH.get(0);
          Item item = warehouse.get(request.first);
          int amount = item.numToBuy(remaining);
          int profit = item.profitNextBuy();
          itemReceipt.addPurchase(warehouse, amount);
          item.setCS(item.getCS() - amount);
          remaining = remaining - amount;
        }
        receipt.addItemReceipt(itemReceipt);
      }
    }
    return receipt;
  }

  public ArrayList<Warehouse> getItems(int id) {
    ArrayList<Warehouse> newlist = new ArrayList<Warehouse>();
    for (Warehouse wh : inventory) {
      Item item = wh.get(id);
      if (item.ID != -1 && item.getCS() > 0) {
        int count = 0;
        while(item.profitNextBuy() < wh.getIndex(count).profitNextBuy()) {
          count++;
        }
        newlist.add(count, wh);
      }
    }
    return newlist;
  }

  public int getAllItem(int id) {
    int sum = 0;
    for (Warehouse wh : inventory) {
      Item item = wh.get(id);
      if (item.ID != -1) {
        sum += item.getCS();
      }
    }
    return sum;
  }
}
