import java.util.ArrayList;

class test {
  public static void main(String[] args) {
    // inventory construction
    Item a = new Item(0,2,1,2,1);
    Item b = new Item(1,2,1,1,0);
    Warehouse alpha = new Warehouse(1);
    alpha.addItem(b);
    alpha.addItem(a);

    Item c = new Item(2,2,1,2,1);
    Item d = new Item(1,2,1,1,0);
    Warehouse beta = new Warehouse(2);
    beta.addItem(d);
    beta.addItem(c);
    Inventory iota = new Inventory();
    iota.addWH(beta);
    iota.addWH(alpha);

    // order construction
    ArrayList<IntPair> order = new ArrayList<IntPair>();
    IntPair ipa = new IntPair(1,3);
    IntPair ipb = new IntPair(0,1);
    IntPair ipc = new IntPair(2,2);
    order.add(ipa);
    // should fill as profit total $3, 2 from wh 1, 1 from wh 2
    order.add(ipb);
    // should fill as profit total $2, 1 from wh 1
    order.add(ipc);
    // should fill as profit total $3, 2 from wh 2

    // fill order
    OrderReceipt receipt = iota.fillOrder(order);
    receipt.print();
    System.out.println("");
    iota.printWarnings();
  }
}
