
public class OrderReceipt {
  private ArrayList<ItemReceipt> items;
  private int totalProfit;

  public OrderReceipt() {
    totalProfit = 0;
    items = new ArrayList<ItemReceipt>(0);
  }

  public OrderReceipt(ArrayList<ItemReceipt> itemReceipts) {
    items = itemReceipts;
    // TODO: count totalProfit based on the given itemReceipts
  }
}
