package countpairsthatformacompletedayi

// Time:  O(n + 24)
// Space: O(24)

// freq table
class Solution {
    fun countCompleteDayPairs(hours: IntArray): Int {
        var result = 0
        val cnt = IntArray(24)
        for (x in hours) {
            result += cnt[((-x % 24) + 24) % 24]
            ++cnt[x % 24]
        }
        return result
    }
}
