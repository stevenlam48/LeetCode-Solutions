package multiplytwopolynomials

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.round
import kotlin.math.sin

// Time:  O((n + m) * log(n + m))
// Space: O(n + m)

private class Complex(var re: Double, var im: Double) {
    operator fun plus(other: Complex) = Complex(re + other.re, im + other.im)

    operator fun minus(other: Complex) = Complex(re - other.re, im - other.im)

    operator fun times(other: Complex) =
        Complex(re * other.re - im * other.im, re * other.im + im * other.re)
}

private fun fft(a: Array<Complex>, invert: Boolean) {
    val n = a.size
    if (n <= 1) {
        return
    }

    var j = 0
    for (i in 1 until n) {
        var bit = n shr 1
        while (j and bit != 0) {
            j = j xor bit
            bit = bit shr 1
        }
        j = j xor bit
        if (i < j) {
            val tmp = a[i]
            a[i] = a[j]
            a[j] = tmp
        }
    }

    var len = 2
    while (len <= n) {
        val angle = 2 * PI / len * (if (invert) -1 else 1)
        val wlen = Complex(cos(angle), sin(angle))
        var i = 0
        while (i < n) {
            var w = Complex(1.0, 0.0)
            for (k in 0 until len / 2) {
                val u = a[i + k]
                val v = a[i + k + len / 2] * w
                a[i + k] = u + v
                a[i + k + len / 2] = u - v
                w = w * wlen
            }
            i += len
        }
        len = len shl 1
    }

    if (invert) {
        for (x in a) {
            x.re /= n
            x.im /= n
        }
    }
}

private fun conv(poly1: IntArray, poly2: IntArray): LongArray {
    val n = poly1.size
    val m = poly2.size
    var sz = 1
    val tot = n + m - 1
    while (sz < tot) {
        sz = sz shl 1
    }
    val a = Array(sz) { Complex(0.0, 0.0) }
    val b = Array(sz) { Complex(0.0, 0.0) }
    for (i in 0 until n) {
        a[i] = Complex(poly1[i].toDouble(), 0.0)
    }
    for (i in 0 until m) {
        b[i] = Complex(poly2[i].toDouble(), 0.0)
    }
    fft(a, false)
    fft(b, false)
    for (i in 0 until sz) {
        a[i] = a[i] * b[i]
    }
    fft(a, true)
    return LongArray(tot) { round(a[it].re).toLong() }
}

class Solution {
    fun multiply(poly1: IntArray, poly2: IntArray): LongArray {
        return conv(poly1, poly2)
    }
}
