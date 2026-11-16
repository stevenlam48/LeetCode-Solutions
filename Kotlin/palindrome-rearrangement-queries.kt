package palindromerearrangementqueries
// Time:  O(26 + d * n + d * q)
// Space: O(26 + d * n)

class Solution {
    fun canMakePalindromeQueries(s: String, queries: Array<IntArray>): BooleanArray {
        val lookup = IntArray(26) { -1 }
        var d = 0
        for (c in s) {
            if (lookup[c - 'a'] != -1) {
                continue
            }
            lookup[c - 'a'] = d++
        }
        val prefix = IntArray(s.length / 2 + 1)
        val prefixes1 = Array(s.length / 2 + 1) { IntArray(d) }
        val prefixes2 = Array(s.length / 2 + 1) { IntArray(d) }
        for (i in 0 until s.length / 2) {
            val x = lookup[s[i] - 'a']
            val y = lookup[s[(s.length - 1) - i] - 'a']
            prefix[i + 1] = prefix[i] + if (x != y) 1 else 0
            for (j in 0 until d) {
                prefixes1[i + 1][j] = prefixes1[i][j] + if (j == x) 1 else 0
                prefixes2[i + 1][j] = prefixes2[i][j] + if (j == y) 1 else 0
            }
        }

        fun check(left1: Int, right1: Int, left2: Int, right2: Int): Boolean {
            fun same(left: Int, right: Int): Boolean {
                for (i in 0 until d) {
                    if ((prefixes1[right + 1][i] - prefixes1[left][i]) -
                        (prefixes2[right + 1][i] - prefixes1[left][i]) != 0
                    ) {
                        return false
                    }
                }
                return true
            }

            val minLeft = minOf(left1, left2)
            val maxLeft = maxOf(left1, left2)
            val minRight = minOf(right1, right2)
            val maxRight = maxOf(right1, right2)
            if (!(prefix[minLeft] - prefix[0] == 0 && prefix.last() - prefix[maxRight + 1] == 0)) {
                return false
            }
            if (minRight < maxLeft) {
                return prefix[maxLeft] - prefix[minRight + 1] == 0 && same(minLeft, minRight) &&
                    same(maxLeft, maxRight)
            }
            if ((left1 == minLeft) == (right1 == maxRight)) {
                return same(minLeft, maxRight)
            }
            var p1 = prefixes1
            var p2 = prefixes2
            if (minLeft != left1) {
                val temp = p1
                p1 = p2
                p2 = temp
            }
            for (i in 0 until d) {
                val d1 = (p1[minRight + 1][i] - p1[minLeft][i]) - (p2[maxLeft][i] - p2[minLeft][i])
                val d2 = (p2[maxRight + 1][i] - p2[maxLeft][i]) - (p1[maxRight + 1][i] - p1[minRight + 1][i])
                if (!(d1 == d2 && d1 >= 0)) {
                    return false
                }
            }
            return true
        }

        val result = BooleanArray(queries.size)
        for (i in queries.indices) {
            result[i] = check(
                queries[i][0],
                queries[i][1],
                (s.length - 1) - queries[i][3],
                (s.length - 1) - queries[i][2]
            )
        }
        return result
    }
}
