package harshadnumber

// Time:  O(logx)
// Space: O(1)
class Solution {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        var result = 0
        var y = x
        while (y != 0) {
            result += y % 10
            y /= 10
        }
        return if (x % result == 0) result else -1
    }
}
