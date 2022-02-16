import java.util.Random;

public class Lesson05Interfaces {

    static Random random = new Random();

    public static void main(String[] args) {
        Vehicle truck = new Truck();
        Vehicle spaceship = new Spaceship();
        for (int i = 0; i < 7; i++) {
            truck.accelerate();
            spaceship.accelerate();
        }
        System.out.println("truck: " + truck.getVelocityMessage());
        System.out.println("spaceship: " + spaceship.getVelocityMessage());


        Vehicle[] vehicles = new Vehicle[10];
        for (int i = 0; i < vehicles.length; i++) {
            //  randomly generate trucks and spaceships and store them in a Vehicle[]
            if (random.nextBoolean()) {
                vehicles[i] = new Truck();
            } else {
                vehicles[i] = new Spaceship();
            }
        }

        accelerateAllAndPrint(vehicles);
    }

    static void accelerateAllAndPrint(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) { // accelerate each vehicle
                                                    // a random number of times:
            for (int accelIndex = 0; accelIndex < random.nextInt(8); accelIndex++) {
                vehicles[i].accelerate();
            }
        }
        // call getVelocityMessage() method on every vehicle:
        for (int i = 0; i < vehicles.length; i++) {
            printVelocity(vehicles[i]);
        }
    }
    static void printVelocity(Vehicle vehicle) {
        System.out.println("Unknown vehicle velocity: " + vehicle.getVelocityMessage());
    }
}

interface Vehicle {
    // Makes a vehicle accelerate.
    // What that means depends greatly on the vehicle.
    void accelerate();

//    Differences between a class declaration and an interface declaration:
//        Uses the keyword interface instead of class.
//        Does not include constructors.
//        Method declarations are terminated with a semicolon and don't include code blocks.
//        No instance fields.
//     Similarities:
//        Names are ProperCase.
//        Stored in its own source file.

    // Returns a well-formatted message
    // describing the velocity.
    String getVelocityMessage();
}

class Truck implements Vehicle {
    private static final int MAX_KM_PER_HOUR = 195;
    private int kilometersPerHour = 0;
    @Override
    public void accelerate() {
        kilometersPerHour = Math.min(kilometersPerHour + 10, MAX_KM_PER_HOUR);
    }
    @Override
    public String getVelocityMessage() {
        return String.format("%s km/hr", kilometersPerHour);
    }
}

class Spaceship implements Vehicle {
    private double percentOfLightSpeed = 0.0;
    @Override
    public void accelerate() {
        percentOfLightSpeed += (0.1 * (1.0 - percentOfLightSpeed));
    }
    public String getVelocityMessage() {
        return String.format("Traveling at %.2f%% the speed of light.", percentOfLightSpeed * 100.0);
    }
}
