package ru.ztrap.bezier.curve

import kotlin.math.pow

private val APPLICABLE_VALUES = 0f..1f

public data class BezierCurve(
    val start: Point,
    val end: Point,
    val controls: List<Point> = emptyList(),
) {

    /**
     * @param start point in format `[x, y]`
     * @param end point in format `[x, y]`
     * @param controls points in format `[x, y]`
     */
    public constructor(
        start: Pair<Float, Float>,
        end: Pair<Float, Float>,
        controls: List<Pair<Float, Float>> = emptyList(),
    ) : this(
        start = Point(start.x, start.y),
        end = Point(end.x, end.y),
        controls = controls.map { Point(it.x, it.y) },
    )

    /** Calculates linear Bezier curve for presented [t]. Acceptable value for [t] in `[0,1]` */
    public fun calculate(t: Float): Point {
        require(t in APPLICABLE_VALUES) { "Wrong t value = $t. Applicable values in [0,1]" }
        return when (controls.size) {
            0 -> Point(
                x = (1 - t) * start.x + t * end.x,
                y = (1 - t) * start.y + t * end.y,
            )

            else -> {
                var x = 0f
                var y = 0f

                controls.forEachIndexed { index, control ->
                    val polynomial = bernstein(t, controls.size - 1, index + 1)
                    x += polynomial * control.x
                    y += polynomial * control.y
                }

                Point(x = x, y = y)
            }
        }
    }

    /** @return factorial of [n] */
    private fun fact(n: Int): Int = (1..n).reduce { acc, i -> acc * i }

    /**
     * @return Bernstein polynomial
     * @see <a href="https://en.wikipedia.org/wiki/Bernstein_polynomial">Wikipedia</a>
     */
    private fun bernstein(t: Float, n: Int, i: Int): Float {
        return fact(n) / (fact(i) * fact(n - i)) * (1 - t).pow(n - i) * t.pow(i)
    }
}