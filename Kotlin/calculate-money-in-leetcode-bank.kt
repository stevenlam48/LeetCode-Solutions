package calculatemoneyinleetcodebank

// Time:  O(1)
// Space: O(1)

class Solution {
    fun totalMoney(n: Int): Int {
        fun arithmeticSequenceSum(a: Int, d: Int, count: Int): Int {
            return (2 * a + (count - 1) * d) * count / 2
        }

        val cost = 1
        val day = 7
        val firstWeekCost = arithmeticSequenceSum(cost, cost, day)
        val week = n / day
        val remainDay = n % day
        return arithmeticSequenceSum(firstWeekCost, cost * day, week) +
            arithmeticSequenceSum(cost * (week + 1), cost, remainDay)
    }
}
