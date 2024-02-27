# Native Android Animation with Jetpack Compose - DynamicAnimations

![GIF1](https://i.ibb.co/zh7QLz2/Screen-recording-20240227-135713-ezgif-com-resize.gif)
![GIF2](https://i.ibb.co/Dg4QJvP/Screen-recording-20240227-191730-ezgif-com-video-to-gif-converter.gif)

**About The Project**
- This project introduces a customizable animation component, DynamicAnimations, created using Android Jetpack Compose. It allows developers to generate animated icons based on vector graphics (path data) or drawable resources. Designed to empower Android native animations, the component provides flexibility over key properties such as icon size, fill color, and stroke color, enabling dynamic visual effects within user interfaces.

**Purpose**
- The goal of this project is to offer Android app developers an accessible means to incorporate engaging Jetpack Compose animations into their user interfaces.

**How To Use?**
- For DynamicAnimationWithPath : To utilize the DynamicAnimation component, you need to specify the path data of the vector graphic or drawable you wish to animate, along with desired start and end sizes, and fill and stroke colors.
  
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
