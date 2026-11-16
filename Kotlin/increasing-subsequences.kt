package increasingsubsequences

// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val seq = ArrayList<Int>()
        findSubsequencesHelper(nums, 0, seq, result)
        return result
    }

    fun findSubsequencesHelper(
        nums: IntArray,
        i0: Int,
        seq: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (seq.size >= 2) {
            result.add(ArrayList(seq))
        }
        val lookup = HashSet<Int>()
        var i = i0
        while (i < nums.size) {
            if ((seq.isEmpty() || nums[i] >= seq.last()) && lookup.add(nums[i])) {
                seq.add(nums[i])
                findSubsequencesHelper(nums, i + 1, seq, result)
                seq.removeAt(seq.size - 1)
            }
            ++i
        }
    }
}
