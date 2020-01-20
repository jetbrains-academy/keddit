Kotlin Syntax
-------------

Time to take a look at the Kotlin syntax.

Kotlin is defined in many ways and this is one of them that tries to include the most important characteristics in one sentence:
Kotlin is a Concise, Safe and Statically typed programming language.

onCreate()
---

All of the activities in the app must implement the `onCreate()` method - it is called by the android while creating the object of the activity, to setup basic parameters (e.g. choose the layout).

Let’s use the definition to start reviewing our generated code. Here we have both MainActivity files: Java and Kotlin files.

Java
----


```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    }
```      


Kotlin
------


```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view -> Snackbar.make(...).setAction("Action", null).show() }
    }
}
```      


Concise
-------

Take a look - the Java file has 19 lines of code and the Kotlin file has only 12.This is because most of the verbosity of Java was eliminated. Concise code takes less time to write and to read so it can improve your productivity.Extend and Implement:


The words “extends” and “implement” were replaced by a colon “:” indifferently. In this case we are extending from AppCompatActivity (which is a Java class)


```kotlin
class MainActivity : AppCompatActivity()
```      

100% Java Interoperability
-------

This is another great feature about Kotlin, you can use Java code from a Kotlin file and vice-versa. In the Keddit App we are extending from `AppCompatActivity`, using the `Bundle` object in the `onCreate` method and of course using all the Android SDK to create our App. Also, we are using other Java libraries like Retrofit, Picasso, etc.

Something really important about this is that Kotlin doesn’t have its own collections library, it relies on Java standard library classes, extending those classes with new functions. This means that you never need to convert objects between Java and Kotlin.

Fun-ctions
----------

There is not classic “public void methodName()” structure in Kotlin. Now the functions inside a class are defined with the “fun” keyword and the return type is added to the end. But where is the type returned from our “onCreate” method?


```kotlin
override fun onCreate(savedInstanceState: Bundle?) 
```      


In the case of not returning any value in Java “void” is used, in Kotlin the alternative is “Unit” which works in the same way. The compiler will know that the function not returning anything so it can be omitted. In the case of adding it just do it in this way:


```kotlin
override fun onCreate(savedInstanceState: Bundle?) : Unit 
```      


Also the parameters are in a different order. First you define the name of the variable and then the type.

Bye, Semicolon;
---------------

In Kotlin you don’t have to put the semicolon at the end of a sentences but still you can do it if you want (don’t do it).

Task:
-----

Complete the onCreate declaration for it to take a parameter with name savedinstanceState and type "Bundle?"







