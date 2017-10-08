# RichUtils
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RichUtils-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5854) [![](https://jitpack.io/v/WindSekirun/RichUtilsKt.svg)](https://jitpack.io/#WindSekirun/RichUtilsKt)	[![Kotlin](https://img.shields.io/badge/kotlin-1.1.4-blue.svg)](http://kotlinlang.org)	[![CircleCI](https://circleci.com/gh/WindSekirun/RichUtilsKt.svg?style=svg)](https://circleci.com/gh/WindSekirun/RichUtilsKt) [![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

<img src="richutils-logo.png" alt="RichUtils logo" height="101" width="220" />

Advancement Utils for Android Developer written by [Kotlin](https://kotlinlang.org)

Are you tired to write duplicate, dirty code to develop your android application? RichUtils provided fully Documented and high quality of many utils so more! With [Anko](https://github.com/Kotlin/anko) and [Kotlin android extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html), **Your developing time will be happier than before!**

If you are not ready to accept new language, Kotlin? Don't worry, RichUtils has compatibility both language, Kotlin and **Java**!

Main goals of this library is **Reuse code to help developer can math the due date of Project**

If you have any feature to make useful develop android application, Please leave any feature into issue tracker with **Suggestion** tag!

### Main Feature of Library
* Provide fully documented and High quality of many utils!
* Provide [Web Document](https://windsekirun.github.io/RichUtilsKt/)
* Provide two sample application. one is [**Kotlin**](/sample), another is [**Java**](/samplejava)
    * Some Utils does not provide Sample yet, but i will working on soon.
* as Kotlin's main goal, RichUtils interoperable with **Java**

### Usages

*rootProject/build.gradle*
```	
allprojects {
    repositories {
	    maven { url 'https://jitpack.io' }
    }
}
```

*app/build.gradle*
```
dependencies {
    implemention 'com.github.WindSekirun:RichUtilsKt:1.7.0'
}
```

### Contents

#### Utils
* [**RAlert**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RAlert.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/AlertActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/AlertActivity.java)
* [**RAssets**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RAssets.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/JSONActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/JSONActivity.java)
* [**RBitmap**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RBitmap.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/BitmapActivity.java)
* [**RClipboard**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RClipboard.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/DateActivity.java)
* [**RContactProvider**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RContactProvider.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/ContactActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/ContactActivity.java)
* [**RDate**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RDate.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/DateActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/DateActivity.java)
* [**RDeviceId**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RDeviceId.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PermissionActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PermissionActivity.java)
* [**RDimen**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RDimen.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MiscActivity.java)
* [**RDrawable**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RDrawable.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/BitmapActivity.java)
* [**RFile**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RFile.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/BitmapActivity.java)
* [**RFont**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RFont.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MainActivity.java)
* [**RHintSpinner**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RHintSpinner.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt)
* [**RInflater**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RInflater.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/RefreshRecyclerActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/RefreshRecyclerActivity.java)
* [**RJson**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RJson.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/JSONActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/JSONActivity.java)
* [**RKeyboard**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RKeyboard.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PreferenceActivity.kt)  [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PreferenceActivity.java)
* [**RKeyHash**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RKeyHash.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MiscActivity.java)
* [**RNetwork**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RNetwork.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MiscActivity.java)
* [**RPreference**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RPreference.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PreferenceActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PreferenceActivity.java)
* [**RPermission**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RPermission.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PermissionActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PermissionActivity.java)
* [**RPhoto**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RPhoto.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PickMediaActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PickMediaActivity.java)
* [**RPickMedia**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RPickMedia.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/PickMediaActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/PickMediaActivity.java)
* [**RReboot**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RReboot.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MainActivity.java)
* [**RStatusBar**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RStatusBar.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MainActivity.java)
* [**RStream**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RStream.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MainActivity.java)
* [**RThread**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RThread.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/BitmapActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/BitmapActivity.java)
* [**RUnReadCount**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RUnReadCount.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt)
* [**RVersion**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RVersion.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MiscActivity.java)
* [**RVibrate**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/utils/RVibrate.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt)

#### Widgets
* [**CenteredIconButton**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/widget/CenteredIconButton.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MainActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/MainActivity.java)
* [**CombinedTextView**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/widget/CombinedTextView.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/MiscActivity.kt)
* [**CombinedButton**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/widget/CombinedButton.kt)
* [**CombinedCheckBox**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/widget/CombinedCheckBox.kt)
* [**CombinedRadioButton**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/widget/CombinedRadioButton.kt)

#### Service
* [**RLocationService**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/service/RLocationService.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/LocationActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/LocationActivity.java)

#### Module
* [**RInAppBilling**](RichUtils/src/main/java/pyxis/uzuki/live/richutilskt/module/iap/RInAppBilling.kt) [(Sample)](sample/src/main/java/pyxis/uzuki/live/richutilssample/InAppActivity.kt) [(JavaSample)](samplejava/src/main/java/pyxis/uzuki/live/richutils/samplejava/InAppActivity.java)


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
