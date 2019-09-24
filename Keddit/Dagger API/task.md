Dagger API
----------

Here we will implement 4 main annotations Dagger has to provide dependency injection (there are others but they are not covered in this topic)

* 
```kotlin
@Modules
```      
+
```kotlin
@Provides
```      
: provides dependencies. A
```kotlin
@Provides
```      
-annotated method is used to satisfy a dependency requiring a method. This method satisfies a dependency defined by its return type. All
```kotlin
@Provides
```      
-annotated methods must be included in a module - a class annotated with
```kotlin
@Module
```      
.
* 
```kotlin
@Inject
```      
: request dependencies.
```kotlin
@Inject
```      
should annotate the constructor used by Dagger while creating instances of a class. Dagger obtains the required parameters values and invokes annotated constructor while creating an instance.
* 
```kotlin
@Component
```      
: bridge between modules and injections. The classes annotated with
```kotlin
@Inject
```      
and
```kotlin
@Provides
```      
are used to form a graph of objects, which dependencies do link. Code invoking that graph accesses it through roots. This set is defined by an interface with methods returning the needed type and having no arguments. This interface should be annotated as
```kotlin
@Component
```      
the module types should be passed as module parameters, so Dagger 2 could generate an implementation of that contract.
Thanks to default constructors in Kotlin, some dependencies from the constructor were already provided, so you don’t have to change so much your code in the Keddit App in order to provide those.

@Modules
--------

3 modules were created:

* 
```kotlin
AppModule
```      
: provides the
```kotlin
Context
```      
and the instance to Keddit application.
* 
```kotlin
NetworkModule
```      
: provides an instance of Retrofit.
* 
```kotlin
NewsModule
```      
: provides the
```kotlin
NewsAPI
```      
and
```kotlin
RedditApi
```      
instances.
They are all located in the
```kotlin
di
```      
package.

Also you need to provide is the "
```kotlin
NewsManager
```      
" but it is not listed in any Module class, this is because you can annotate a constructor of a class that you created with the "
```kotlin
@Inject
```      
" annotation and Dagger by default will create a
```kotlin
Factory
```      
and make this class available to be provided like any other "
```kotlin
@Provide
```      
" in the module classes. Kotlin also allows you to add annotations inlined with the constructor in this way:


```kotlin
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {
    ...
}
```      
@Inject
-------

Dependencies are requested in 2 places:

* 
```kotlin
NewsManager
```      
: as you saw previously in the constructor.
* 
```kotlin
NewsFragment
```      
: you need here the
```kotlin
NewsManager
```      
:

```kotlin
@Inject lateinit var newsManager: NewsManager
```      

> Remember that '
> ```kotlin
> lateinit
> ```      
> ' allows you to define a non-nullable property and set the value later.@Component
----------

A component called '
```kotlin
NewsComponent
```      
' was created which will be the bridge between the modules and injections:


```kotlin
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}
```      
At least for now you don't need to expose any other thing than a method to inject dependencies for the
```kotlin
NewsFragment
```      
. Dagger will implement this method, search for injectable annotations and provide them.

Binding Altogether
------------------

Dagger will create a new class called
```kotlin
DaggerNewsComponent
```      
which will have a builder to create an implementation of our
```kotlin
NewsComponent
```      
interface. You are going to create an instance of this and make it available from the
```kotlin
KedditApp
```      
class in a static way:


```kotlin
companion object {
    lateinit var newsComponent: NewsComponent
}
newsComponent = DaggerNewsComponent.builder()
        .appModule(AppModule(this))
        //.newsModule(NewsModule()) NOT REQUIRED
        .build()
```      

> Modules with empty constructor are implicitly created by Dagger, so in this case you don’t need to do "
> ```kotlin
> .newsModule(…)
> ```      
> ", the
> ```kotlin
> NewsModule
> ```      
> will be created inside the builder for you.You can use this
```kotlin
newsComponent
```      
in this way from your
```kotlin
NewsFragment
```      
:


```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    KedditApp.newsComponent.inject(this)
}
```      
Task:
-----

Provide the necessary annotations in the di package (all of the files),
```kotlin
NewsFragment.kt
```      
and
```kotlin
NewsManager.kt
```      
.

All of the classes in
```kotlin
di
```      
package use annotations
```kotlin
Provides
```      
and
```kotlin
Singleton
```      
for their methods, except the
```kotlin
NewsComponent.kt
```      
.
```kotlin
NewsComponent
```      
uses
```kotlin
Singleton
```      
and
```kotlin
Component
```      
in its declaration.In the
```kotlin
NewsFragment.kt
```      

```kotlin
newsManager
```      
variable should be annotated with
```kotlin
Inject
```      
In the
```kotlin
NewsManager.kt
```      

```kotlin
class
```      
should be annotated with
```kotlin
Singleton
```      
and the constructor should be annotated with
```kotlin
Inject
```      
  
