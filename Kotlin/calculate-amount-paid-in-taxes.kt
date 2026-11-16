package calculateamountpaidintaxes

// Time:  O(n)
// Space: O(1)

class Solution {
    fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
        var result = 0.0
        var prev = 0
        for (bracket in brackets) {
            result += maxOf((minOf(bracket[0], income) - prev) * bracket[1] / 100.0, 0.0)
            prev = bracket[0]
        }
        return result
    }
}
