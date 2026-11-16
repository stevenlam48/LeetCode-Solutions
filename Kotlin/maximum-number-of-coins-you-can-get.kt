package maximumnumberofcoinsyoucanget

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxCoins(piles: IntArray): Int {
        piles.sort()
        var result = 0
        var i = piles.size / 3
        while (i < piles.size) {
            result += piles[i]
            i += 2
        }
        return result
    }
}
