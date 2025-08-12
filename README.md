# Name: Ethan Joshua Camingao
## Exploring Inheritance and Method Override

---

### Exercise 1: Designing Methods

**Code to run:**
```
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

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.honk();
        myCar.display();
    }
}
```
**Predicted Output:**
```
Tuut, tuut!
I am a Generic Vehicle Mustang
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex1.png"/>

**Explanation:**

The correct output is A). The Car class extends the Vehicle class, which means it inherits all public and protected members.

1. myCar.honk();: Even though the Car class has no honk() method defined within it, it inherits this method from its parent, Vehicle.

2. myCar.display();: This method is called from the Car class. Inside display(), it can access its own private variable modelName and the protected variable brand that it inherited from Vehicle.

### Mini Challenge 1

Create a new class named Bicycle that also extends Vehicle. Give it a unique method, ringBell(), which prints "Ring ring!". In your main method, create a Bicycle object and call both honk() and ringBell() on it.


**Desired Output**
```
Bicycle says: Tuut, tuut!
Bicycle says: Ring ring!
```

**Code to Add**
```
// Existing code

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
```

**New Output**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex1-Challenge.png"/>

---

### Exercise 2: Abstract Classes: Defining a Template

**Code to run:**
```
// Abstract parent class
abstract class Shape {
    // Abstract method (does not have a body)
    public abstract double area();

    // Concrete method
    public String display() {
        return "The area is: " + area();
    }
}

// Concrete subclass
class Circle extends Shape {
    private double radius = 5.0;

    // Provide implementation for the abstract method
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Concrete subclass
class Rectangle extends Shape {
    private double length = 4.0;
    private double width = 6.0;

    // Provide implementation for the abstract method
    public double area() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        // Shape myShape = new Shape(); // This line would cause a compile error

        Circle myCircle = new Circle();
        System.out.println(myCircle.display());

        Rectangle myRectangle = new Rectangle();
        System.out.println(myRectangle.display());
    }
}
```
**Predicted Output:**
```
The area is: 78.53981633974483
The area is: 24.0
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex2.png"/>

**Explanation:**

The correct output is B).

1. An abstract class cannot be instantiated, which is why the line new Shape() is commented out.

2. The Circle and Rectangle classes are concrete because they provide an implementation for the area() abstract method they inherited from Shape.

3. When myCircle.display() is called, it invokes the concrete display() method from the Shape class. Inside that method, the call to area() is resolved to the Circle's version of the area() method.
The same logic applies to the myRectangle object.

### Mini Challenge 2

Create an abstract class named Animal with a concrete method breathe() that prints "Inhale... Exhale...", and an abstract method makeSound(). Create a concrete class Dog that extends Animal and implements makeSound() to print "Woof!". In main, create a Dog object and call both breathe() and makeSound().


**Desired Output**
```
Inhale... Exhale...
Woof!
```

**Code to Add**
```
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
```

**New Output**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex2-Challenge.png"/>