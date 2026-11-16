package beautifularrangement

// Time:  O(n!)
// Space: O(n)

class Solution {
    fun countArrangement(N: Int): Int {
        val arrangement = IntArray(N) { it + 1 }
        return countArrangementHelper(N, arrangement)
    }

    private fun countArrangementHelper(n: Int, arrangement: IntArray): Int {
        if (n <= 0) {
            return 1
        }
        var count = 0
        for (i in 0 until n) {
            if (arrangement[i] % n == 0 || n % arrangement[i] == 0) {
                val temp = arrangement[i]
                arrangement[i] = arrangement[n - 1]
                arrangement[n - 1] = temp
                count += countArrangementHelper(n - 1, arrangement)
                val restored = arrangement[i]
                arrangement[i] = arrangement[n - 1]
                arrangement[n - 1] = restored
            }
        }
        return count
    }
}
