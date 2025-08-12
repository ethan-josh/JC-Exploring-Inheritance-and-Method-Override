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

---

### Exercise 3: Method Overriding: Providing a New Implementation

**Code to run:**
```
class Editor {
    public void openFile() {
        System.out.println("Opening a generic file.");
    }
}

class CodeEditor extends Editor {
    @Override
    public void openFile() {
        System.out.println("Applying syntax highlighting...");
        super.openFile(); // Call the parent's method
    }
}

public class Main {
    public static void main(String[] args) {
        Editor myEditor = new Editor();
        CodeEditor myCodeEditor = new CodeEditor();
        Editor polyEditor = new CodeEditor(); // Polymorphism

        System.out.println("--- Regular Editor ---");
        myEditor.openFile();

        System.out.println("\n--- Code Editor ---");
        myCodeEditor.openFile();
        
        System.out.println("\n--- Polymorphic Editor ---");
        polyEditor.openFile();
    }
}
```
**Predicted Output:**
```
--- Regular Editor ---
Opening a generic file.

--- Code Editor ---
Applying syntax highlighting...
Opening a generic file.

--- Polymorphic Editor ---
Applying syntax highlighting...
Opening a generic file.
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex3.png"/>

**Explanation:**

The correct output is B).

1. myEditor.openFile(): This is an Editor object, so it calls the standard Editor.openFile() method.

2. myCodeEditor.openFile(): This is a CodeEditor object, so it calls the overridden version of openFile(). This version first prints "Applying syntax highlighting..." and then uses super.openFile() to execute the code from the parent Editor class's method.

3. polyEditor.openFile(): This demonstrates polymorphism. The reference is of type Editor, but the object is of type CodeEditor. At runtime, Java determines that the object's actual type is CodeEditor, so it calls the overridden method from the CodeEditor class.

### Mini Challenge 3

Create a GameCharacter class with a takeDamage(int amount) method that reduces a health variable (e.g., health -= amount). Create a subclass ArmoredCharacter that overrides takeDamage. The new method should cut the damage amount in half before applying it. Use super.takeDamage() to avoid duplicating the health-reduction logic. Test both characters taking 100 damage.


**Desired Output**
```
Regular character takes 100 damage. New health: 0
Armored character takes 50 damage. New health: 50
```

**Code to Add**
```
class GameCharacter {
    protected int health;

    public GameCharacter(int health) {
        this.health = health;
    }

    public void takeDamage(int amount) {
        health -= amount;
        System.out.println("Regular character takes " + amount + " damage. New health: " + health);
    }
}

class ArmoredCharacter extends GameCharacter {

    public ArmoredCharacter(int health) {
        super(health);
    }

    @Override
    public void takeDamage(int amount) {
        int reducedAmount = amount / 2;
        System.out.println("Armored character takes " + reducedAmount + " damage. New health: " + health);
    }
}

public class Main {
    public static void main(String[] args) {
        GameCharacter regular = new GameCharacter(100);
        ArmoredCharacter armored = new ArmoredCharacter(100);

        regular.takeDamage(100);
        armored.takeDamage(100);
    }
}
```

**New Output**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex3-Challenge.png"/>

---

### Exercise 4: Method Overriding: Providing a New Implementation

**Code to run:**
```
// Parent class
class BankAccount {
    private double balance;

    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public double getBalance() {
        return this.balance;
    }
}

// Child class
class CheckingAccount extends BankAccount {
    private double fee = 5.0;

    public CheckingAccount(double startingBalance) {
        super(startingBalance);
    }

    public void deductMonthlyFee() {
        balance = balance - fee;
        System.out.println("Fee deducted. New balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        CheckingAccount myChecking = new CheckingAccount(100.0);
        // myChecking.deductMonthlyFee(); // This line cannot be run
    }
}
```
**Predicted Output:**
```
Will not compile
```

**Actual Output:**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex4.png"/>

**Explanation:**

The code fails to compile because the deductMonthlyFee method in CheckingAccount tries to directly access the balance variable.

The balance variable in BankAccount is declared as private. A private member is only accessible from within the class that declares it. Even a subclass cannot access the private members of its parent. This is a key feature of encapsulation—it protects the parent's internal state from being modified incorrectly by child classes. The inheritance relationship does not break this fundamental rule.

### Mini Challenge 4

Fix the code snippet above so that it compiles and runs correctly. There are two common solutions:

(Preferred for Encapsulation) Add public setter methods in the parent class.

(Often Used for Subclass Convenience) Change the access modifier of the balance variable in BankAccount from private to protected.

For this challenge, use the protected modifier. Then, in your main method, create a CheckingAccount with $100 and call deductMonthlyFee().

**Desired Output**
```
Fee deducted. New balance: 95.0
```

**Code to Add**
```
class BankAccount {
    protected double balance; //I cahanged it to protected

    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public double getBalance() {
        return this.balance;
    }
}

// Child class
class CheckingAccount extends BankAccount {
    private double fee = 5.0;

    public CheckingAccount(double startingBalance) {
        super(startingBalance);
    }

    public void deductMonthlyFee() {
        balance = balance - fee;
        System.out.println("Fee deducted. New balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        CheckingAccount myChecking = new CheckingAccount(100.0);
        myChecking.deductMonthlyFee();
            }
}
```

**New Output**

<img src="https://github.com/ethan-josh/JC-Exploring-Inheritance-and-Method-Override/blob/main/Images/Ex4-Challenge.png"/>