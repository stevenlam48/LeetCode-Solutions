package maximizeareaofsquareholeingrid

// Time:  O(h + v), h = len(hBars), v = len(vBars)
// Space: O(h + v)

// array, hash table
class Solution {
    fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
        val l = minOf(maxGap(hBars), maxGap(vBars))
        return l * l
    }

    private fun maxGap(arr: IntArray): Int {
        var result = 1
        val lookup = HashSet<Int>()
        for (x in arr) {
            lookup.add(x)
        }
        while (lookup.isNotEmpty()) {
            val x = lookup.first()
            var left = x
            while (lookup.contains(left - 1)) {
                --left
            }
            var right = x
            while (lookup.contains(right + 1)) {
                ++right
            }
            for (i in left..right) {
                lookup.remove(i)
            }
            result = maxOf(result, (right - left + 1) + 1)
        }
        return result
    }
}
