# Native Android Animation with Jetpack Compose - DynamicAnimation

**About The Project**
This project introduces a customizable animation component, DynamicAnimation, created using Android Jetpack Compose. It allows developers to generate animated icons based on vector graphics (path data) or drawable resources. Designed to empower Android native animations, the component provides flexibility over key properties such as icon size, fill color, and stroke color, enabling dynamic visual effects within user interfaces.

**Purpose**
The goal of this project is to offer Android app developers an accessible means to incorporate engaging Jetpack Compose animations into their user interfaces.

**How To Use?**
To utilize the DynamicAnimation component, you need to specify the path data of the vector graphic or drawable you wish to animate, along with desired start and end sizes, and fill and stroke colors. 

```kotlin
DynamicAnimation(
    iconPath= /* Use drawable resource */ ,
    onClick = {}, // Define what happens on click
    startValue = 16f, // Initial size
    endValue = 32f, // Final size after animation
    fillColor = Color.Red, // Fill color of the icon
    strokeColor = Color.Red, // Stroke color of the icon
    modifier = Modifier.padding(16.dp) // Modifier for additional customization
)
```

### Features
- **Customizable Vector Graphics: Easily animate any vector graphic defined by path data or use drawable resources for your animations.**
- **Flexible Design: Adjust the size, fill color, and stroke color to fit the theme and purpose of your app.**
- **Interactive: Optionally, add click actions to make the animated icons interactive.**
- **Minimalistic Approach: Designed to integrate seamlessly with Jetpack Compose, promoting cleaner code and enhancing development productivity.**
