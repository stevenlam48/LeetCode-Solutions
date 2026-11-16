package maximumfrequencyaftersubarrayoperation

// Time:  O(n)
// Space: O(n)

// freq table, dp
class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = maxOf(cnt[x] ?: 0, cnt[k] ?: 0) + 1
            result = maxOf(result + if (x == k) 1 else 0, cnt[x]!!)
        }
        return result
    }
}
