package miceandcheese

// Time:  O(n)
// Space: O(1)

class Solution {
    fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
        val diffs = IntArray(reward1.size)
        for (i in reward1.indices) {
            diffs[i] = reward1[i] - reward2[i]
        }
        diffs.sortDescending()
        var result = 0
        for (x in reward2) {
            result += x
        }
        for (i in 0 until k) {
            result += diffs[i]
        }
        return result
    }
}
