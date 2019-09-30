Subscriptions
-------------

In order to avoid leaving your subscriptions in the middle of a process while leaving from a fragment or closing your App, you must manage it carefully and a good practice is to unsubscribe all the subscriptions that you create.

A good technique to do so is to add all the subscription that you create in a `CompositeSubscription` object, this class is provided by RxJava and allows you to unsubscribe all the subscription that it has with just one `clear()` method call. Time to initialize a `CompositeSubscription` object inside the `onResume` method and unsubscribe when the `onPause` method is invoked. The code will be something like this:


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
The only thing that we have to do now is to add our subscription to this new `CompositeSubscription` object and we are safe to leave our App (or fragment in this case) at any moment:


```kotlin
private fun requestNews() {
    val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .subscribe (...)
    // add the subscription to subscriptions here by calling the add method for them with our subscription as an argument.
}
```      
To make code more readable all this logic is moved to a new base fragment called `RxBaseFragment` which all this logic by default. Checkout the code to see with more details.

Task:
-----

Finish the `RxBaseFragment.kt` code: complete the subscription assignment, modify `onResume()` to reassign subscriptions there, clear the subscriptions in `onPause()` call.

Also, finish the `NewsFragment.kt` by completing `requestNews()` function - it should add a new subscription to other subscriptions.

As you can see Kotlin & RxJava works perfect together and in this tutorial we are just seeing a small part of all the things that you can do with RxJava and thanks to Kotlin the code is totally readable and easy to understand.

  
<div class='hint'>You should invoke the constructor of `CompositeSubscription` in the first placeholder in `RxBaseFragment.kt`.</div>
<div class='hint'>You should pass the constructor of `CompositeSubscription` in the second placeholder in `RxBaseFragment.kt` subscriptions.</div>
<div class='hint'>You should invoke method `clear()` of the subscriptions in the third placeholder in `RxBaseFragment.kt`.</div>
<div class='hint'>You should invoke the method `add()` of the `subscriptions` and pass the `subscription` as the parameter in the placeholder in `NewsFragment.kt`. </div>
