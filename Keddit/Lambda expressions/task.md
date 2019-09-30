Lambda expressions
------------------

You can use lambda expressions to provide the function required by the `Observable.create(…)` method. Time to provide the implementation of the code that will be executed in the context that you provide to the `Observable` (for now it means in which thread to be executed).

The `create()` method requires you to provide a function that receives a subscriber object, this subscriber object allows you to send events to the subscribers by executing 3 possible methods:

*  `onNext(item: T)`: This method is called to provide to the subscribers with the news received from the API call. In this case, T will be your `List<RedditNewsItem>` that it’s already infer from the return type in the `getNews()` signature.
*  `onCompleted()`: This method is invoked when providing of all the data from this `Observable` is finished, in this case, you will call it after you send the news from `onNext()` method and you are ready to finish this process.
* `onError(e: Throwable)`: If you face any issue from the API call, you will be calling this method to tell the subscribers that there was an error. It will be used later to inform the user that there was a problem with the request by showing a `SnackBar` message.
So the requesting news is emulated by providing mocked news and calling `onNext()` and `onCompleted()` to inform all the subscribers about this info.

Task:
-----

Complete the `getNews()` function to provide news to subscriber using `onNext`


Lazy NewsManager
----------------

Also `NewsManager` with lazy property reviewed in the **Lazy** task of this course was added:


```kotlin
private val newsManager by lazy { NewsManager() }
```      
This newsManager will be initialized with the NewsManager() only the first time that newsManagers field is used.

  
<div class='hint'>You should pass the following code to the subscriber in the upper placeholder.</div>
<div class='hint'>You should invoke the subscriber's method onNext() here, passing news as the parameter in the lower placeholder.</div>
