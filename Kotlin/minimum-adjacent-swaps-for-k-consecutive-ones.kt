package minimumadjacentswapsforkconsecutiveones

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minMoves(nums: IntArray, k: Int): Int {
        val idxs = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] != 0) {
                idxs.add(i)
            }
        }
        val prefix = LongArray(idxs.size + 1)
        for (i in idxs.indices) {
            prefix[i + 1] = prefix[i] + idxs[i]
        }
        fun score(i: Int, j: Int): Long = prefix[j + 1] - prefix[i]
        var result = Long.MAX_VALUE
        for (i in 0..idxs.size - k) {
            result = minOf(result, -score(i, i + k / 2 - 1) + score(i + (k + 1) / 2, i + k - 1))
        }
        result -= (k / 2).toLong() * ((k + 1) / 2)
        return result.toInt()
    }
}
