package equalrationalnumbers
// Time:  O(1)
// Space: O(1)

import kotlin.math.abs

class Fraction {
    private var numerator: Long = 0
    private var denominator: Long = 1
    private var integer: Long = 0

    constructor() : this(0L, 1L)

    constructor(n: Long) : this(n, 1L)

    constructor(n: Long, d: Long) {
        numerator = n
        denominator = d
        reduce()
    }

    fun setNum(value: Long) {
        numerator = value
    }

    fun setDen(value: Long) {
        denominator = value
    }

    fun setInt(value: Long) {
        integer = value
    }

    fun getNum(): Long = numerator

    fun getDen(): Long = denominator

    fun getInt(): Long = integer

    fun reduce() {
        val gcd = calculateGcd(numerator, denominator)
        numerator /= gcd
        denominator /= gcd
        integer += numerator / denominator
        numerator %= denominator
    }

    fun calculateGcd(a: Long, b: Long): Long {
        var x = abs(a)
        var y = abs(b)
        while (y != 0L) {
            val tmp = y
            y = x % y
            x = tmp
        }
        return x
    }

    operator fun plusAssign(rhs: Fraction) {
        setNum(getNum() * rhs.getDen() + getDen() * rhs.getNum())
        setDen(getDen() * rhs.getDen())
        setInt(getInt() + rhs.getInt())
        reduce()
    }

    override fun equals(other: Any?): Boolean {
        return other is Fraction &&
            numerator == other.numerator &&
            denominator == other.denominator &&
            integer == other.integer
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        result = 31 * result + integer.hashCode()
        return result
    }

    override fun toString(): String = "$integer.($numerator/$denominator)"
}

class Solution {
    fun isRationalEqual(S: String, T: String): Boolean {
        return frac(S) == frac(T)
    }

    private fun frac(S: String): Fraction {
        var i = S.indexOf('.')
        if (i == -1) {
            return Fraction(S.toLong())
        }

        val result = Fraction(S.substring(0, i).toLong(), 1)
        val nonIntPart = S.substring(i + 1)
        i = nonIntPart.indexOf('(')
        if (i == -1) {
            if (nonIntPart.isNotEmpty()) {
                result += Fraction(
                    nonIntPart.toLong(),
                    Math.pow(10.0, nonIntPart.length.toDouble()).toLong()
                )
            }
            return result
        }

        if (i > 0) {
            result += Fraction(
                nonIntPart.substring(0, i).toLong(),
                Math.pow(10.0, i.toDouble()).toLong()
            )
        }
        val repeatPart = nonIntPart.substring(i + 1, nonIntPart.length - 1)
        result += Fraction(
            repeatPart.toLong(),
            Math.pow(10.0, i.toDouble()).toLong() *
                (Math.pow(10.0, repeatPart.length.toDouble()).toLong() - 1)
        )
        return result
    }
}
