package countnumberswithnondecreasingdigits

// Time:  O(n^2), n = len(r)
// Space: O(n)

class Solution {
    fun countNumbers(l: String, r: String, b: Int): Int {
        fun decrease(digits: IntArray) {
            for (i in digits.lastIndex downTo 0) {
                if (digits[i] != 0) {
                    --digits[i]
                    break
                }
                digits[i] = 9
            }
        }

        fun divide(digits: IntArray, base: Int): Pair<IntArray, Int> {
            val result = ArrayList<Int>(digits.size)
            var remainder = 0
            for (d in digits) {
                val q = (remainder * 10 + d) / base
                remainder = (remainder * 10 + d) % base
                if (result.isNotEmpty() || q != 0) {
                    result.add(q)
                }
            }
            return Pair(result.toIntArray(), remainder)
        }

        fun toDigits(s: String): IntArray {
            val result = IntArray(s.length)
            for (i in s.indices) {
                result[i] = s[i] - '0'
            }
            return result
        }

        fun toBase(initialDigits: IntArray, base: Int): IntArray {
            var digits = initialDigits
            val result = ArrayList<Int>(digits.size)
            while (digits.isNotEmpty()) {
                val (q, remainder) = divide(digits, base)
                result.add(remainder)
                digits = q
            }
            result.reverse()
            return result.toIntArray()
        }

        fun count(digits: IntArray): Int {
            val digitsBase = toBase(digits, b)
            var result = 0
            var i = 0
            while (i < digitsBase.size) {
                if (i - 1 >= 0 && digitsBase[i - 1] > digitsBase[i]) {
                    break
                }
                val start = if (i - 1 >= 0) digitsBase[i - 1] else 0
                for (j in start until digitsBase[i]) {
                    result = addMod(result.toUInt(), nHr(b - 1 - j + 1, digitsBase.size - (i + 1)).toUInt()).toInt()
                }
                ++i
            }
            if (i == digitsBase.size) {
                result = addMod(result.toUInt(), 1u).toInt()
            }
            return result
        }

        val digitsL = toDigits(l)
        decrease(digitsL)
        val digitsR = toDigits(r)
        return subMod(count(digitsR).toUInt(), count(digitsL).toUInt()).toInt()
    }

    private fun nHr(n: Int, k: Int): Int {
        return nCr(n + k - 1, k)
    }

    private fun nCr(n: Int, k: Int): Int {
        while (inv.size <= n) {
            val size = inv.size
            fact.add(mulMod(fact.last().toUInt(), size.toUInt()).toInt())
            inv.add(mulMod(inv[(mod % size.toUInt()).toInt()].toUInt(), mod - mod / size.toUInt()).toInt())
            invFact.add(mulMod(invFact.last().toUInt(), inv.last().toUInt()).toInt())
        }
        return mulMod(mulMod(fact[n].toUInt(), invFact[n - k].toUInt()), invFact[k].toUInt()).toInt()
    }

    private fun addMod(aValue: UInt, bValue: UInt): UInt {
        var a = aValue % mod
        var b = bValue % mod
        if (mod - a <= b) {
            b -= mod
        }
        return a + b
    }

    private fun subMod(a: UInt, b: UInt): UInt {
        return addMod(a, (mod - b) % mod)
    }

    private fun mulMod(aValue: UInt, bValue: UInt): UInt {
        var a = aValue % mod
        var b = bValue % mod
        var result = 0u
        if (a < b) {
            val temp = a
            a = b
            b = temp
        }
        while (b > 0u) {
            if (b % 2u == 1u) {
                result = addMod(result, a)
            }
            a = addMod(a, a)
            b /= 2u
        }
        return result
    }

    private val mod = 1_000_000_007u
    private val fact = arrayListOf(1, 1)
    private val inv = arrayListOf(1, 1)
    private val invFact = arrayListOf(1, 1)
}
