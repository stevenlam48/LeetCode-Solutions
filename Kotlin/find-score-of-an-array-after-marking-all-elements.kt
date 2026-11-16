package findscoreofanarrayaftermarkingallelements

// Time:  O(nlogn)
// Space: O(n)

// simulation, sort, hash table
class Solution {
    fun findScore(nums: IntArray): Long {
        val idxs = (nums.indices).sortedWith(compareBy({ nums[it] }, { it }))
        val lookup = BooleanArray(nums.size)
        var result = 0L
        for (i in idxs) {
            if (lookup[i]) {
                continue
            }
            lookup[i] = true
            if (i - 1 >= 0) {
                lookup[i - 1] = true
            }
            if (i + 1 < lookup.size) {
                lookup[i + 1] = true
            }
            result += nums[i]
        }
        return result
    }
}
