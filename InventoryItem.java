public class InventoryItem {
    int quantity;
    String description = "N/A";

    // Default Constructor
    InventoryItem() {}

    // Parameterized Constructor
    InventoryItem(int quantity, String description) {
        this.quantity = quantity;
        this.description = description;
    }
}