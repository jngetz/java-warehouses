import java.util.Comparator;

public class Item {
  public int ID;
  private int CS;
  private int MS;
  private int PPI;
  private int CBMS;

  // constructors
  public Item(int eyeDee, int cStock, int mStock, int profit, int cost) {
    ID = eyeDee;
    CS = cStock;
    MS = mStock;
    PPI = profit;
    CBMS = cost;
  }

  public Item() {
    ID = 0;
    CS = 0;
    MS = 0;
    PPI = 0;
    CBMS = 0;
  }

  public Item(int eyeDee) {
    ID = eyeDee;
    CS = 0;
    MS = 0;
    PPI = 0;
    CBMS = 0;
  }

  // print function
  public String toString() {
    return ID+", "+CS+", "+MS+", "+PPI+", "+CBMS+"\n";
  }

  // get/set
  public int getCS() {
    return ID;
  }
  public void setCS(int i) {
    ID = i;
  }
  public int getMS() {
    return MS;
  }
  public void setMS(int i) {
    MS = i;
  }
  public int getPPI() {
    return PPI;
  }
  public void setPPI(int i) {
    PPI = i;
  }
  public int getCBMS() {
    return CBMS;
  }
  public void setCBMS(int i) {
    CBMS = i;
  }

  // special functions
  /*
   * takes an integer, x, which is the number of items still needed
   * determines the most items possible to ship at the same profit margin, y,
   * and returns the min(x,y)
   *
  **/
  public int numToBuy(int x) {
    int max = 0;
    int num = 0;
    if (CS<=MS) {
      max = CS;
    }
    else {
      max = CS-MS;
    }
    if (max<x) {
      num = max;
    }
    else {
      num = x;
    }
    return num;
  }

  /*
   * returns the profit on the next item to be shipped
   * Assumes that user already checks wether cs > 0
  **/
  public int profitNextBuy() {
    int next = 0;
    if (CS<=MS) {
      next = PPI-CBMS;
    }
    else {
      next = PPI;
    }
    return PPI;
  }

  /*
   * the camparator object for using ArrayList's sort method.
   * will force the sort of the items profit on next buy by
   * descending order
   *
  **/
  public static Comparator<Item> profit = new Comparator<Item>() {
    public int compare(Item i1, Item i2) {
      int prof1 = i1.profitNextBuy();
      int prof2 = i2.profitNextBuy();
      return prof2-prof1; //descending order as desired
    }
  };

}
