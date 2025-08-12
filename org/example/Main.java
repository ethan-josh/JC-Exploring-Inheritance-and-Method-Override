package org.example;

// Parent class
class Vehicle {
    protected String brand = "Generic Vehicle";

    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

// Child class
class Car extends Vehicle {
    private String modelName = "Mustang";

    public void display() {
        System.out.println("I am a " + brand + " " + modelName);
    }
}

class Bicycle extends Vehicle{
	public void display(){
		System.out.println("Bicycle says: Ring ring!");
	}
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        // myCar.honk();
        // myCar.display();

        Bicycle bike = new Bicycle();
        System.out.print("Bicycle says: ");
        bike.honk();
        bike.display();

    }
}