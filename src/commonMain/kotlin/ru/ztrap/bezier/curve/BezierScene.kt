package ru.ztrap.bezier.curve

public data class BezierScene(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {

    /** Returns true if the rectangle is empty ([left] >= [right] or [top] >= [bottom]) */
    val isEmpty: Boolean
        get() = left >= right || top >= bottom

    /**
     * @return the rectangle's width. This does not check for a valid rectangle
     * (i.e. [left] <= [right]) so the result may be negative.
     */
    val width: Float
        get() = right - left

    /**
     * @return the rectangle's height. This does not check for a valid rectangle
     * (i.e. [top] <= [bottom]) so the result may be negative.
     */
    val height: Float
        get() = bottom - top

    /**
     * @return the horizontal center of the rectangle. This does not check for
     * a valid rectangle (i.e. [left] <= [right])
     */
    val centerX: Float
        get() = (left + right) * 0.5f

    /**
     * @return the vertical center of the rectangle. This does not check for
     * a valid rectangle (i.e. [top] <= [bottom])
     */
    val centerY: Float
        get() = (top + bottom) * 0.5f
}