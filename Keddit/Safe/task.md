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



Elvis Operator ?:
-----------------

This is the name used for this operator “?:” and you can use it to give an alternative value in case the object is null. Its like a short way to perform a null check.

In this example “message” could be null, the type is “String?”. In case the object is NOT null we’ll be sending the value of message, otherwise, the value that we provided after the elvis operator:


```kotlin
try {
    // code...
} catch (e: Throwable) {
    Log.e("TAG", e.message ?: "Error message")
}
```      
Note: if you want to know more about null safety, checkout this link: [Null safety](https://kotlinlang.org/docs/reference/null-safety.html).

changeFragment(f: Fragment, cleanStack: Boolean?)
-------------------------------------------------

Here a function called `changeFragment` is added. It is responsible for changing a fragment presented by the activity and cleaning the stack of the FragmentManager if it is needed.

`clearBackStack()` we have created in a previous task cleans the back stack prior to our operation, as the fragment will be reset and the user won't need to return to the old versions of it. Other code begins the transaction for setting up the fragment, sets up the animations for the fragment appearance, replaces the activity main content with the fragment and commits all the changes to the `FragmentManager`. All of it is done via transaction to avoid interference with the outside operations in the process.

Task:
-----

Insert an elvis operator in the condition check inside `changeFragment()` method. Note, that a more safe way to implement this would be to exclude Null from the possible argument value of the `changeFragment`, forcing `cleanStack` to have a value. This approach will be used in the following tasks, but for now is violated to provide an example of usage.

  
<div class='hint'>Insert the Elvis operator here to make sure the value of cleanStack is always provided.</div>
