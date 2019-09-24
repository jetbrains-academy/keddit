Gradle
------

As well as other android applications, Keddit uses gradle as a build tool. It means all of the modules and external libraries or packages are compiled together according to the rules provided via
```kotlin
gradle.build
```      
file. In this course it is updated for you during the tasks, so you don't need to implement changes yourself, but all of them are provided for you to use in your further development. To use them properly you should check out[Gradle introduction](https://guides.gradle.org/building-android-apps/#review_the_top_level_gradle_build_file).

E.g.
```kotlin
gradle.build
```      
structure (detailes are spared for now, you will get to them later)


```kotlin
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'

android {
  compileSdkVersion 27
  buildToolsVersion '27.0.3'

  defaultConfig {
    ...
  }
  buildTypes {
    release {
    }
  }
}

dependencies {
  ...
}
buildscript {
  ...
}
```      


You can move on to the next task.

