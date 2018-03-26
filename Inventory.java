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
}
