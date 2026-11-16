package arrayofdoubledpairs

// Time:  O(n + klogk)
// Space: O(k)

class Solution {
    fun canReorderDoubled(A: IntArray): Boolean {
        val count = HashMap<Int, Int>()
        for (x in A) {
            count[x] = (count[x] ?: 0) + 1
        }
        val keys = count.keys.toMutableList()
        keys.sortBy { Math.abs(it) }
        for (x in keys) {
            val cx = count[x] ?: 0
            val c2x = count[2 * x] ?: 0
            if (cx > c2x) {
                return false
            }
            count[2 * x] = c2x - cx
        }
        return true
    }
}
