@file:Suppress("NOTHING_TO_INLINE")

package ru.ztrap.beziercurve

import kotlin.math.pow

internal inline val Pair<Float, Float>.x: Float
    get() = first

internal inline val Pair<Float, Float>.y: Float
    get() = second

internal inline fun Float.quad() = pow(2)

internal inline fun Float.cube() = pow(3)