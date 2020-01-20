Introduction
------------

In this course you will overview several topics related to creating an Android app using Kotlin programming language. The course will cover some basics of Android development, but if you have some relevant experience do not hesitate to skip topics familiar to you. Course also describes some major advantages Kotlin has for such a purpose, compared to java, so even an experienced developer can find something interesting to look at. Course is provided with some external links on basic Android and Kotlin features, so if you struggle at some point try to look up the links inside the text, as not all of the theory is included in the task descriptions itself.

The course describes a simple app providing a list of the most recent posts on reddit in an Android device. The app itself is not complicated in any way and is used more as an illustration of some concepts listed above.


Basic app structure
-----
Let's take a quick look at the elements of the application available at the beginning.

Main Activity
---

Our app includes an element called [MainActivity](https://developer.android.com/guide/components/activities/intro-activities) - starting point of the application. It is contained in package `main.java.com.edu.keddit`. Check it out, it will be changed further in the course.

Basically, every app consists of several screens, each of the screens includes an activity and a layout. Activity is a class defining the user's interactions with the particular screen of the application.

res
---

There are several [resources](https://developer.android.com/guide/topics/resources/providing-resources) our app is going to use - they are placed in `src.main.res`.


Task:
-----

Complete the declaration of MainActivity Class.


Run:
-----
In every step of this course you can run your current version of the application. To do so use the **run** button from the control panel:

<img src="./run-command.png" alt="The path to the action. Remember, you can just use the Find Action command." width="300"/>

Or, alternatively, you can invoke the context menu in your `MainActivity` class and use the `Run` command from there.

You can see the progress of the application creation by running it, though not every step will bring the visible changes to the UI.

If you don't have any AVD setup yet, you can follow [this instruction](https://developer.android.com/studio/run/managing-avds#createavd), this is a straightforward process. You can use any device supporting Android 9.0 or higher. 