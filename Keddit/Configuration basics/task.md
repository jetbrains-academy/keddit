Introduction
------------

In this course you will overview several topics related to creating an Android app using Kotlin programming language. The course will cover some basics of Android development, but if you have some relevant experience do not hesitate to skip topics familiar to you. Course also describes some major advantages Kotlin has for such a purpose, compared to java, so even an experienced developer can find something interesting to look at. Course is provided with some external links on basic Android and Kotlin features, so if you struggle at some point try to look up the links inside the text, as not all of the theory is included in the task descriptions itself.

The course describes a simple app providing a list of the most recent posts on reddit in an Android device. The app itself is not complicated in any way and is used more as an illustration of some concepts listed above.

Create Project
--------------

If you would need to start from scratch, you would need to launch Android Studio and create a new Project, name it “Keddit” and select “Blank Activity”. In this course all of these arrangements are already done.

Basic app structure
-------------------

Main Activity
-------------

Our app includes an element called[MainActivity](https://developer.android.com/guide/components/activities/intro-activities)- starting point of the application. It is contained in package
```kotlin
main.java.com.edu.keddit
```      
Check it out, it will be changed further in the course.

Basically, every app consists of several screens, each of the screens includes an activity and a layout. Activity is a class defining the user's interactions with the particular screen of the application.

res
---

There are several[resources](https://developer.android.com/guide/topics/resources/providing-resources)our app is going to use - they are placed in
```kotlin
src.main.res
```      


You can move onto the next task.

