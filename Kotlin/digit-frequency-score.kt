package digitfrequencyscore

// Time:  O(logn)
// Space: O(1)

// freq table
class Solution {
    fun digitFrequencyScore(n0: Int): Int {
        var n = n0
        val cnt = IntArray(10)
        while (n != 0) {
            ++cnt[n % 10]
            n /= 10
        }
        var result = 0
        for (i in cnt.indices) {
            result += i * cnt[i]
        }
        return result
    }
}
