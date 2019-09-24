Saving News
-----------

Now you need to use the
```kotlin
onSaveInstanceState
```      
to save your news.

The most interest code is this:


```kotlin
news_list.apply {
    ...
    ...
    ...
}
```      

```kotlin
apply
```      
is an Extension Function that allows you to execute a code block as you were inside the instance of the object that you are executing the apply function. It’s really useful for cases like this that you don’t want to put all the time “
```kotlin
news_list
```      
.” every time you need to set a value or call a method from this object.

Task:
-----

Complete the
```kotlin
apply
```      
invocation in
```kotlin
OnActivityCreated
```      
method in
```kotlin
NewsFragment.kt
```      


  
You should invoke
```kotlin
apply
```      
in the placeholder.  
