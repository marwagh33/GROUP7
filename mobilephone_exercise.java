
/**
 * Write a description of class mobilephone_exercise here.
 *
 * @author Aiman
 * @version-1 22-01-2026
 */
class mobilephone_exercise
{ 
    private String brand;
    private String model;
    private double price;
    private int batteryLevel;//0-100
    private boolean isOn;
    public mobilephone_exercise() {
        this.brand="unknown";
        this.model="unknown";
        this.price=0;
        this.batteryLevel=100;
        this.isOn=false;
    }
    public mobilephone_exercise(String brand, String model, double price)
    {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.batteryLevel = 100;
        this.isOn = false;
    }
    public String getbrand() {
        return brand;
    }
    public String getmodel() {
        return model;
    }
    public double getprice() {
        return price;
    }
    public int getbatteryLevel() {
        return batteryLevel;
    }
    public boolean getisOn() {
        return isOn;
    }
//setters with validation
public void setprice ( double price) {
   if (price > 0) {
       this.price = price;
   } else {
       System.out.println("Price must be positive.");
   }
}
public void setbatteryLevel(int batteryLevel) {
    if (batteryLevel >= 0 && batteryLevel <= 100) {
        this.batteryLevel = batteryLevel;
    } else {
        System.out.println("Battery level must be between 0 and 100.");
    }
}
public void turnOn() {
    if (batteryLevel > 0) {
        isOn = true;
        System.out.println("Phone is now on.");
    } else {
        System.out.println("Battery empty. Cannot turn on.");
    }
}
public void turnOff() {
    if (batteryLevel < 0) {
        isOn = false;
        System.out.println("Phone turns off.");
    } else {
        System.out.println("Phone now is on.");
    }
}
public void makeCall(String contactName) {
    if (isOn && batteryLevel >=5) {
        System.out.println("Calling" + contactName + "....");
    }
}
public void chargeBattery(int minutes) {
        int addedCharge = minutes * 2;
        batteryLevel += addedCharge;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
        System.out.println("Phone charged for " + minutes + " minutes.");
}
public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Power Status: " + (isOn ? "ON" : "OFF"));
}
public static void main(String[] args) {
        System.out.println("=== Mobile Phone Exercise ===\n");
        mobilephone_exercise phone1 = new mobilephone_exercise();
        phone1.displayInfo();

        System.out.println("\n------------------\n");
        mobilephone_exercise phone2 =new mobilephone_exercise("Samsung", "Galaxy S24", 2500000);
        phone2.turnOn();
        phone2.makeCall (" Alice");
        phone2.makeCall (" Bob");
        phone2.makeCall (" Charlie");
        System.out.println();
        phone2.displayInfo();
        System.out.println();
        phone2.chargeBattery(10);
        System.out.println();
        phone2.displayInfo();

        System.out.println("\n=== Exercise Complete ===");
    } 
}