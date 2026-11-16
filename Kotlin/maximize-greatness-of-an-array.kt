package maximizegreatnessofanarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximizeGreatness(nums: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        return nums.size - (cnt.values.maxOrNull() ?: 0)
    }
}
