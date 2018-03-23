import java.util.ArrayList;

public class Warehouse {
  public int ID;
  private ArrayList<Item> inventory;

  // constructors
  public Warehouse(int eyeDee, ArrayList<Item> inv) {
    ID = eyeDee;
    inventory = inv;
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
}
