Annotation Processing
---------------------

As you may know, annotaions are


> a form of metadata, providing data about a program that is not part of the program itself.Before the next task, you should know that Kotlin has its own Annotation Processing Tool for Kotlin ([kapt](https://kotlinlang.org/docs/reference/kapt.html)).

After 1.1.x Kotlin version, you have to configure kapt in a different way in your
```kotlin
gradle.build
```      
:


```kotlin
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-kapt' // <- add this plugin
```      
The annotations are essential part of sophisticated programms helping the JVM and other tools to process code in a right way.

You can move on to the next task.

