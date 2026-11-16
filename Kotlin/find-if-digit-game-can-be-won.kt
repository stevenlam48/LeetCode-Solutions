package findifdigitgamecanbewon

// Time:  O(n)
// Space: O(1)

// brute force, game theory
class Solution {
    fun canAliceWin(nums: IntArray): Boolean {
        var total1 = 0
        var total2 = 0
        for (x in nums) {
            if (x < 10) {
                total1 += x
            } else {
                total2 += x
            }
        }
        return total1 != total2
    }
}
