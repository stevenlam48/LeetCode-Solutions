package nextpalindromeusingsamedigits
// Time:  O(n)
// Space: O(1)

class Solution {
    fun nextPalindrome(num: String): String {
        val digits = num.toCharArray()
        if (!nextPermutation(digits, digits.size / 2)) {
            return ""
        }
        for (i in 0 until digits.size / 2) {
            digits[digits.lastIndex - i] = digits[i]
        }
        return String(digits)
    }

    private fun nextPermutation(digits: CharArray, end: Int): Boolean {
        var pivot = end - 2
        while (pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {
            --pivot
        }
        if (pivot >= 0) {
            var change = end - 1
            while (digits[change] <= digits[pivot]) {
                --change
            }
            val temp = digits[pivot]
            digits[pivot] = digits[change]
            digits[change] = temp
        }
        var left = pivot + 1
        var right = end - 1
        while (left < right) {
            val temp = digits[left]
            digits[left] = digits[right]
            digits[right] = temp
            ++left
            --right
        }
        return pivot >= 0
    }
}
