package nextgreaterelementiii
// Time:  O(logn) = O(1)
// Space: O(logn) = O(1)

class Solution {
    fun nextGreaterElement(n: Int): Int {
        val digits = n.toString().toCharArray()
        nextPermutation(digits)
        val result = String(digits).toLong()
        return if (result > Int.MAX_VALUE || result <= n) -1 else result.toInt()
    }

    private fun nextPermutation(digits: CharArray) {
        var pivot = digits.size - 2
        while (pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {
            --pivot
        }
        if (pivot >= 0) {
            var change = digits.size - 1
            while (digits[change] <= digits[pivot]) {
                --change
            }
            val temp = digits[pivot]
            digits[pivot] = digits[change]
            digits[change] = temp
        }
        var left = pivot + 1
        var right = digits.lastIndex
        while (left < right) {
            val temp = digits[left]
            digits[left] = digits[right]
            digits[right] = temp
            ++left
            --right
        }
    }
}
