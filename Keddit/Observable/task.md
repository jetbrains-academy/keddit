News Manager
------------

The
```kotlin
NewsManager
```      
class will be in charge of providing news from Reddit API. It will be responsible for performing the server request and give you a list of news with our already created News UI Model.

The main idea behind this is to make your API call to be executed outside of your Main UI Thread, in another thread.

Observable
----------

The
```kotlin
NewsManager
```      
class will provide a method that will return an Observable object which will allows you to run a piece of code (like an API call) in another context (in this case in a new thread).


```kotlin
fun getNews(): Observable<List<RedditNewsItem>> {
    ...
}

```      
This Observable object will be created from the
```kotlin
NewsManager
```      
. We will provide the implementation of this object:


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
Task:
-----

Complete the
```kotlin
getNews()
```      
functions in
```kotlin
NewsManager.kt
```      
to create and return
```kotlin
Observable
```      
, that will generate news for subscriber (will be added in the next task).  
You should declare an implementation of
```kotlin
Observable
```      
in the upper placeholder.You should invoke the create method of the
```kotlin
Observable
```      
in the lower placeholder.  
