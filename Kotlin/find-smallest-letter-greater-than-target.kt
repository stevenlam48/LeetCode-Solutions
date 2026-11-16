package findsmallestlettergreaterthantarget

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var left = 0
        var right = letters.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (letters[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return if (left != letters.size) letters[left] else letters[0]
    }
}
