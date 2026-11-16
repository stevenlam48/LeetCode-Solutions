package lexicographicallymaximummexarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumMEX(nums: IntArray): IntArray {
        var ver = -1
        val lookup = IntArray(nums.size) { ver }
        val suffix = IntArray(nums.size)
        ++ver
        var mex = 0
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] < lookup.size) {
                lookup[nums[i]] = ver
            }
            while (mex < lookup.size && lookup[mex] == ver) {
                ++mex
            }
            suffix[i] = mex
        }
        val result = ArrayList<Int>()
        ++ver
        mex = 0
        var j = 0
        for (i in nums.indices) {
            if (suffix[j] == 0) {
                break
            }
            if (nums[i] < lookup.size) {
                lookup[nums[i]] = ver
            }
            while (mex < lookup.size && lookup[mex] == ver) {
                ++mex
            }
            if (mex != suffix[j]) {
                continue
            }
            result.add(mex)
            ++ver
            mex = 0
            j = i + 1
        }
        repeat(nums.size - j) {
            result.add(0)
        }
        return result.toIntArray()
    }
}
