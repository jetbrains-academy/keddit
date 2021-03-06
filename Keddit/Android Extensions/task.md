Android Extensions
------------------

This is the Kotlin alternative for the famous “findViewById()” method (or other third party libraries to bind properties to an element of a view). Android Extensions add some convenient extension properties which allow you to access the elements of a view as it’s a property inside your Activity or Fragment with the proper view’s type already set.

In order to configure your project to enable Android Extensions, you should modify the build.gradle file from your app module, apply the kotlin-android-extensions plugin and re-sync with gradle:


```kotlin
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
```      
Now the findViewById was replaced with this - NewsFragment layout:


```kotlin
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                           android:layout_width="match_parent"
                           android:layout_height="match_parent" >

    <android.support.v7.widget.RecyclerView
            android:id="@+id/news_list"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

< /RelativeLayout>
```      
NewsFragment class:
-------------------

You will be able to access the news\_list RecyclerView from our NewsFragment class. An import to the synthetic properties generated by the plugin needs to be included:


```kotlin
import kotlinx.android.synthetic.main.news_fragment.*
```      
In this way you have access to all the elements in the layout that you choose in this import and use it directly from your code. In order to make sure the layout was already inflated, move your newsList assignment from `onViewCreated()` method to the `onActivityCreated()` to be sure that the view `news_fragment` was already inflated at the moment of the assignment.

You will be able to access news_list directly now.


```kotlin
// old code:
newsList = view?.findViewById(R.id.news_list) as RecyclerView?
newsList?.setHasFixedSize(true)
newsList?.layoutManager = LinearLayoutManager(context)
```      
RecyclerView
------------


`RecyclerView` is a layout component that allows user to interact with a list of information, providing the fell of its continuity. The toolbar above the `RecyclerView` will remain on top as you scroll the data.

The `recyclerView` interacts with its elements' data using an adapter, which you would create in the following tasks. The `RecyclerView` also uses a `LayoutManager` to describe behaviour of the elements in the UI. It will be also described more in the future.

Task:
-----

Complete `OnActivityCreated()` method in `NewsFragment.kt`: it should set `HasFixedSize` parameter of the newsList to `true` and also set its `layoutManager` to a `LinearLayoutManager` based on  `context`.


Notice that `news_list` is a non-nullable object so you can use it in your code without the “?” question mark. This could be a problem if you run this code in another part of the Activity lifecycle and the view was not previously inflated, this will throw an exception at runtime.

  
<div class='hint'>Set the fixed size parameter of the newsList to true. Set the layoutManager of the newsList to a new LinearLayoutManager passing context as an argument to the constructor.</div>
