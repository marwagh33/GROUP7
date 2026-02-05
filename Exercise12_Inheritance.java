
class Vehicle {
    protected String Brand;
    protected String Model;
    protected int Year;
    protected double Price;

    public Vehicle(String Brand, String Model, int Year, double Price) {
        this.Brand = Brand;
        this.Model = Model;
        this.Year = Year;
        this.Price = Price;
        System.out.println("Vehicle constructor called");
    }
   // Displays  vehicle information
    public void displayInfo() {
        System.out.println("Brand: " + Brand);
        System.out.println("Model: " + Model);
        System.out.println("Year: " + Year);
        System.out.println("Price: " + Price);
    }

    public void startEngine() {
        System.out.println(Brand + " " + Model + " engine started");
    }

    public void stopEngine() {
        System.out.println(Brand + " " + Model + " engine stopped");
    }
}
// Car class inherits from Vehicle
class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String Brand, String Model, int Year, double Price, int numDoors, String fuelType) {
        super(Brand, Model, Year, Price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
        System.out.println("Car Constructor is called");
    }

    public void honk() {
        System.out.println(Brand + " " + Model + " says: Beep! Beep!");
    }

    public void openTrunk() {
        System.out.println("Opening trunk of " + Brand + " " + Model);
    }
}
// Motorcycle class inherits from Vehicle
class Motorcycle extends Vehicle {
    private int EngineCC;
    private boolean hasHelmetStorage;

    public Motorcycle(String Brand, String Model, int Year, double Price,
                      int EngineCC, boolean hasHelmetStorage) {
        super(Brand, Model, Year, Price);
        this.EngineCC = EngineCC;
        this.hasHelmetStorage = hasHelmetStorage;
        System.out.println("Motorcycle Constructor is called");
    }

    public void wheelie() {
        System.out.println(Brand + " " + Model + " is doing a wheelie!");
    }

    public void kickStart() {
        System.out.println("Kick starting " + Brand + " " + Model);
    }
}
// ElectricCar class inherits from Car
class ElectricCar extends Car {
    private double batteryCapacity;
    private int range;

    public ElectricCar(String Brand, String Model, int Year, double Price,
                       int numDoors, String fuelType,
                       double batteryCapacity, int range) {
        super(Brand, Model, Year, Price, numDoors, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
        System.out.println("ElectricCar Constructor is called");
    }

    @Override
    public void startEngine() {
        System.out.println(Brand + " " + Model + " electric motor activated silently");
    }
 // Charges electric car battery
    public void charge() {
        System.out.println("Charging " + Brand + " " + Model +
                "... Battery: " + batteryCapacity + " kWh");
    }
 // Displays battery status 
    public void displayBatteryStatus() {
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }
}
// Main class
public class Exercise12_Inheritance {
    public static void main(String[] args) {

        System.out.println("=== VEHICLE HIERARCHY TEST ===\n");
// Creating objects
        Car car = new Car("Toyota", "Corolla", 2023, 45000000, 4, "Petrol");
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR500R", 2022, 15000000, 500, false);
        ElectricCar electricCar = new ElectricCar(
                "Tesla", "Model 3", 2024, 85000000, 4, "Electric", 75.0, 450);
 // Testing Car methods
        System.out.println("\n--- Testing Car ---");
        car.displayInfo();
        car.startEngine();
        car.honk();
        car.openTrunk();
        car.stopEngine();
 // Testing Motorcycle methods
        System.out.println("\n--- Testing Motorcycle ---");
        motorcycle.displayInfo();
        motorcycle.startEngine();
        motorcycle.wheelie();
        motorcycle.kickStart();
        motorcycle.stopEngine();
 // Testing Electric Car methods
        System.out.println("\n--- Testing Electric Car ---");
        electricCar.displayInfo();
        electricCar.startEngine();
        electricCar.charge();
        electricCar.displayBatteryStatus();
        electricCar.honk();
        electricCar.stopEngine();
    }
}


