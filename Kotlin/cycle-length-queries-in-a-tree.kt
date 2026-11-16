package cyclelengthqueriesinatree

// Time:  O(q * n)
// Space: O(1)

// tree, lca
class Solution {
    fun cycleLengthQueries(n: Int, queries: Array<IntArray>): IntArray {
        val result = ArrayList<Int>()
        for (q in queries) {
            var x = q[0]
            var y = q[1]
            var cnt = 1
            while (x != y) {
                if (x > y) {
                    val tmp = x
                    x = y
                    y = tmp
                }
                y /= 2
                ++cnt
            }
            result.add(cnt)
        }
        return result.toIntArray()
    }
}
