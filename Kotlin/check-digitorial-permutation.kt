package checkdigitorialpermutation

// Time:  O(logn + 10)
// Space: O(10)

private val FACT = mutableListOf(1, 1)

private fun factorial(n: Int): Int {
    while (FACT.size <= n) {
        FACT.add(FACT.last() * FACT.size)
    }
    return FACT[n]
}

class Solution {
    fun isDigitorialPermutation(n: Int): Boolean {
        fun digitCounts(input: Int): IntArray {
            var x = input
            val count = IntArray(10)
            while (x != 0) {
                ++count[x % 10]
                x /= 10
            }
            return count
        }

        var total = 0
        var x = n
        while (x != 0) {
            total += factorial(x % 10)
            x /= 10
        }
        return digitCounts(total).contentEquals(digitCounts(n))
    }
}
