package numberofdaysinamonth

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numberOfDays(Y: Int, M: Int): Int {
        val leap = if ((Y % 4 == 0 && Y % 100 != 0) || Y % 400 == 0) 1 else 0
        return if (M == 2) 28 + leap else 31 - (M - 1) % 7 % 2
    }
}
