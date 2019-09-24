Statically Typed
----------------

It means that Kotlin needs to know the Type of everything that you define in the code because the compiler will do a type check during compilation. With the great support that we have in Android Studio the IDE will do a great job helping us to know if we are assigning properly a value to a variable.

Furthermore, we don’t have to specify the type when we create a variable (or a constant in this case). Checkout the toolbar constant, the type is inferred from the context and this is another great feature about Kotlin:


```kotlin
val toolbar = findViewById(R.id.toolbar) as Toolbar
```      
Type inference brings great advantages to the language: Reliability (the compiler verifies the correctness of the program), Maintainability (the code is explained by itself), Tool support (what I mentioned before, static typing enables reliable refactoring, code completion and more) and Performance (in most cases there is no need to figure out at runtime which method needs to be called).

Task:
-----

Check out the
```kotlin
Toolbar
```      
type cast in the toolbar declaration expression. See what happens if you remove it.

onBackPressed()
---------------

Here the method
```kotlin
onBackPressed
```      
is added. It is responsible for the application response to user pressing the back button on the device. It will check if the back stack contains any previous screens of the app and return the most recent of them. If the back stack does not contain any, it will finish the activity.

You can move on to the next task.

