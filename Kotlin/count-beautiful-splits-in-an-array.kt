package countbeautifulsplitsinanarray

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun beautifulSplits(nums: IntArray): Int {
        fun zFunction(s: IntArray, left: Int, right: Int): IntArray {
            val z = IntArray(right - left + 1)
            var l = 0
            var r = 0
            for (i in 1 until z.size) {
                if (i <= r) {
                    z[i] = minOf(r - i + 1, z[i - l])
                }
                while (i + z[i] < z.size && s[left + z[i]] == s[left + i + z[i]]) {
                    ++z[i]
                }
                if (i + z[i] - 1 > r) {
                    l = i
                    r = i + z[i] - 1
                }
            }
            return z
        }

        var result = 0
        val z0 = zFunction(nums, 0, nums.size - 1)
        for (i in 1 until nums.size - 1) {
            val zi = zFunction(nums, i, nums.size - 1)
            for (j in i + 1 until nums.size) {
                if ((z0[i] >= i && j - i >= i) || zi[j - i] >= j - i) {
                    ++result
                }
            }
        }
        return result
    }
}
