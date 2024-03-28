package ru.ztrap.bezier.curve

import kotlin.jvm.JvmInline

/**
 * Constructs a [Point] from [x] and [y] position values
 */
public fun Point(x: Float, y: Float): Point = Point(packFloats(x, y))

/**
 * A two-dimensional point using [Float] for units
 */
@JvmInline
public value class Point internal constructor(@PublishedApi internal val packedValue: Long) {

    /**
     * The horizontal aspect of the point
     */
    public val x: Float
        get() = unpackFloat1(packedValue)

    /**
     * The vertical aspect of the point
     */
    public val y: Float
        get() = unpackFloat2(packedValue)

    /**
     * Returns a copy of this [Point] instance optionally overriding the
     * x or y parameter
     */
    public fun copy(x: Float = this.x, y: Float = this.y): Point = Point(x, y)

    override fun toString(): String = if (isSpecified) {
        "($x, $y)"
    } else {
        "Point.Unspecified"
    }

    public companion object {
        /**
         * A [Point] with 0 [x] and 0 [y] values.
         */
        public val Zero: Point = Point(0f, 0f)

        /**
         * Represents an offset whose [x] and [y] are unspecified. This is usually a replacement for
         * `null` when a primitive value is desired.
         * Access to [x] or [y] on an unspecified offset is not allowed.
         */
        public val Unspecified: Point = Point(Float.NaN, Float.NaN)
    }
}

public inline val Point.isSpecified: Boolean
    get() = packedValue != Point.Unspecified.packedValue

public inline val Point.isUnspecified: Boolean
    get() = packedValue == Point.Unspecified.packedValue