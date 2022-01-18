# Activity Results API

## Getting a result from an activity

- While the underlying startActivityForResult() and onActivityResult() APIs are available on the Activity class on all API levels, it is strongly recommended to use the Activity Result APIs introduced in AndroidX Activity and Fragment.

- When starting an activity for a result, it is possible (and, in cases of memory-intensive operations such as camera usage, almost certain) that your process and your activity will be destroyed due to low memory.

- For this reason, the Activity Result APIs decouple the result callback from the place in your code where you launch the other activity. As the result callback needs to be available when your process and activity are recreated, the callback must be unconditionally registered every time your activity is created, even if the logic of launching the other activity only happens based on user input or other business logic.

### Note: While it is safe to call registerForActivityResult() before your fragment or activity is created, you cannot launch the ActivityResultLauncher until the fragment or activity's Lifecycle has reached CREATED.

### Note: Since your process and activity can be destroyed between when you call launch() and when the onActivityResult() callback is triggered, any additional state needed to handle the result must be saved and restored separately from these APIs.
