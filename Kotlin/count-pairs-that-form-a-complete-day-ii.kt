package countpairsthatformacompletedayii

// Time:  O(n + 24)
// Space: O(24)

// freq table
class Solution {
    fun countCompleteDayPairs(hours: IntArray): Long {
        var result = 0L
        val cnt = IntArray(24)
        for (x in hours) {
            result += cnt[((-x % 24) + 24) % 24]
            ++cnt[x % 24]
        }
        return result
    }
}
