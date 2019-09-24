ObserveOn
---------


```kotlin
ObserveOn
```      
is another method from the
```kotlin
Observable
```      
class and it allows you to define where do you want to execute the functions that you provided in the “
```kotlin
subscribe(…)
```      
” method. In other words, in which thread the functions that you provided in the
```kotlin
subscribe
```      
method are going to be executed with the
```kotlin
onNext
```      
and
```kotlin
onError
```      
code. As you need to execute this code in the Main UI Thread it could be a good idea to make your
```kotlin
Observable
```      
to
```kotlin
observeOn
```      
the Main UI Thread.

Here is where the RxAndroid dependency is need to be added to have a new
```kotlin
Scheduler
```      
called:


> AndroidSchedulers.mainThread()And you need to update your code to set the
```kotlin
observeOn
```      
Scheduler:


```kotlin
val subscription = newsManager.getNews()
        .subscribeOn(Schedulers.io())
        .observeOn(...) //observe your scheduler
        .subscribe ( ...
)
```      
Task:
-----

Complete the
```kotlin
onObserve()
```      
invocation to observe on
```kotlin
AndroidSchedulers.mainThread()
```      


And with this last change your mock data is creating in another thread and your news are shown on the screen.

But you have to realize that your app can be closed at any time or perform an orientation change operation in the middle of a subscription. This could leads you to a problem if you don’t manage your subscriptions properly, it will be described in the next task

  
Invoke the constructor of main thread of
```kotlin
AndroidSchedulers
```      
in the placeholder.  
