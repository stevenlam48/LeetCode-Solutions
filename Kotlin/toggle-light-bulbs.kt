package togglelightbulbs

// Time:  O(n + r)
// Space: O(r)

class Solution {
    fun toggleLightBulbs(bulbs: IntArray): IntArray {
        val mx = bulbs.max()
        val cnt = IntArray(mx + 1)
        for (x in bulbs) {
            cnt[x] = cnt[x] xor 1
        }
        val result = ArrayList<Int>()
        for (i in 1..mx) {
            if (cnt[i] != 0) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
