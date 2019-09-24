Delegated Properties
--------------------

Delegated Properties are an excellent way to reuse common behavior that you may recurrently need for a property. In Kotlin you already have some common delegated properties defined in the language (also you can create your own). Here we are going to use this existing delegated property:


>  **Lazy properties:** The value gets computed only upon first access.Here we are going to see just the lazy property and in other parts another concepts about Delegated Properties will be introduced.

 **Lazy** 

This is a great delegated property that you are going to use to avoid initializing
```kotlin
newsList
```      
as a nullable object. With Lazy you can create it as a non-nullable property, executed just when you use it and just the first time.

Lazy will be initializing
```kotlin
newsList
```      
with the value that you execute in the code block:


```kotlin
private val newsList: RecyclerView by lazy {
    view?.findViewById(R.id.news_list) as RecyclerView
    }
```      
You can use the news\_list synthetic property to avoid using findViewById and as the type can be inferred by the context we can also remove the property type:


```kotlin
by lazy {
    news_list
}
```      
The lazy block will be executed when the application uses it, in this case in the
```kotlin
onActivityCreated()
```      
method:


```kotlin
override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    newsList.setHasFixedSize(true) // <-- Lazy executed!
    newsList.layoutManager = LinearLayoutManager(context)
}
```      
This initialization code could be moved inside the
```kotlin
onActivityCreated
```      
into the lazy block in this way:


```kotlin
private val newsList by lazy {
    news_list.setHasFixedSize(true)
    news_list.layoutManager = LinearLayoutManager(context)
    news_list // this will work as the return type
}
```      
For now you are not calling the
```kotlin
newsList
```      
in any place, so the
```kotlin
RecyclerView
```      
will raise an Exception as it doesn’t have a layout manager set. Leave it as it is for now it is going to be changed in this way later.

You can move on to the next task.

