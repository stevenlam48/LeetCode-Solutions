package librarylatefeecalculator

// Time:  O(n)
// Space: O(1)

class Solution {
    fun lateFee(daysLate: IntArray): Int {
        var total = 0
        for (x in daysLate) {
            total += if (x == 1) x else if (x >= 6) 3 * x else 2 * x
        }
        return total
    }
}
