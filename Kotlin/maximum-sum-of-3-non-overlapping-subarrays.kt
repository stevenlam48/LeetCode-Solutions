package maximumsumof3nonoverlappingsubarrays
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val accu = IntArray(n + 1)
        for (i in nums.indices) {
            accu[i + 1] = accu[i] + nums[i]
        }

        val leftPos = IntArray(n)
        var total = accu[k] - accu[0]
        for (i in k until n) {
            if (accu[i + 1] - accu[i + 1 - k] > total) {
                leftPos[i] = i + 1 - k
                total = accu[i + 1] - accu[i + 1 - k]
            } else {
                leftPos[i] = leftPos[i - 1]
            }
        }

        val rightPos = IntArray(n) { n - k }
        total = accu[n] - accu[n - k]
        for (i in n - k - 1 downTo 0) {
            if (accu[i + k] - accu[i] > total) {
                rightPos[i] = i
                total = accu[i + k] - accu[i]
            } else {
                rightPos[i] = rightPos[i + 1]
            }
        }

        val result = IntArray(3)
        var maxSum = 0
        for (i in k..n - 2 * k) {
            val left = leftPos[i - 1]
            val right = rightPos[i + k]
            total = (accu[i + k] - accu[i]) +
                (accu[left + k] - accu[left]) +
                (accu[right + k] - accu[right])
            if (total > maxSum) {
                maxSum = total
                result[0] = left
                result[1] = i
                result[2] = right
            }
        }
        return result
    }
}
