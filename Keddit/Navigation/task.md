Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's `Navigation` component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer. The Navigation component also ensures a consistent and predictable user experience by adhering to an established set of principles.

\
The Navigation component consists of three key parts that are described below:
* Navigation graph: An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app.
* `NavHost`: An empty container that displays destinations from your navigation graph. The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.
* `NavController`: An object that manages app navigation within a `NavHost`. The `NavController` orchestrates the swapping of destination content in the NavHost as users move throughout your app.


\
Check out the `nav_graph.xml` file.
```xml
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto" android:id="@+id/nav_graph"
    app:startDestination="@id/newsFragment">

    <fragment
        android:id="@+id/postFragment"
        android:name="com.edu.keddit.features.news.PostFragment"
        android:label="PostFragment" />
    <fragment
        android:id="@+id/newsFragment"
        android:name="com.edu.keddit.features.news.NewsFragment"
        android:label="NewsFragment" >
    </fragment>
</navigation>
```
Remember, that you should specify the start destination in the opening tag. Also, you need to provide descriptions for the fragments used in the navigation graph. They consist of the `id` used for references in the code, `name` equal to the path for the fragment class in the package, and `label` that will be shown to the user.

\
To allow navigation in the app we also added the dependencies that would be used by the components in the `build.gradle` file:
```groovy
implementation 'androidx.navigation:navigation-fragment-ktx:2.1.0'
implementation 'androidx.navigation:navigation-ui-ktx:2.1.0'
```

\
You can move on to the next task.

\
[Navigation Overview](https://developer.android.com/guide/navigation?gclid=CjwKCAiAws7uBRAkEiwAMlbZjgmzNWcCEEkAlXO58gcoejHiLU8WHu9lktt6IJ3nZDbI56C3mZ8rSBoCoEIQAvD_BwE)
