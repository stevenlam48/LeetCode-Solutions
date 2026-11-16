package findoriginalarrayfromdoubledarray

// Time:  O(n + klogk), k is the distinct number of changed
// Space: O(k)

class Solution {
    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) {
            return intArrayOf()
        }
        val cnts = HashMap<Int, Int>()
        for (x in changed) {
            cnts[x] = (cnts[x] ?: 0) + 1
        }
        val nums = cnts.keys.sorted()
        val result = mutableListOf<Int>()
        for (x in nums) {
            cnts[2 * x] = cnts[2 * x] ?: 0
            if (cnts[x]!! > cnts[2 * x]!!) {
                return intArrayOf()
            }
            var i = 0
            while (i < cnts[x]!!) {
                result.add(x)
                cnts[2 * x] = cnts[2 * x]!! - 1
                ++i
            }
        }
        return result.toIntArray()
    }
}
