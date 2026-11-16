package firstelementwithuniquefrequency

// Time:  O(n)
// Space: O(n)

class Solution {
    fun firstUniqueFreq(nums: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        val cnt2 = HashMap<Int, Int>()
        for (v in cnt.values) {
            cnt2[v] = (cnt2[v] ?: 0) + 1
        }
        for (x in nums) {
            if (cnt2[cnt[x]] == 1) {
                return x
            }
        }
        return -1
    }
}
