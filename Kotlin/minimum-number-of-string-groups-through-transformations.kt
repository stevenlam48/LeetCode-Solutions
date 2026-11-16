package minimumnumberofstringgroupsthroughtransformations

// Time:  O(n * l)
// Space: O(n * l)

class Solution {
    fun minimumGroups(words: List<String>): Int {
        val lookup = HashSet<String>()
        for (w in words) {
            val parts = arrayOf(StringBuilder(), StringBuilder())
            for (i in w.indices) {
                parts[i % 2].append(w[i])
            }
            val key = canonical(parts[0].toString()) + '#' + canonical(parts[1].toString())
            lookup.add(key)
        }
        return lookup.size
    }

    private fun canonical(s: String): String {
        val rotation = leastRotation(s)
        return s.substring(rotation) + s.substring(0, rotation)
    }

    private fun leastRotation(s: String): Int {
        val n = s.length
        var i = 0
        var j = 1
        var k = 0
        while (i < n && j < n && k < n) {
            val a = s[(i + k) % n]
            val b = s[(j + k) % n]
            if (a == b) {
                ++k
            } else {
                if (a > b) {
                    i += k + 1
                } else {
                    j += k + 1
                }
                if (i == j) {
                    ++j
                }
                k = 0
            }
        }
        return minOf(i, j)
    }
}
