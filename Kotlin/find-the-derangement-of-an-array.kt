package findthederangementofanarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun findDerangement(n: Int): Int {
        var mul = 1L
        var sum = 0L
        for (i in n downTo 0) {
            sum = (sum + M + (if (i % 2 == 0) 1 else -1) * mul) % M
            mul = (mul * i) % M
        }
        return sum.toInt()
    }

    companion object {
        private const val M = 1_000_000_007
    }
}
