import java.util.ArrayList;
import java.lang.Throwable;

public class Warehouse {
  public int ID;
  private ArrayList<Item> inventory;
  // private Comparator<Item>;

  // constructors
  public Warehouse(int eyeDee, ArrayList<Item> inv) {
    ID = eyeDee;
    inventory = inv;
  }

  public Warehouse(int eyeDee) {
    ID = eyeDee;
    inventory = new ArrayList<Item>(0);
  }

  public Warehouse() {
    ID = 0;
    inventory = new ArrayList<Item>(0);
  }

  // get/set
  // NOTE: ID is public, no need for getter/setter function

  public ArrayList<Item> getInventory() {
    return inventory;
  }
  public void setInventory(ArrayList<Item> inv) {
    inventory = inv;
  }

  // special methods
  /*
   * takes an Item object, i, and appends it to the inventory
   * returns true iff the item was added, else false
  **/
  public boolean addItem(Item i) {
    return inventory.add(i);
  }

  /*
   * takes an int, index, of the element we wish to remove from the inventory
   * returns true iff the item was removed, else false
   *
  **/
  public boolean removeItem(int index) {
    try {
      inventory.remove(index);
      return true;
    }
    catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public Item get(int index) {
    Item rv;
    if ((index < inventory.size()) && (index >= 0)) {
      rv = inventory.get(index);
    }
    else {
      rv = new Item(-1); // error will be id < 0
    }
    return rv;
  }

  // Sort inventory by profit
  public void sortInventory() {
    inventory.sort(Item.profit);
  }
}
