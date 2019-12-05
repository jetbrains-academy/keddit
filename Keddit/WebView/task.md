`WebView` objects allow you to display web content as part of your activity layout, but lack some of the features of fully-developed browsers. A `WebView` is useful when you need increased control over the UI and advanced configuration options that will allow you to embed web pages in a specially-designed environment for your app.

\
If you want to deliver a web application (or just a web page) as a part of a client application, you can do it using `WebView`. The `WebView` class is an extension of Android's `View` class that allows you to display web pages as a part of your activity layout. It does not include any features of a fully developed web browser, such as navigation controls or an address bar. All that `WebView` does, by default, is show a web page.

\
We will use the `WebView` to display the content of a post. Though it could be me more useful to create a whole new view for those purposes, it will be a good demonstration of a different feature the platform provides.

\
**Task:** Complete the `WebView` declaration in the `post_fragment.xml` layout. It should contain fields `id`, `layout_width` and `layout_heigth`. Last two should match parent.

\
Also, create a new WebView, using the findByViewId method of the view variable in the `PostFragment.kt` and invoke the loadUrl method of it, passing the 'https://www.reddit.com' address as the parameter.

\
You can learn more in the [official documentation](https://developer.android.com/reference/android/webkit/WebView).

