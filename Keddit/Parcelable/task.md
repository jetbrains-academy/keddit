Parcelable
----------

If you were working with Android for sure you already know about
```kotlin
Parcelable
```      
. A
```kotlin
Parcelable
```      
is an interface for classes whose instances can be written to and restored from a
```kotlin
Parcel
```      
. This is a fast mechanism that Android provides as a IPC (Inter Process Communication) transport and the
```kotlin
Parcel
```      
is the message container to transfer.

Also, Android provides some lifecycle methods that will allow you to persist temporarily the information required for our classes in a
```kotlin
Parcel
```      
class while having a runtime change (rotating the device or if the activity is killed by the OS). In your case, save your news from this situations by implementing the
```kotlin
Parcelable
```      
interface.

Data Classes with Parcelable
----------------------------

Let’s review one of the classes:


```kotlin
data class RedditNews(val after: String,
                      val before: String,
                      val news: List<RedditNewsItem>) : Parcelable {

    // 1
    companion object {
        // 2
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { function(it) } // 3
    }

    // 4
    protected constructor(parcelIn: Parcel) : this(
                ...
            }
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        ...
    }

    override fun describeContents() = 0
}
```      
1. Companion object
-------------------

As you may notice, in Kotlin there is no static keyword to create a static member for a class but exists something called companion objects which allows you to provide the same behavior. When using this keyword you are declaring an object (an instance) directly in the code and all the properties and methods inside companion object can be called directly by using the class name:


```kotlin
data class RedditNews(...)
    companion object {
        val ENDPOINT = "http://kotlinlang.org"
    }
}
```      
Use it:


```kotlin
RedditNews.ENDPOINT
```      
You are going to use it to expose the CREATOR function.

2. @JvmField Annotation
-----------------------

Classes implementing the Parcelable interface must also have a non-null static field called CREATOR of a type that implements the Parcelable.Creator interface. In order to make your CREATOR implementation visible as a field in Java you need this special annotation called “@JvmField”, otherwise it will not be found and in the middle of the process it will throw an exception.

3. Extension Function for the Creator
-------------------------------------

Check out this useful extension function that creates the CREATOR passing as parameter a function:


```kotlin
val CREATOR = createParcel { function(it) }
```      
The definition of this extension function is like this:


```kotlin
inline fun <reified T : Parcelable> createParcel(
        crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }
```      
3.1) Inline Functions
---------------------

The inline modifier means that the function itself and the function passed to it, will be inlined into the call site, it means like you were implementing manually this function at every place that you were using it. Behind the scenes, the compiler will be generating specific bytecode at every place that you use it (it’s like “copy & pasting” this function in all the place that you were using it) giving you better performance and avoiding to create new classes for you like a normal extension function could do.

3.2) reified T
--------------

If you need to access to a type passed as a parameter,
```kotlin
reified
```      
keyword is here to save you! with the reified modifier now it’s accessible inside the function, almost as if it were a normal class and no reflection is needed!

3.3) crossinline
----------------

If you need to execute the function passed as parameter in another context then
```kotlin
crossinline
```      
allows you to use it in this way and maybe run it also in another thread. In this case, inside the Creator object.

4. Secondary Constructors
-------------------------

In this course classes were created with primary constructors like this:


```kotlin
data class News(val title: String)
```      
But maybe the primary constructor is not enough specially for scenarios where you need to provide alternatives way to create this class, like in this example that requires a Parcel parameter.


```kotlin
protected constructor(parcelIn: Parcel) : this(...)
```      
Task:
-----

Complete the
```kotlin
Parcelable
```      
implementation in
```kotlin
Models.kt
```      
in commons package: insert the interface to implement, insert correct annotation in the companion object declaration, and pass the
```kotlin
ReddiNews()
```      
constructor as the parameter to
```kotlin
createParcel
```      
method. Also, checkout the
```kotlin
createParcel
```      
implementation in the
```kotlin
Extensions.kt
```      
in the commons package.

  
In the first placeholder you should insert the name of implemented interface -
```kotlin
Parcelable
```      
.In the second placeholder you should right the annotations for the
```kotlin
CREATOR
```      
variable - that it is a
```kotlin
JvmField
```      
and you want to supress
```kotlin
"unused"
```      
warning.In the third placeholder you should pass the
```kotlin
RedditNews
```      
constructor with
```kotlin
it
```      
as a parameter.  
