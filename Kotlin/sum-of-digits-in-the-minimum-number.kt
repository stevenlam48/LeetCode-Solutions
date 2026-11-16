package sumofdigitsintheminimumnumber

// Time:  O(n * l), l is the max length of numbers
// Space: O(l)
class Solution {
    fun sumOfDigits(A: IntArray): Int {
        var minNum = A.minOrNull() ?: 0
        var total = 0
        while (minNum != 0) {
            total += minNum % 10
            minNum /= 10
        }
        return if (total % 2 == 0) 1 else 0
    }
}
