package countvalueswithequallyspacedoccurrencesii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countSpecialIntegers(nums: IntArray): Int {
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in nums.indices) {
            lookup.getOrPut(nums[i]) { mutableListOf() }.add(i)
        }
        var result = 0
        for (idxs in lookup.values) {
            if (idxs.size < 3) {
                continue
            }
            var ok = true
            val diff = idxs[idxs.size - 1] - idxs[idxs.size - 2]
            var i = 0
            while (i + 2 < idxs.size) {
                if (idxs[i + 1] - idxs[i] != diff) {
                    ok = false
                    break
                }
                ++i
            }
            if (ok) {
                ++result
            }
        }
        return result
    }
}
