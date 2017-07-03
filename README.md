# RichUtils
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RichUtils-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5854) [![](https://jitpack.io/v/WindSekirun/RichUtilsKt.svg)](https://jitpack.io/#WindSekirun/RichUtilsKt)	[![Kotlin](https://img.shields.io/badge/kotlin-1.1.2-blue.svg)](http://kotlinlang.org)	[![CircleCI](https://circleci.com/gh/WindSekirun/RichUtilsKt.svg?style=svg)](https://circleci.com/gh/WindSekirun/RichUtilsKt) [![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

<img src="richutils-logo.png" alt="RichUtils logo" height="101" width="220" />

Advancement Utils for Android Developer written by [Kotlin](https://kotlinlang.org)

Are you tired to write duplicate, dirty code to develop your android application? RichUtils provided fully Documented and high quality of many utils so more! With [Anko](https://github.com/Kotlin/anko) and [Kotlin android extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html), **Your developing time will be happier than before!**

If you are not ready to accept new language, Kotlin? Don't worry, RichUtils has compatibility both language, Kotlin and **Java**!

Main goals of this library is **Reuse code to help developer can math the due date of Project**

If you have any feature to make useful develop android application, Please leave any feature into issue tracker with **Suggestion** tag!

### Main Feature of Library
* Provide fully documented and High quality of many utils!
    * [List of Utils](https://github.com/WindSekirun/RichUtilsKt/blob/master/LIST_OF_UTILS.md)
    * Now RichUtils have **25 Utils** and **2 Widgets** and **1 Service**
* Provide [Web Document](https://windsekirun.github.io/RichUtilsKt/)
* Provide two sample application. one is [**Kotlin**](/sample), another is [**Java**](/samplejava)
* as Kotlin's main goal, RichUtils interoperable with **Java**

## Notice (1.2.0)
I changed package structure cause there are many utils to make developer confused.

from 1.2.0, all utils and widget have sub package. you should change import statement for library.

this work will have impact.  

### Usages

#### New version of Gradle
from *3.0.0-alpha3*, gradle syntax was changed. (as i know, not correctly)

*app/build.gradle*

```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.WindSekirun:RichUtilsKt:$1.2.0'
}
```

#### Old version of Gradle

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
    compile 'com.github.WindSekirun:RichUtilsKt:$1.2.0'
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
