Safe ?: Safe!
-------------

This is one of the great things about Kotlin, everything in Kotlin is not nullable unless you specifically declare it in this way. The way to do this is with the “?” question mark which also suggest you that the value could be there or not.

With that being said, let’s see some examples:


```kotlin
val a : String = null  // don't compile!
var b : Int          // neither as must be initialized or abstract.
val ok : String? = null // OK :)
```      
The compiler will be checking the presence of a possible null object, this will prevent us to make the common mistake of getting a “NullPointerException” or well known as the “Billion-dollar mistake” by Tony Hoare.

Safe call
---------

To interact with a nullable object is really easy, the “?” question mark will allow you to get the value just in case it exists, otherwise it will ignore it and you are safe to continue running the program:


```kotlin
val context : Context? = null
val res = context?.getResources() // not crash, res will be null
```      
Smart cast
----------

If you continue playing with nullable objects maybe you end up doing this:


```kotlin
val context : Context? = null
val res = context?.getResources()
val appName = res?.getString(R.string.app_name)
val shortName = appName?.substring(0, 2)
```      
This is awful, but you can do this in a better way with smart cast. Just check if context is null and inside the if block the context will be considered as a non-nullable object:


```kotlin
val context : Context? = null
if (context != null) {
    val res = context.getResources()    // Don't need '?' anymore
    val appName = res.getString(R.string.app_name)
    val shortName = appName.substring(0, 2)
}
val context : Context? = null
context?.let {
    val res = context.getResources()    // Don't need '?' anymore
    val appName = res.getString(R.string.app_name)
    val shortName = appName.substring(0, 2)
}
```      
You can move on to the next task.

