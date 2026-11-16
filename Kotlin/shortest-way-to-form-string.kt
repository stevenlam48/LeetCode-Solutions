package shortestwaytoformstring

// Time:  O(m + n), m is the length of source
//                , n is the length of target
// Space: O(m)
class Solution {
    fun shortestWay(source: String, target: String): Int {
        val lookup = Array(source.length + 1) { IntArray(26) { -1 } }
        val findCharNextPos = IntArray(26) { -1 }
        for (i in source.lastIndex downTo 0) {
            findCharNextPos[source[i] - 'a'] = i + 1
            lookup[i] = findCharNextPos.copyOf()
        }
        var result = 1
        var start = 0
        for (c in target) {
            start = lookup[start][c - 'a']
            if (start != -1) continue
            ++result
            start = lookup[0][c - 'a']
            if (start == -1) return -1
        }
        return result
    }
}
