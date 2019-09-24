Subscriptions
-------------

In order to avoid leaving your subscriptions in the middle of a process while leaving from a fragment or closing your App, you must manage it carefully and a good practice is to unsubscribe all the subscriptions that you create.

A good technique to do so is to add all the subscription that you create in a
```kotlin
CompositeSubscription
```      
object, this class is provided by RxJava and allows you to unsubscribe all the subscription that it has with just one
```kotlin
clear()
```      
method call. Time to initialize a
```kotlin
CompositeSubscription
```      
object inside the
```kotlin
onResume
```      
method and unsubscribe when the
```kotlin
onPause
```      
method is invoked. The code will be something like this:


```kotlin
var subscriptions = CompositeSubscription()

override fun onResume() {
    super.onResume()
    //reassign the CompositeSbscription() to subscriptions here
}

override fun onPause() {
    super.onPause()
    //call clear() method of subscriptions here
}
```      
The only thing that we have to do now is to add our subscription to this new CompositeSubscription object and we are safe to leave our App (or fragment in this case) at any moment:


```kotlin
private fun requestNews() {
    val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .subscribe (...)
    // add the subscription to subscriptions here by calling the add method for them with our subscription as an argument.
}
```      
To make code more readable all this logic is moved to a new base fragment called “RxBaseFragment” which all this logic by default. Checkout the code to see with more details.

Task:
-----

Finish the
```kotlin
RxBaseFragment.kt
```      
code: complete the subscription assignment, modify
```kotlin
onResume()
```      
to reassign subscriptions there, clear the subscriptions in
```kotlin
onPause()
```      
call.

Also, finish the
```kotlin
NewsFragment.kt
```      
by completing
```kotlin
requestNews()
```      
function - it should add a new subscription to other subscriptions

As you can see Kotlin & RxJava works perfect together and in this tutorial we are just seeing a small part of all the things that you can do with RxJava and thanks to Kotlin the code is totally readable and easy to understand.

  
You should invoke the constructor of
```kotlin
CompositeSubscription
```      
in the first placeholder in RxBaseFragment.kt.You should pass the constructor of
```kotlin
CompositeSubscription
```      
in the second placeholder in RxBaseFragment.kt to
```kotlin
subscriptions
```      
.You should invoke method
```kotlin
clear()
```      
of the
```kotlin
subscriptions
```      
in the third placeholder in RxBaseFragment.kt.You should invoke the method
```kotlin
add()
```      
of the
```kotlin
subscriptions
```      
and pass the
```kotlin
subscription
```      
as the parameter in the placeholder in NewsFragment.kt.  
