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

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/images/Ex1.png"/>

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