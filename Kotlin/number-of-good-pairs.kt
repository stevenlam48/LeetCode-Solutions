package numberofgoodpairs

// Time:  O(n)
// Space: O(n)

class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        val counter = HashMap<Int, Int>()
        for (x in nums) {
            counter[x] = (counter[x] ?: 0) + 1
        }
        var result = 0
        for (c in counter.values) {
            result += c * (c - 1) / 2
        }
        return result
    }
}
