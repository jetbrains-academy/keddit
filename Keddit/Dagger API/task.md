Dagger API
----------

Here we will implement 4 main annotations `Dagger` has to provide dependency injection (there are others but they are not covered in this topic)

* `@Modules` + `@Provides`: provides dependencies. A `@Provides`-annotated method is used to satisfy a dependency requiring a method. This method satisfies a dependency defined by its return type. All `@Provides`-annotated methods must be included in a module - a class annotated with `@Module`.
* `@Inject`: request dependencies. `@Inject` should annotate the constructor used by `Dagger` while creating instances of a class. `Dagger` obtains the required parameters values and invokes annotated constructor while creating an instance.
* `@Component`: bridge between modules and injections. The classes annotated with `@Inject` and `@Provides` are used to form a graph of objects, which dependencies do link. Code invoking that graph accesses it through roots. This set is defined by an interface with methods returning the needed type and having no arguments. This interface should be annotated as `@Component`, the module types should be passed as module parameters, so `Dagger 2` could generate an implementation of that contract.
Thanks to default constructors in Kotlin, some dependencies from the constructor were already provided, so you don’t have to change so much your code in the Keddit App in order to provide those.

@Modules
--------

3 modules were created:

* `AppModule`: provides the `Context` and the instance to `Keddit` application.
* `NetworkModule`: provides an instance of `Retrofit`.
* `NewsModule`: provides the `NewsAPI` and `RedditApi` instances.
They are all located in the `di` package.

Also you need to provide the `NewsManager`, but it is not listed in any `Module` class, this is because you can annotate a constructor of a class that you created with the `@Inject` annotation and `Dagger` by default will create a `Factory` and make this class available to be provided like any other `@Provide` in the module classes. Kotlin also allows you to add annotations inlined with the constructor in this way:


```kotlin
@Singleton
class NewsManager @Inject constructor(private val api: NewsAPI) {
    ...
}
```      
@Inject
-------

Dependencies are requested in 2 places:

* `NewsManager`: as you saw previously in the constructor.
* `NewsFragment`: you need here the `NewsManager`:

```kotlin
@Inject lateinit var newsManager: NewsManager
```      

Remember that `lateinit` allows you to define a non-nullable property and set the value later.

@Component
----------

A component called `NewsComponent` was created which will be the bridge between the modules and injections:


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
At least for now you don't need to expose any other thing than a method to inject dependencies for the `NewsFragment`. `Dagger` will implement this method, search for injectable annotations and provide them.

Binding Altogether
------------------

Dagger will create a new class called `DaggerNewsComponent` which will have a builder to create an implementation of our `NewsComponent` interface. You are going to create an instance of this and make it available from the `KedditApp` class in a static way:


```kotlin
companion object {
    lateinit var newsComponent: NewsComponent
}
newsComponent = DaggerNewsComponent.builder()
        .appModule(AppModule(this))
        //.newsModule(NewsModule()) NOT REQUIRED
        .build()
```      

 Modules with empty constructor are implicitly created by `Dagger`, so in this case you don’t need to do `.newsModule(…)`, the `NewsModule` will be created inside the builder for you.
 You can use this `newsComponent` in this way from your `NewsFragment`:


```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    KedditApp.newsComponent.inject(this)
}
```      
Task:
-----

Provide the necessary annotations in the di package (all of the files), `NewsFragment.kt` and `NewsManager.kt`.

<div class='hint'>All of the classes in di package use annotations @Provides and @Singleton for their methods, except the NewsComponent.kt. NewsComponent uses @Singleton and @Component in its declaration.</div>
<div class='hint'>In the NewsFragment.kt newsManager variable should be annotated with @Inject.</div>
<div class='hint'>In the NewsManager.kt class should be annotated with @Singleton and the constructor should be annotated with @Inject.</div>
  
