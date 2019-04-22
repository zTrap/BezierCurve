package ru.ztrap.beziercurve

/**
 * @author pa.gulko zTrap (16.04.2019)
 *
 * Container for point values
 */
data class Point(var x: Float, var y: Float) {

    /** Empty constructor for creating point on starts of axis */
    constructor() : this(0f, 0f)
}