package platesbetweencandles
// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val left = IntArray(s.length)
        val prefix = HashMap<Int, Int>()
        var curr = -1
        var cnt = 0
        for (i in s.indices) {
            if (s[i] == '|') {
                curr = i
                prefix[i] = ++cnt
            }
            left[i] = curr
        }
        val right = IntArray(s.length)
        curr = s.length
        cnt = 0
        for (i in s.lastIndex downTo 0) {
            if (s[i] == '|') {
                curr = i
                ++cnt
            }
            right[i] = curr
        }
        val result = mutableListOf<Int>()
        for (q in queries) {
            val l = right[q[0]]
            val r = left[q[1]]
            result.add(if (l < r) (r - l + 1) - (prefix[r]!! - prefix[l]!! + 1) else 0)
        }
        return result.toIntArray()
    }
}
