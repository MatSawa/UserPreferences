# User Preferences
## Kotlin Multiplatform Key-Value Storage Library

This is a Kotlin Multiplatform library for storing key-value data in Android and iOS applications. It is designed to provide a consistent interface for storing and retrieving data across both platforms. Under the hood, the library uses Shared Preferences on Android and User Defaults on iOS.

# Requirements

Android API Level >= **21**
iOS **ios_arm64** and **ios_x64** targets

## Adding the library to your project

To use the library, you need to add the library to your project dependencies. Here's how you can do it in Gradle:

Add `mavenCentral` to your repositories in the `build.gradle.kts` file:

```kotlin
repositories {
    mavenCentral()
    // others
}
```

Add the library to your project dependencies in the commonMain:

```kotlin
 commonMain {
    dependencies {
        implementation("com.matsawa:userpreferences:0.0.1")
        // others
    }
}
```

## Adding the library to your project

After adding the library, you can use it in your code. Here is an example of how to store and retrieve a String value:

```kotlin
// Store a value
userPreferences.addString("myKey", "myValue")

// Retrieve a value
val value = userPreferences.getString("myKey")
```

The library also supports other basic data types, such as Boolean, Int, Long, Float, and Double:

```kotlin
// Store a value
userPreferences.addBoolean("myKey", true)

// Retrieve a value
val value = userPreferences.getBoolean("myKey")
```

You can also retrieve any data type with a default value if the key is not found in storage:

```kotlin
// Retrieve a value with a default if not found
val value = userPreferences.getInt("myKey", defaultValue = value)
```

You can remove a single element by key:

```kotlin
// Remove a single element by key
userPreferences.remove("myKey")
```

You can remove all elements:

```kotlin
// Remove all elements
userPreferences.clear()
```

You can check if an element exists:

```kotlin
// Check if an element exists
val exists = userPreferences.contains("myKey")
```

For more information on how to use the library, please check our [sample](https://github.com/Sawul/UserPreferences/tree/main/KmmSample).


# Contributing
Contributions to the library are welcome. If you find a bug or have a feature request, please open an issue on the GitHub repository. If you would like to contribute code, please fork the repository and submit a pull request.

# License
The library is released under the MIT License. Please see the [LICENSE](https://github.com/Sawul/UserPreferences/blob/main/LICENSE) file for more information.
