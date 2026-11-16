package brokencalculator

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun brokenCalc(X: Int, Y: Int): Int {
        var x = X
        var y = Y
        var result = 0
        while (x < y) {
            if (y % 2 == 1) {
                ++y
            } else {
                y /= 2
            }
            ++result
        }
        return result + x - y
    }
}
