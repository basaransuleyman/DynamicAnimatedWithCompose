# Native Android Animation with Jetpack Compose - DynamicAnimations

**About The Project**
- This project introduces a customizable animation component, DynamicAnimations, created using Android Jetpack Compose. It allows developers to generate animated icons based on vector graphics (path data) or drawable resources. Designed to empower Android native animations, the component provides flexibility over key properties such as icon size, fill color, and stroke color, enabling dynamic visual effects within user interfaces.

**Purpose**
- The goal of this project is to offer Android app developers an accessible means to incorporate engaging Jetpack Compose animations into their user interfaces.

**How To Use?**
- For DynamicAnimationWithPath : To utilize the DynamicAnimation component, you need to specify the path data of the vector graphic or drawable you wish to animate, along with desired start and end sizes, and fill and stroke colors.
- 
![GIF1](https://i.ibb.co/vx1HbCC/Screen-recording-20240227-191730-ezgif-com-resize.gif)

```kotlin
DynamicAnimation(
    iconPath= /* Use drawable resource */ ,
    onClick = {}, // Define what happens on click
    startValue = Float, // Initial size
    endValue = Float, // Final size after animation
    fillColor = Color.X, // Fill color of the icon
    strokeColor = Color.Y, // Stroke color of the icon
    modifier = .. // Modifier for additional customization
)
```

- For DynamicAnimationWithDifferentIcons:  You need to specify the drawable resources for the first, second, and third states. The component handles user interactions, animates between states.

```kotlin
DynamicAnimationWithDifferentIcons(
 firstIcon = R.drawable.X,
 secondIcon = R.drawable.Y,
 thirdIcon =R.drawable.Z,
 onIconClick = {},
 modifier = Modifier )
```
