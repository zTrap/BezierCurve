# Bezier curves creator
The simple multiplatform helper for build [Bezier curves](https://en.wikipedia.org/wiki/B%C3%A9zier_curve)

[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)
[![Download](https://img.shields.io/maven-central/v/ru.ztrap/beziercurve?style=flat)](https://central.sonatype.com/artifact/ru.ztrap/beziercurve)
[![Kotlin](https://img.shields.io/badge/kotlin-1.9.23-blue.svg?logo=kotlin)](http://kotlinlang.org)

## Install

```gradle
implementation 'ru.ztrap:beziercurve:${latestVersion}'
```

## Usage

1. Create some Bezier curve instance

```kotlin
// just a helpers. You still can provide a direct values in BezierCurve constructor
val startScene = BezierScene(3f, 7f, 21f, 17f)
val endScene = BezierScene(6f, 6f, 18f, 18f)

val curve = BezierCurve(
    start = startScene.left to startScene.centerY,
    end = endScene.centerX to endScene.centerY,
)
```

2. Use calculated values which are collected in `point` variable

```kotlin
val point = curve.calculate(progress)
```

## Developed By

 - Peter Gulko
 - ztrap.developer@gmail.com

## License

       Copyright 2024 zTrap

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.
