public class Animal {

}

class Vehicle {
    int x;
    Vehicle() {
        this(10);
    }
    Vehicle(int x) {
        this.x = x;
    }
}

class Car extends Vehicle {
    int y;
    Car() {
        super();
    }

    Car(int y) {
        this.y = y;
    }

    public String toString() {
        return super.x + ": " + this.y;
    }
}