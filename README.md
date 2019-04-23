# Bezier curves creator
The simple helper for build [Bezier curves](https://en.wikipedia.org/wiki/B%C3%A9zier_curve). Fully compatible with projects written in java/kotlin

[ ![Download](https://api.bintray.com/packages/ztrap/maven/beziercurve/images/download.svg) ](https://bintray.com/ztrap/maven/beziercurve/_latestVersion)

## Install

```gradle
implementation 'ru.ztrap:beziercurve:1.0.1'
```

## Usage

1. Create some Bezier curve instance

```kotlin
// just a helpers. You steel can provide a direct values in BezierCurve constructor
val startScene = BezierScene(3f, 7f, 21f, 17f)
val endScene = BezierScene(6f, 6f, 18f, 18f)

val curve = BezierCurve(
    startScene.left to startScene.centerY,
    endScene.centerX to endScene.centerY
)
```

2. Choose an calculation method and provide the `t` parameter

```kotlin
curve.linearFor(progress)
```

3. Use calculation values are collected in `point` variable

```kotlin
val point = curve.linearFor(progress)
// or
curve.linearFor(progress)
val point = curve.point
```

## Developed By

 - Peter Gulko
 - contacts@ztrap.ru
 - [paypal.me/zTrap](https://www.paypal.me/zTrap)

## License

       Copyright 2019 zTrap

       Licensed under the Apache License, Version 2.0 (the "License");
       you may not use this file except in compliance with the License.
       You may obtain a copy of the License at

           http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing, software
       distributed under the License is distributed on an "AS IS" BASIS,
       WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
       See the License for the specific language governing permissions and
       limitations under the License.