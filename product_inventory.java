import lang.stride.*;

/**
 * Write a description of class product_inventory here.
 * @author (Group 7) @version (6-2-2026)
 */
public class product_inventory
{
    // TODO: Add private attributes here
    private String productCode;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;
    private int reorderLevel;

    // TODO: Add default constructor
    /**
     * 
     */
    public product_inventory()
    {
        this.reorderLevel = 10;
    }

    
    // TODO: Add parameterized constructor

    /**
     * 
     */
    public product_inventory(String productCode, String productName, String category, double unitPrice, int quantityInStock)
    {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.reorderLevel = 10;
    }

    /**
     * 
     */
    // TODO: Add getters

    public String getProductCode()
    {
        return productCode;
    }

    /**
     * 
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * 
     */
    public String getCategory()
    {
        return category;
    }

    /**
     * 
     */
    public double getUnitPrice()
    {
        return unitPrice;
    }

    /**
     * 
     */
    public int getQuantityInStock()
    {
        return quantityInStock;
    }

    /**
     * 
     */
    public int getReorderLevel()
    {
        return reorderLevel;
    }

    /**
     * 
     */

    // TODO: Add setters with validation

    public void setUnitPrice(double unitPrice)
    {
        if (unitPrice > 0) {
            this.unitPrice = unitPrice;
        }
        else {
            System.out.println("Unit price must be greater than 0.");
        }
    }

    /**
     * 
     */
    public void setQuantityInStock(int quantityInStock)
    {
        if (quantityInStock >= 0) {
            this.quantityInStock = quantityInStock;
        }
        else {
            System.out.println("Quantity in stock must be greater than or equal to 0.");
        }
    }

    /**
     * 
     */

    // TODO: Add addStock() method
    public void setReorderLevel(int reorderLevel)
    {
        if (reorderLevel > 0) {
            this.reorderLevel = reorderLevel;
        }
        else {
            System.out.println("Reorder level must be greater than 0.");
        }
    }

    /**
     * 
     */
    public void addStock(int quantity)
    {
        if (quantity > 0) {
            quantityInStock = quantityInStock + quantity;
        }
    }

    /**
     * 
     */
    // TODO: Add sellProduct() method
    public boolean sellProduct(int quantity)
    {
        if (quantity > 0 && quantity <= quantityInStock) {
            quantityInStock = quantityInStock - quantity;
            return true;
        }
        return false;
    }

    /**
     * 
     */
    // TODO: Add calculateStockValue() method

    public double calculateStockValue()
    {
        return unitPrice * quantityInStock;
    }

    /**
     * 
     */
    // TODO: Add needsReorder() method
    public boolean needsReorder()
    {
        return quantityInStock <= reorderLevel;
    }

    /**
     * 
     */
    // TODO: Add applyDiscount() method
    public void applyDiscount(double percentage)
    {
        if (percentage > 0 && percentage < 100) {
            unitPrice = unitPrice - unitPrice * (percentage / 100);
        }
    }

    /**
     * 
     */
    // TODO: Add displayProductInfo() method
    public void displayProductInfo()
    {
        System.out.println("Product code: " + productCode);
        System.out.println("Product Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Unit price: " + unitPrice);
        System.out.println("Quantity in stock: " + quantityInStock);
        System.out.println("Reorder level: " + reorderLevel);
        System.out.println("Stock value: " + calculateStockValue());
        System.out.println("Needs reorder: " + needsReorder());
    }

    // TODO: Create product1 - "PRD001", "Laptop", "Electronics", 1500000, 25
    // TODO: Create product2 - "PRD002", "Office Chair", "Furniture", 350000, 8
    // TODO: Create product3 - "PRD003", "Notebook", "Stationery", 5000, 100

    public static void main(String[] args)
    {
        product_inventory p1 =
            new product_inventory("PRD001", "Laptop", "Electronics", 1500000, 25);

        product_inventory p2 =
            new product_inventory("PRD002", "Office Chair", "Furniture", 350000, 8);

        product_inventory p3 =
            new product_inventory("PRD003", "Notebook", "Stationery", 5000, 100);

        // TODO: Display all products info
        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();

        // TODO: Sell 20 laptops
        p1.sellProduct(20);
         // TODO: Add 50 units to product2 stock
        p2.addStock(50);
        // TODO: Apply 15% discount to product3
        p3.applyDiscount(15);
        // TODO: Check if product2 needs reorder
        if (p2.needsReorder()) {
            System.out.println("Product 2 needs reorder!");
        }
        System.out.println("\n=== Exercise Complete ===");
    }
}
