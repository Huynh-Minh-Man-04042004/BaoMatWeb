class Car {
    private int seats;
    private String engine;
    private boolean hasGPS;

    public void setSeats(int seats) { this.seats = seats; }
    public void setEngine(String engine) { this.engine = engine; }
    public void setGPS(boolean hasGPS) { this.hasGPS = hasGPS; }

    @Override
    public String toString() {
        return "Car [seats=" + seats + ", engine=" + engine + ", hasGPS=" + hasGPS + "]";
    }
}

class Manual {
    private String seatInstructions;
    private String engineInstructions;
    private String gpsInstructions;

    public void addSeatInstructions(int seats) {
        this.seatInstructions = "Seat Instructions for " + seats + " seats";
    }

    public void addEngineInstructions(String engine) {
        this.engineInstructions = "Engine Instructions for " + engine;
    }

    public void addGPSInstructions(boolean hasGPS) {
        this.gpsInstructions = "GPS Instructions: " + (hasGPS ? "Has GPS" : "No GPS");
    }

    @Override
    public String toString() {
        return "Manual [seatInstructions=" + seatInstructions + ", engineInstructions=" + engineInstructions + ", gpsInstructions=" + gpsInstructions + "]";
    }
}

interface Builder {
    void setSeats(int seats);
    void setEngine(String engine);
    void setGPS(boolean hasGPS);
}

class CarBuilder implements Builder {
    private Car car = new Car();

    public void setSeats(int seats) { car.setSeats(seats); }
    public void setEngine(String engine) { car.setEngine(engine); }
    public void setGPS(boolean hasGPS) { car.setGPS(hasGPS); }

    public Car getProduct() { return car; }
}

class CarManualBuilder implements Builder {
    private Manual manual = new Manual();

    public void setSeats(int seats) { manual.addSeatInstructions(seats); }
    public void setEngine(String engine) { manual.addEngineInstructions(engine); }
    public void setGPS(boolean hasGPS) { manual.addGPSInstructions(hasGPS); }

    public Manual getProduct() { return manual; }
}

class Director {
    public void constructSportsCar(Builder builder) {
        builder.setSeats(2);
        builder.setEngine("Sport Engine");
        builder.setGPS(true);
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        
        CarBuilder carBuilder = new CarBuilder();
        director.constructSportsCar(carBuilder);
        Car car = carBuilder.getProduct();
        System.out.println(car);

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual manual = manualBuilder.getProduct();
        System.out.println(manual);
    }
}
