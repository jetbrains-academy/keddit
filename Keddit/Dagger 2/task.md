Dependency injection
--------------------

Dependency is a concept in computer science describing how close two objects are connected: if one objects uses another one, it depends on it. in this case the dependent object uses some knowledge of implementation of its dependency to interact with it. Thus, modification of dependency may alter or compromise the behaviour of dependent.

DI is a technique for one object supplying external dependency for another one, so it does not have to be responsible for setting an action up. Thus, an external entity configures the object by itself and it avoids modifications whatever happens to its dependency.

Dependency injections in an application are managed by a dependency injection container: an entity which takes the responsibility of instantiating and injecting different components. There are various dependency injection containers, but we will use Dagger 2.

Here are some other materials with further explanation by[Jakob Jenkov](http://tutorials.jenkov.com/dependency-injection/index.html)

Dagger 2
--------


> Dagger is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.You can check out this video from[Jake Wharton.](https://youtu.be/plK0zyRLIP8)as a good example of further dagger explanation.

 **Dependency** 

Dagger 2 was added as dependency to your Keddit App in the
```kotlin
build.gradle
```      
file:


```kotlin
implementation 'com.google.dagger:dagger:2.4'
kapt 'com.google.dagger:dagger-compiler:2.4'
provided 'org.glassfish:javax.annotation:10.0-b28'
```      
You can move onto the next task, it contains examples of using DI with Dagger 2.

