package minimumincrementtomakearrayunique
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minIncrementForUnique(A: IntArray): Int {
        val a = A.toMutableList()
        a.sort()
        a.add(Int.MAX_VALUE)
        var result = 0L
        var duplicate = 0
        for (i in 1 until a.size) {
            if (a[i - 1] == a[i]) {
                ++duplicate
                result -= a[i]
            } else {
                val move = minOf(duplicate, a[i] - a[i - 1] - 1)
                duplicate -= move
                result += move.toLong() * a[i - 1] + move.toLong() * (move + 1) / 2
            }
        }
        return result.toInt()
    }
}
