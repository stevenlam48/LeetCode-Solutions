package permutationsequence

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun getPermutation(n: Int, k: Int): String {
        val nums = mutableListOf<Int>()
        var total = 1
        for (i in 1..n) {
            nums.add(i)
            total *= i
        }

        var group = total
        val permutation = StringBuilder()
        var remaining = n
        var kk = k
        while (remaining > 0) {
            group /= remaining
            val idx = (kk - 1) / group
            permutation.append(nums[idx])
            nums.removeAt(idx)
            kk = (kk - 1) % group + 1
            --remaining
        }

        return permutation.toString()
    }
}
