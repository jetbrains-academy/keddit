`WebSettings` object manages settings state for a `WebView`. When a `WebView` is first created, it obtains a set of default settings. These default settings will be returned from any getter call. A `WebSettings` object obtained from `WebView#getSettings()` is tied to the life of the `WebView`.

\
The `WebSettings` method `setJavaScriptEnabled()` tells the `WebView` to enable JavaScript execution. It would be necessary to render the content of such source as reddit. But one should be careful using it, as it opens the app to some vulnerabilities. Be sure you trust the provider of the web-content you display with app.


\
**Task:** Complete the `PostFragment.kt`, by invoking the `setJavaScriptEnabled()` method of the `WebSettings` belonging to the `WebView` you created in the previous task.


\
You can read more on the official documentation [page](https://developer.android.com/reference/android/webkit/WebSettings)

<div class="hint">
  Hints can be added anywhere in task text: type "hint" and press Tab.
</div>