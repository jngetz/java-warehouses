# Warehouses Problem
## using Object-Oriented Programming

To compile and run do the following:
1. javac IntPair.java Item.java Warehouse.java ItemReceipt.java OrderReceipt.java Inventory.java test_main.java
2. java test

To make changes to the test, modify the file test_main.java.

create Items using the constructor
Item(int ID, int Current_Stock, int Minimum_Stock, int Profit, int Cost)

create Warehouses using constructor
Warehouse(int ID)

create Inventory using constructor
Inventory()

create IntPair using constructor
IntPair(int ID, int Amount)

add intpairs to an ArrayList<IntPair> using the .add(IntPair) method

add items to a warehouse using the .addItem(Item i) method

add warehouses to an inventory using the .add(Warehouse warehouse) method

fill the order by running the .fillOrder(ArrayList<IntPair> order) method for
Inventory object

print the results by printing the output of .fillOrder

print the warnings by running the method .printWarnings() for Inventory object
