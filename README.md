## RichUtils
[![](https://jitpack.io/v/WindSekirun/RichUtilsKt.svg)](https://jitpack.io/#WindSekirun/RichUtilsKt)	[![Kotlin](https://img.shields.io/badge/kotlin-1.1.2-blue.svg)](http://kotlinlang.org)	[![CircleCI](https://circleci.com/gh/WindSekirun/RichUtilsKt.svg?style=svg)](https://circleci.com/gh/WindSekirun/RichUtilsKt) [![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

<img src="richutils-logo.png" alt="RichUtils logo" height="101" width="220" />

Advancement Utils for Android Developer written by [Kotlin](https://kotlinlang.org)

Are you tired to write duplicate, dirty code to develop your android application? RichUtils provided fully Documented and high quality of many utils so more! With [Anko](https://github.com/Kotlin/anko) and [Kotlin android extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html), **Your developing time will be happier than before!**

Main goals of this library is **Reuse code to help developer can math the due date of Project** (Because i'm agency android developer, time is top priority.)

### List of Utils Classes
* [**RAlert**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RAlert.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/AlertActivity.kt) 
* [**RAssets**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RAssets.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/JSONActivity.kt)
* [**RBitmap**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RBitmap.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) 
* [**RClipboard**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RClipboard.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) 
* [**RDate**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RDate.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) 
* [**RDimen**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RDimen.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt) 
* [**RDownload**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RDownload.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
* [**RDrawable**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RDrawable.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
* [**RFilePath**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RFilePath.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PickMediaActivity.kt)
* [**RJson**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RJson.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/JSONActivity.kt)
* [**RPhoto**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RPhoto.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PickMediaActivity.kt)
* [**RPickMedia**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RPickMedia.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PickMediaActivity.kt)
* [**RReboot**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RReboot.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt)
* [**RThread**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RThread.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
* [**RVersion**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/RVersion.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt)

#### It will be available next Release

### Usages

**rootProject/build.gradle**
```	
allprojects {
    repositories {
	maven { url 'https://jitpack.io' }
    }
}
```

**app/build.gradle**
```
dependencies {
    compile 'com.github.WindSekirun:RichUtilsKt:${richutils_version}'
}
```

### License 
```
Copyright 2017 WindSekirun (DongGil, Seo)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
