Object Expressions
------------------

In Kotlin you have a concept called “Object expressions”, which works in a similar way as anonymous inner classes in Java, and allows you to create an object without explicitly declaring a new subclass for it. In this case we are using it to define our
```kotlin
loadingItem
```      
without creating a new class. The syntax is really intuitive and as you can see we are extending from ViewType and implementing the required interface.

Single Expressions
------------------

The
```kotlin
getViewType()
```      
method has only a single expression function inside the body. In Kotlin you can take advantage of this and convert this method:


```kotlin
override fun getViewType() : Int {
    return AdapterConstants.LOADING
}
```      
To this:


```kotlin
override fun getViewType() = AdapterConstants.LOADING
```      
It’s like assigning the value
```kotlin
AdapterConstants.LOADING
```      
to a function. This is a short way to do the same and it’s really more concise. Also you don’t have to specify the return value type as it can be inferred by the context. So this is how it looks now:


```kotlin
private val loadingItem = object : ViewType {
    override fun getViewType() = AdapterConstants.LOADING
}
```      
RecyclerView Adapters
---------------------

As it was mentioned before, you need to create an adapter for the
```kotlin
RecyclerView
```      
to operate with elements. The adapter takes care of creating all of the layouts displayed in the
```kotlin
View
```      
and connects them to the data. At this step the
```kotlin
NewsAdapter
```      
was created. It contains realization of several lifecycle methods essential for an
```kotlin
RecyclerView.Adapter
```      
:* 
```kotlin
onCreateViewHolder
```      
- this method is called whenever new instance of
```kotlin
ViewHolder
```      
is created.
* 
```kotlin
onBindViewHolder
```      
- this method is called when the
```kotlin
ViewHolder
```      
is bind to a certain position of the
```kotlin
RecyclerView
```      
layout.
* 
```kotlin
getItemCount
```      
returns the total number of items currently included into the
```kotlin
RecyclerView
```      
.
* 
```kotlin
getItemViewType
```      
returns the
```kotlin
ViewType
```      
of an item at the position indicated by the index in the method parameter.
There are also implementations of initial actions the adapter need to complete on the instance creation and private fields for two delegate adapters -
```kotlin
LoadingDelegateAdapter
```      
and
```kotlin
NewsDelegateAdapter
```      
. Both of them implement
```kotlin
onCreateViewHolder
```      
and
```kotlin
onBindViewHolder
```      
(which are called by the same named methods from the
```kotlin
NewsAdapter
```      
). This structure is complicated due to the fact that the
```kotlin
RecyclerView
```      
whould contain two different types of items - news from Reddit and a loading sign, inserted to the bottom of the list as one of the elements. The adapters are both implementations of an interface called
```kotlin
ViewTypeDelegateAdapter
```      
describing these methods.

There are also several service entities -
```kotlin
ViewType
```      
interface describing the
```kotlin
getViewType
```      
method and
```kotlin
AdapterConstants
```      
object containing constants for the types representation.
```kotlin
TimeExt
```      
provides the ways for the app to describe, how long ago was particular news posted. It may seem like a lot of code but it is actually very straight-forward, so it won't be covered here.

One more modification - the Extensions was modified, a
```kotlin
loadImg
```      
method was added to the
```kotlin
ImageView
```      
class. It provides an image for a News item, loaded via picasso, and if the url is missing (e.g. in case of mocking) provides one of the default icons.

Task:
-----

Complete the
```kotlin
getViewType()
```      
function override for it to return NEWS adapter constant in
```kotlin
Models.kt
```      
in
```kotlin
commons
```      
package.

  
Add the AdapterConstants property NEWS as the return value.  
