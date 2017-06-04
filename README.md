## RichUtils
[![](https://jitpack.io/v/WindSekirun/RichUtilsKt.svg)](https://jitpack.io/#WindSekirun/RichUtilsKt)	[![Kotlin](https://img.shields.io/badge/kotlin-1.1.2-blue.svg)](http://kotlinlang.org)	[![CircleCI](https://circleci.com/gh/WindSekirun/RichUtilsKt.svg?style=svg)](https://circleci.com/gh/WindSekirun/RichUtilsKt) 

Advancement Utils for Android Developer written by Kotlin

### List of Utils Classes (working)
* [RAlert](library/src/main/java/pyxis/uzuki/live/richutilskt/RAlert.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/AlertActivity.kt) 
    - toast, alert, confirm, progress, selector
* [RBitmap](library/src/main/java/pyxis/uzuki/live/richutilskt/RBitmap.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) 
    - cast to bitmap from drawable, save bitmap to file
* [RClipboard](library/src/main/java/pyxis/uzuki/live/richutilskt/RClipboard.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) 
    - copy text to clipboard, get text from clipboard
* [RDate](library/src/main/java/pyxis/uzuki/live/richutilskt/RDate.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) 
    - parse date
* [RDimen](library/src/main/java/pyxis/uzuki/live/richutilskt/RDimen.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DimenActivity.kt) 
    - dip, sp, px2dip, px2sp, dimen
* [RDownload](library/src/main/java/pyxis/uzuki/live/richutilskt/RDownload.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
    - Download file, bitmap from uri
* [RDrawable](library/src/main/java/pyxis/uzuki/live/richutilskt/RDrawable.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
    - Bitmap to Drawable
* [RThread](library/src/main/java/pyxis/uzuki/live/richutilskt/RThread.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt)
    - run code in background / ui thread
    
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
