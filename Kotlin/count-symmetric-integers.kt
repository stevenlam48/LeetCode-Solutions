package countsymmetricintegers
// Time:  O(rlogr)
// Space: O(r)

private const val MAX_R = 10000
private val LOOKUP = IntArray(MAX_R) { -1 }

class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        fun check(x: Int): Int {
            if (LOOKUP[x - 1] == -1) {
                val digits = x.toString()
                if (digits.length % 2 != 0) {
                    LOOKUP[x - 1] = 0
                } else {
                    var total1 = 0
                    for (i in 0 until digits.length / 2) {
                        total1 += digits[i] - '0'
                    }
                    var total2 = 0
                    for (i in digits.length / 2 until digits.length) {
                        total2 += digits[i] - '0'
                    }
                    LOOKUP[x - 1] = if (total1 == total2) 1 else 0
                }
            }
            return LOOKUP[x - 1]
        }

        var result = 0
        for (i in low..high) {
            result += check(i)
        }
        return result
    }
}
