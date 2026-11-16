package minimumnumberofcoinstobeadded

// Time:  O(nlogn + logt)
// Space: O(1)

class Solution {
    fun minimumAddedCoins(coins: IntArray, target: Int): Int {
        coins.sort()
        var result = 0
        var reachable = 0
        for (x in coins) {
            while (reachable < x - 1) {
                ++result
                reachable += reachable + 1
            }
            if (reachable >= target - x) {
                return result
            }
            reachable += x
        }
        ++result
        while (reachable < target - (reachable + 1)) {
            ++result
            reachable += reachable + 1
        }
        return result
    }
}
