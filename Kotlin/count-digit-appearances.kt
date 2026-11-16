package countdigitappearances

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun countDigitOccurrences(nums: IntArray, digit: Int): Int {
        fun count(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                if (x % 10 == digit) {
                    ++result
                }
                x /= 10
            }
            return result
        }

        var result = 0
        for (x in nums) {
            result += count(x)
        }
        return result
    }
}
