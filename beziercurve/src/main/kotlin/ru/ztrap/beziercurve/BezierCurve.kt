package ru.ztrap.beziercurve

import kotlin.math.pow

private val APPLICABLE_VALUES = 0f..1f

/**
 * @author pa.gulko zTrap (16.04.2019)
 *
 * Primary constructor. Use this if you want to construct some Bezier curve. Use this format for providing
 * points `[x, y]`
 */
data class BezierCurve(
    val start: Pair<Float, Float>,
    val end: Pair<Float, Float>,
    val controls: List<Pair<Float, Float>>
) {
    constructor(
        start: Pair<Float, Float>,
        end: Pair<Float, Float>,
        vararg controls: Pair<Float, Float>
    ) : this(
        start,
        end,
        listOf(*controls)
    )

    @Deprecated("Use another constructor", ReplaceWith("BezierCurve(start, end, control1, control2)"))
    constructor(
        control1: Pair<Float, Float>,
        control2: Pair<Float, Float>,
        start: Pair<Float, Float>,
        end: Pair<Float, Float>
    ) : this(
        start,
        end,
        listOf(control1, control2)
    )

    /**
     * Use this constructor if you want to construct some quad Bezier curve. Use this format for providing
     * points `[x, y]`
     */
    @Deprecated("Use another constructor", ReplaceWith("BezierCurve(start, end, control)"))
    constructor(
        control: Pair<Float, Float>,
        start: Pair<Float, Float>,
        end: Pair<Float, Float>
    ) : this(
        start,
        end,
        listOf(control)
    )

    /**
     * Use this constructor if you want to construct some linear Bezier curve. Use this format for providing
     * points `[x, y]`
     */
    @Deprecated("Use another constructor", ReplaceWith("BezierCurve(start, end, emptyList())"))
    constructor(
        start: Pair<Float, Float>,
        end: Pair<Float, Float>
    ) : this(
        start,
        end,
        emptyList()
    )

    private val internalPoint = Point()

    /** Point container. Contains `x` and `y` values for last calculation */
    val point: Point
        get() = internalPoint.copy()

    /** Calculates linear Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    fun calculate(t: Float): Point {
        require(t in APPLICABLE_VALUES) { "Wrong t value = $t. Applicable values in [0,1]" }

        return internalPoint.apply {
            when(controls.size) {
                0 -> {
                    x = (1 - t) * start.x + t * end.x
                    y = (1 - t) * start.y + t * end.y
                }
                else -> {
                    x = 0f
                    y = 0f

                    controls.forEachIndexed { index, control ->
                        val polynomial = bernstein(t, controls.size - 1, index + 1)
                        x += polynomial * control.x
                        y += polynomial * control.y
                    }
                }
            }
        }
    }

    /** Calculates linear Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    @Deprecated("Use common calculate function", ReplaceWith("calculate(t)"))
    fun linearFor(t: Float): Point = calculate(t)

    /** Calculates quadratic Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    @Deprecated("Use common calculate function", ReplaceWith("calculate(t)"))
    fun quadFor(t: Float): Point = calculate(t)

    /** Calculates cubic Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    @Deprecated("Use common calculate function", ReplaceWith("calculate(t)"))
    fun cubicFor(t: Float): Point = calculate(t)

    private fun fact(n: Int): Int = (1..n).reduce { acc, i -> acc * i }

    private fun bernstein(t: Float, n: Int, i: Int): Float {
        return fact(n) / (fact(i) * fact(n - i)) * (1 - t).pow(n - i) * t.pow(i)
    }
}