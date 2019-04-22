package ru.ztrap.beziercurve

/**
 * @author pa.gulko zTrap (16.04.2019)
 *
 * Primary constructor. Use this if you want to construct some cubic Bezier curve. Use this format for providing
 * points `[x, y]`
 */
data class BezierCurve(
    private val control1: Pair<Float, Float>,
    private val control2: Pair<Float, Float>,
    private val start: Pair<Float, Float>,
    private val end: Pair<Float, Float>
) {

    /**
     * Use this constructor if you want to construct some quad Bezier curve. Use this format for providing
     * points `[x, y]`
     */
    constructor(
        control: Pair<Float, Float>,
        start: Pair<Float, Float>,
        end: Pair<Float, Float>
    ) : this(
        control,
        control,
        start,
        end
    )

    /**
     * Use this constructor if you want to construct some linear Bezier curve. Use this format for providing
     * points `[x, y]`
     */
    constructor(
        start: Pair<Float, Float>,
        end: Pair<Float, Float>
    ) : this(
        ((end.x - start.x) / 2f) to ((end.y - start.y) / 2f),
        start,
        end
    )

    /** Point container. Contains `x` and `y` values for last calculation */
    val point = Point()

    /** Calculates linear Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    fun linearFor(t: Float): Point {
        checkRange(t)

        return point.apply {
            x = (1 - t) * start.x + t * end.x
            y = (1 - t) * start.y + t * end.y
        }
    }

    /** Calculates quadratic Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    fun quadFor(t: Float): Point {
        checkRange(t)

        return point.apply {
            x = (1 - t).quad() * start.x + 2 * t * (1 - t) * control1.x + t.quad() * end.x
            y = (1 - t).quad() * start.y + 2 * t * (1 - t) * control1.y + t.quad() * end.y
        }
    }

    /** Calculates cubic Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    fun cubicFor(t: Float): Point {
        checkRange(t)

        return point.apply {
            // @formatter:off
            x = (1 - t).cube() * start.x + 3 * t * (1 - t).quad() * control1.x + 3 * t.quad() * (1 - t) * control2.x + t.cube() * end.x
            y = (1 - t).cube() * start.y + 3 * t * (1 - t).quad() * control1.y + 3 * t.quad() * (1 - t) * control2.y + t.cube() * end.y
            // @formatter:on
        }
    }

    private fun checkRange(t: Float) {
        if (t !in 0f..1f) {
            throw IllegalArgumentException("Wrong t value = $t. Applicable values in [0,1]")
        }
    }
}