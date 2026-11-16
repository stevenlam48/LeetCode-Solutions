package makelexicographicallysmallestarraybyswappingelements

// Time:  O(nlogn)
// Space: O(n)

// sort
class Solution {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        val idxs = nums.indices.sortedBy { nums[it] }
        val groups = ArrayList<ArrayList<Int>>()
        for (i in idxs.indices) {
            if (i - 1 < 0 || nums[idxs[i]] - nums[idxs[i - 1]] > limit) {
                groups.add(ArrayList())
            }
            groups.last().add(idxs[i])
        }
        val result = IntArray(nums.size) { -1 }
        for (g in groups) {
            val sortedG = g.sorted()
            for (i in g.indices) {
                result[sortedG[i]] = nums[g[i]]
            }
        }
        return result
    }
}
