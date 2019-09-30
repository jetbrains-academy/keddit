Properties and Fields
---------------------

In Kotlin you access properties like accessing a field in Java. Instead of calling the getResources() method from an Activity you directly do:


```kotlin
resources.getString(R.string.id)
// vs
getResources().getString(R.string.id)
//the second one is still allowed
```      
You can still call the getResource() method but Android Studio will suggest you to change it.It doesn’t mean that you are accessing the field directly, it’s calling the “getResource()” method but in a more convenient way.

FragmentManager
---------------

A FragmentManager is an entity responsible for interactions with fragments associated with a particular activity. The fragments will be described more in detail later in the course. For now you can just assume them to be parts of activities, visible and interactive, that could be used by different activities to avoid the code duplication.

clearBackStack()
----------------

Here we create a method `clearBackStack()` which would be used later for clearing things up in case of the activity reload.

Task:
-----

Complete the condition by checking if the `backStackEntryCount` property of the `manager` variable is greater than 0.





  
<div class='hint'>Just type the "backStackEntryCount", you can invoke this property of the `supportFragmentManager` without calling any methods explicitly.</div>
