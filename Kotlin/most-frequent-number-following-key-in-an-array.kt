package mostfrequentnumberfollowingkeyinanarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun mostFrequent(nums: IntArray, key: Int): Int {
        var result = 0
        val cnt = HashMap<Int, Int>()
        for (i in 0 until nums.size - 1) {
            if (nums[i] == key) {
                val next = nums[i + 1]
                cnt[next] = cnt.getOrDefault(next, 0) + 1
                if (cnt.getOrDefault(result, 0) < cnt.getValue(next)) {
                    result = next
                }
            }
        }
        return result
    }
}
