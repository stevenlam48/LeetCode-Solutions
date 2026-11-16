package findthreeconsecutiveintegersthatsumtoagivennumber

// Time:  O(1)
// Space: O(1)

// math
class Solution {
    fun sumOfThree(num: Long): List<Long> {
        return if (num % 3 == 0L) {
            listOf(num / 3 - 1, num / 3, num / 3 + 1)
        } else {
            listOf()
        }
    }
}
