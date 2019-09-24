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
Note: if you want to know more about null safety, checkout this link:[Null safety](https://kotlinlang.org/docs/reference/null-safety.html).

changeFragment(f: Fragment, cleanStack: Boolean?)
-------------------------------------------------

Here a function called
```kotlin
changeFragment
```      
is added. It is responsible for changing a fragment presented by the activity and cleaning the stack of the FragmentManager if it is needed.
```kotlin
clearBackStack()
```      
we have created in a previous task cleans the back stack prior to our operation, as the fragment will be reset and the user won't need to return to the old versions of it. Other code begins the transaction for setting up the fragment, sets up the animations for the fragment appearance, replaces the activity main content with the fragment and commits all the changes to the
```kotlin
FragmentManager
```      
. All of it is done via transaction to avoid interference with the outside operations in the process.

Task:
-----

Insert an elvis operator in the condition check inside
```kotlin
changeFragment()
```      
method. Note, that a more safe way to implement this would be to exclude Null from the possible argument value of the
```kotlin
changeFragment
```      
, forcing
```kotlin
cleanStack
```      
to have a value. This approach will be used in the following tasks, but for now is violated to provide an example of usage.

  
Insert the Elvis operator here to make sure the value of
```kotlin
cleanStack
```      
is always provided.  
