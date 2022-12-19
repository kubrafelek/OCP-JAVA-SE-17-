## Functional programming is a way of writing code more declaratively.
## Not deal with state of objects 
## focus more on expressions than loops.
## Deferred Execution
    print(animals, a -> a.canSwim());
    Deferred execution means that code is specified now but will run later
    In this case, “later” is inside the print() method body, as opposed to when it is passed to the method.
### Learning Lambda Syntax
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
(String x, String y) -> x.startsWith("test")	2

#### Invalid lambdas that should return a boolean
Invalid lambda	                                    Reason
x, y -> x.startsWith("fish")	                Missing parentheses on left
x -> { x.startsWith("camel"); }	                Missing return on right
x -> { return x.startsWith("giraffe") }	        Missing semicolon inside braces
String x -> x.endsWith("eagle")	                Missing parentheses on left
