Subscribe > Subscription > Observer
-----------------------------------

In order to request the mocked Reddit news from the `NewsManager`, time to turn your `NewsFragment` into an `Observer` of the `Observable` that you receive from the `NewsManager.getNews()`. It will be done by calling the `getNews()` method and invoke the method `subscribe(…)` from the received `Observable`:


```kotlin
subscribe (
        { retrievedNews ->
            ...
        },
        { e ->
            ...
        }
```      
The method subscribe has several overloads and you are going to need this one:


```kotlin
public final Subscription subscribe(
       final Action1<? super T> onNext,
       final Action1<Throwable> onError) {
       ...
}
```      
It receives two functions:

* `onNext`: A function to be invoked when the `Observable` calls the `onNext()` method that you saw previously. You will need it to set the NewsAdapter with the received news.
* `onError`: A function to be called when the `onError()` method from the `Observable` is invoked. You’ll need it to show a SnackBar with an error message.
And returns a `Subscription` object. This object will allow you to manage the subscription like checking if it still subscribed or to cancel the subscription (you are going to see more about this at the end of this task).

These two functions could be provided using lambda expressions. For example in the first function, the `retrievedNews` variable is the name that is given to the news received from the `onNext()` method:


```kotlin
{
    retrievedNews ->
     (news_list.adapter as NewsAdapter).addNews(retrievedNews)
}
```      
Remember that the `onNext` returning type is a `List<RedditNewsItem>`, these news should be passed directly to your `NewsAdapter`.

And for the `onError` function, let's the user that there was an error with a `SnackBar`. You can use `e`, which is a `Throwable` type, to get more details about the received exception:


```kotlin
{ e ->
    Snackbar.make(...).show()
}
```      
Still in the Main Thread
------------------------

If you run the App it will just work because the data provided in this `Observable` are mocked. But if you really do a long running operation instead of the mocked data that you generate, the App will stop working as you are still in the Main UI Thread.

As we didn’t provide any specific details to our `Observable`, it will run with the default configuration which is to be executed in the same thread that it was invoked. So let’s configure our Observable to be executed in another thread but still notify any event in our current Main UI Thread.

SubscribeOn
-----------


```kotlin
val subscription = newsManager.getNews()
        .subscribeOn(Schedulers.io())
        .subscribe (...)
```      
The method `subscribeOn(…)` allows you to move the execution of the `Observable` code into another thread and with an specific behaviour. To do this, `RxJava` use `Schedulers` which provides the behaviour that you need for your use case. `RxJava` also provides a list of `Schedulers` for common scenarios:

* io: intended for IO-bound work.
* computation: intended for computational work.
* newThread: creates a new Thread for each unit of work.
* test: useful for debugging.
In this case, `Schedulers.io()` will be used as you are going to be executing an API request.

Task:
-----

Complete the `requestNews()` in the `NewsFragment.kt` by invoking `subscribe` method on `getNews` method, finishing lambdas declarations for `retrievedNews` and error, and filling up the correct argument for the `subscribOn` invocation.

  
You should invoke the constructor of `Schedulers.io` thread. You should also invoke the `subscribe` method in the second placeholder. You should use the `->` to pass the following code to the lambda expression. You should pass the error that might possibly occur during the subscription to the following lambda expression. You should name it `e`, as it is used below inside the `e.message` expression.
