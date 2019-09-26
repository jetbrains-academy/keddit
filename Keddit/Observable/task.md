News Manager
------------

The `NewsManager` class will be in charge of providing news from Reddit API. It will be responsible for performing the server request and give you a list of news with our already created News UI Model.

The main idea behind this is to make your API call to be executed outside of your Main UI Thread, in another thread.

Observable
----------

The `NewsManager` class will provide a method that will return an `Observable` object which will allows you to run a piece of code (like an API call) in another context (in this case in a new thread).


```kotlin
fun getNews(): Observable<List<RedditNewsItem>> {
    ...
}

```      
This Observable object will be created from the `NewsManager`. We will provide the implementation of this object:


```kotlin
fun getNews(): Observable<List<RedditNewsItem>> {
    return Observable.create {
        subscriber ->

        //code to tun in another context
        ...

        //actions on subscriber

        subscriber.onCompleted()
    }
}
```

\
\

Task:
-----

Complete the `getNews()` functions in `NewsManager.kt` to create and return `Observable`, that will generate news for subscriber (will be added in the next task).
You should declare an implementation of `Observable`. You should also invoke the `create` method of the `Observable` in the lower placeholder.
