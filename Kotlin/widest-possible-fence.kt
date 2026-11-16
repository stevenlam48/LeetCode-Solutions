package widestpossiblefence

// Time:  O(n + c^2), c = len(cnt)
// Space: O(c^2)

// freq table
class Solution {
    fun maximumWidth(planks: IntArray): Int {
        val cnt1 = hashMapOf<Int, Int>()
        for (x in planks) {
            cnt1[x] = cnt1.getOrDefault(x, 0) + 1
        }
        val cnt2 = HashMap(cnt1)
        val cnt = cnt1.entries.map { it.key to it.value }
        for (i in cnt.indices) {
            val (x, c1) = cnt[i]
            cnt2[x + x] = cnt2.getOrDefault(x + x, 0) + c1 / 2
            for (j in 0 until i) {
                val (y, c2) = cnt[j]
                cnt2[x + y] = cnt2.getOrDefault(x + y, 0) + minOf(c1, c2)
            }
        }
        var result = 0
        for (c in cnt2.values) {
            result = maxOf(result, c)
        }
        return result
    }
}
