100% Java Interoperability
--------------------------

This is another great feature about Kotlin, you can use Java code from a Kotlin file and vice-versa. In the Keddit App we are extending from `AppCompatActivity`, using the `Bundle` object in the `onCreate` method and of course using all the Android SDK to create our App. Also, we are using other Java libraries like Retrofit, Picasso, etc.

Something really important about this is that Kotlin doesn’t have its own collections library, it relies on Java standard library classes, extending those classes with new functions. This means that you never need to convert objects between Java and Kotlin.
\
\
You can move on to the next task.

