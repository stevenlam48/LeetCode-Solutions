package findalllonelynumbersinthearray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findLonely(nums: IntArray): List<Int> {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        val result = mutableListOf<Int>()
        for (x in nums) {
            if (cnt[x] == 1 && !cnt.containsKey(x - 1) && !cnt.containsKey(x + 1)) {
                result.add(x)
            }
        }
        return result
    }
}
