Saving News
-----------

Now you need to use the `onSaveInstanceState` to save your news.

The most interest code is this:


```kotlin
news_list.apply {
    ...
    ...
    ...
}
```


`apply` is an Extension Function that allows you to execute a code block as you were inside the instance of the object that you are executing the apply function. It’s really useful for cases like this that you don’t want to put all the time `news_list`. Every time you need to set a value or call a method from this object.

Task:
-----

Complete the `apply` invocation in `OnActivityCreated` method in `NewsFragment.kt`.


  
<div class='hint'>You should invoke `apply` in the placeholder.</div>
