package countelementswithmaximumfrequency

// Time:  O(n)
// Space: O(n)

// freq table
class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        var mx = 0
        for (x in nums) {
            val c = (cnt[x] ?: 0) + 1
            cnt[x] = c
            mx = maxOf(mx, c)
        }
        var result = 0
        for (v in cnt.values) {
            if (v == mx) {
                result += v
            }
        }
        return result
    }
}
