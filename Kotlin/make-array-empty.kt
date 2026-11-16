package makearrayempty

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun countOperationsToEmptyArray(nums: IntArray): Long {
        val idxs = Array(nums.size) { it }
        idxs.sortWith(Comparator { a, b -> nums[a].compareTo(nums[b]) })
        var result = idxs.size.toLong()
        for (i in 0 until idxs.size - 1) {
            if (idxs[i] > idxs[i + 1]) {
                result += idxs.size - (i + 1)
            }
        }
        return result
    }
}
