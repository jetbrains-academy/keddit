Lambda expressions
------------------

You can use lambda expressions to provide the function required by the
```kotlin
Observable.create(…)
```      
method. Time to provide the implementation of the code that will be executed in the context that you provide to the
```kotlin
Observable
```      
(for now it means in which thread to be executed).

The
```kotlin
create()
```      
method requires you to provide a function that receives a subscriber object, this subscriber object allows you to send events to the subscribers by executing 3 possible methods:

* 
```kotlin
onNext(item: T)
```      
: This method is called to provide to the subscribers with the news received from the API call. In this case, T will be your "
```kotlin
List<RedditNewsItem>
```      
” that it’s already infer from the return type in the
```kotlin
getNews()
```      
signature.
* 
```kotlin
onCompleted()
```      
: This method is invoked when providing of all the data from this Observable is finished, in this case, you will call it after you send the news from
```kotlin
onNext()
```      
method and you are ready to finish this process.
* 
```kotlin
onError(e: Throwable)
```      
: If you face any issue from the API call, you will be calling this method to tell the subscribers that there was an error. It will be used later to inform the user that there was a problem with the request by showing a SnackBar message.
So the requesting news is emulated by providing mocked news and calling
```kotlin
onNext()
```      
and
```kotlin
onCompleted()
```      
to inform all the subscribers about this info.

Task:
-----

Complete the
```kotlin
getNews()
```      
function to provide news to subscriber using
```kotlin
onNext
```      


Lazy NewsManager
----------------

Also NewsManager with lazy property reviewed in the Lazy task of this course was added:


```kotlin
private val newsManager by lazy { NewsManager() }
```      
This newsManager will be initialized with the NewsManager() only the first time that newsManagers field is used.

  
You should pass the following code to the
```kotlin
subscriber
```      
in the upper placeholder.You should invoke the
```kotlin
subscriber
```      
's method onNext() here, passing news as the parameter in the lower placeholder.  
