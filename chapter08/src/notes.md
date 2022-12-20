# CHAPTER 08 Lambdas and Functional Interfaces 

- Functional programming is a way of writing code more declaratively. 
- Not deal with state of objects 
- Focus more on expressions than loops.

#### Deferred Execution
    print(animals, a -> a.canSwim());
    Deferred execution means that code is specified now but will run later
    In this case, “later” is inside the print() method body as opposed to when it is passed to the method.
## Learning Lambda Syntax
    * Lambdas work with interfaces that have exactly one abstract method.
    * How does Java know?
        Java relies on context when figuring out what lambda expressions mean. 
        Context refers to where and how the lambda is interpreted
    *  Lambda syntax omitting optional parts 
        a -> a.canHop()
        
        -> A single parameter specified with the name a
        -> The arrow operator (->) to separate the parameter and body
        -> A body that calls a single method and returns the result of that method

    *  Lambda syntax including optional parts 
        (Animal a) -> { return a.canHop(); }
        
        -> A single parameter specified with the name a and stating that the type is Animal
        -> The arrow operator (->) to separate the parameter and body
        -> A body that has one or more lines of code, a semicolon and a return statement

#### Valid lambdas that return a boolean 
    Lambda	                                      # of parameters
    () -> true	                                    0
    x -> x.startsWith("test")	                    1
    (String x) -> x.startsWith("test")	            1
    (x, y) -> { return x.startsWith("test"); }	    2
    (String x, String y) -> x.startsWith("test")	    2

#### Invalid lambdas that should return a boolean
    Invalid lambda	                                    Reason
    x, y -> x.startsWith("fish")	                Missing parentheses on left
    x -> { x.startsWith("camel"); }	                Missing return on right
    x -> { return x.startsWith("giraffe") }	        Missing semicolon inside braces
    String x -> x.endsWith("eagle")	                Missing parentheses on left

## Coding Functional Interfaces
A functional interface is an interface that contains a single abstract method

#### Defining a Functional Interface

    @FunctionalInterface
    public interface Sprint {
        public void sprint(int speed);
    }
    
    public class Tiger implements Sprint {
         public void sprint(int speed) {
         System.out.println("Animal is sprinting fast! " + speed);
        }
    }

Sprint interface is a functional interface because it contains exactly one abstract method, 
and the Tiger class is a valid class that implements the interface.

The **@FunctionalInterface** annotation tells the compiler that you intend for the code to be a functional interface.

#### Adding Object Methods
    public String toString()
    public boolean equals(Object)
    public int hashCode()
If a functional interface includes an abstract method with the same signature as a public method found in Object, 
those methods do not count toward the single abstract method test. 

## Using Method References
The :: operator tells Java to call the println() method later. It will take a little while to get used to the syntax.

A method reference and a lambda behave the same way at runtime. 
You can pretend the compiler turns your method references into lambdas for you.

    There are four formats for method references:
     - static methods
     - Instance methods on a particular object
     - Instance methods on a parameter to be determined at runtime
     - Constructors