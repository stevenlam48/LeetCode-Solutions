package maximumnumberofconsecutivevaluesyoucanmake

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun getMaximumConsecutive(coins: IntArray): Int {
        coins.sort()
        var result = 1
        for (c in coins) {
            if (c > result) {
                break
            }
            result += c
        }
        return result
    }
}
