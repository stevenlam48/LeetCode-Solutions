package maximumcoinsheroescancollect

// Time:  O(nlogn + mlogm)
// Space: O(n + m)

class Solution {
    fun maximumCoins(heroes: IntArray, monsters: IntArray, coins: IntArray): LongArray {
        val idxs1 = heroes.indices.sortedBy { heroes[it] }
        val idxs2 = monsters.indices.sortedBy { monsters[it] }
        val result = LongArray(idxs1.size)
        var i = 0
        var curr = 0L
        for (idx in idxs1) {
            while (i < idxs2.size) {
                if (monsters[idxs2[i]] > heroes[idx]) {
                    break
                }
                curr += coins[idxs2[i]]
                ++i
            }
            result[idx] = curr
        }
        return result
    }
}
