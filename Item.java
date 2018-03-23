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
  
}
