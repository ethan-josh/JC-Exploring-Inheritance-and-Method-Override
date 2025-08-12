package org.example;

// Exercise 1 ********
// Parent class
// class Vehicle {
//     protected String brand = "Generic Vehicle";

//     public void honk() {
//         System.out.println("Tuut, tuut!");
//     }
// }

// // Child class
// class Car extends Vehicle {
//     private String modelName = "Mustang";

//     public void display() {
//         System.out.println("I am a " + brand + " " + modelName);
//     }
// }

// class Bicycle extends Vehicle{
// 	public void display(){
// 		System.out.println("Bicycle says: Ring ring!");
// 	}
// }

// public class Main {
//     public static void main(String[] args) {
//         Car myCar = new Car();
//         // myCar.honk();
//         // myCar.display();

//         Bicycle bike = new Bicycle();
//         System.out.print("Bicycle says: ");
//         bike.honk();
//         bike.display();

//     }
// }
// *******************


// Exercise 2 ********
// Abstract parent class
// abstract class Shape {
//     // Abstract method (does not have a body)
//     public abstract double area();

//     // Concrete method
//     public String display() {
//         return "The area is: " + area();
//     }
// }

// // Concrete subclass
// class Circle extends Shape {
//     private double radius = 5.0;

//     // Provide implementation for the abstract method
//     public double area() {
//         return Math.PI * radius * radius;
//     }
// }

// // Concrete subclass
// class Rectangle extends Shape {
//     private double length = 4.0;
//     private double width = 6.0;

//     // Provide implementation for the abstract method
//     public double area() {
//         return length * width;
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Shape myShape = new Shape(); // This line would cause a compile error

//         Circle myCircle = new Circle();
//         System.out.println(myCircle.display());

//         Rectangle myRectangle = new Rectangle();
//         System.out.println(myRectangle.display());
//     }
// }

abstract class Animal{
	public String breathe(){
		return "Inhale... Exhale...";
	}

	public abstract void makeSound();
}

class Dog extends Animal{
	public void makeSound(){
		System.out.println("Woof!");
	}
}

public class Main{
	public static void main(String[] args){
		Dog myDog = new Dog();
		System.out.println(myDog.breathe());
		myDog.makeSound();
	}
}
// *******************