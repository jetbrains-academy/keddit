Higher-Order Functions
----------------------


> A higher-order function is a function that takes functions as parameters, or returns a function.Well, lets see how Kotlin allows you to pass functions as parameter or return it with some examples.

This function “logExecution” allows you to pass a function as parameter and log before and after the execution of this function.


```kotlin
fun logExecution(func: () -> Unit) {
    Log.d("tag", "before executing func")
    func()
    Log.d("tag", "after executing func")
}
```      
func: ()-> Unit
---------------

As you already know, “func” is the name of the parameter and “() -> Unit” is the “type” of the parameter, in this case, func will be a function that doesn’t receive any parameter and doesn’t return any value (remember that Unit works like void in Java).

You can call this function by passing a lambda expression that must not receive or return any value, like in this way:


```kotlin
logExecution( { Log.d("tag", "I'm a function") } )
```      
but also Kotlin allows you to remove the parenthesis if there is only one function parameter or if the last parameter is a function:


```kotlin
logExecution { Log.d("tag", "I'm a function") }
```      
If you change the logExecution signature to receive another parameter and put the function parameter at the end, you can do this:


```kotlin
// added tag parameter:
fun logExecution(tag: String, func: () -> Unit) { ... }
// call in this way:
logExecution("tag") { Log.d("tag", "I'm a function") }
```      
or:


```kotlin
logExecution("tag") {
    Log.d("tag", "I'm a function")
}
```      
Also you can make the function to receive and return values:


```kotlin
fun logExecution(func: (String, String) -> Int) {
    val thisIsAnInt = func("Hello", "World")
}
```      
As you can see Kotlin gives you a lot of power with Higher-Order functions. Also this allows you to remove a lot of Android ceremonies that requires you to initialize things before to execute something or never forget to close a cursor, and much more.

 **Async function example** 

Let's see a practical example - create a new function that receives a function and execute it in another thread:


```kotlin
fun runAsync(func: () -> Unit) {
    Thread(Runnable { func() }).start()
}
```      
Now you can execute a function outside of the Main UI Thread easily:


```kotlin
runAsync {
    // i.e.: save something in the Database
}
```      
 **Is Lollipop example** 

Maybe you want to run some specific code for Lollipop devices and instead of doing the regular if check, you can use this function:


```kotlin
fun isLollipopOrAbove(func: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        func()
    }
}
```      
and use it in this way:


```kotlin
isLollipopOrAbove {
    // run lollipop specific code safely
}
```      
You can move onto the next task.

  
