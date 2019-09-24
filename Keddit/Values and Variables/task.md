Values and Variable
-------------------

The way to define a variable is with the “var” keyword. The type will be inferred from the Context and the same for constants which use the “val” keyword:


```kotlin
val price = 100        // Int
price = 30             // doesn't compile! it's a constant
var total = price * 3  // Int
val name = "Juancho"   // String
```      
You can specify the type explicitly:


```kotlin
val lastname : String = "Keddit" // explicit type definition
var size : Double = 30.0
var time : Float = 15f
```      
Maybe you notice that there are no primitive types, we don’t use “double” but “Double”. This is because everything in Kotlin is an object. For performance, the compiler will transform some of these objects to primitive types internally.

setSupportActionBar()
---------------------

This methods allows a toolbar we add to act as an application bar, allowing the user to interact with its elements and providing information.

Task:
-----

Define a value toolbar with appropriate type.

  
  
Declare a value in the first placeholder. Use the special keyword from Kotlin syntax.Declare the type of value in the second placeholder. You need it to be a Toolbar.  
