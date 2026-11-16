package largestmergeoftwostrings

// Time:  O(n * m)
// Space: O(n + m)

import java.util.ArrayDeque

class Solution {
    fun largestMerge(word1: String, word2: String): String {
        var q1 = ArrayDeque<Char>()
        var q2 = ArrayDeque<Char>()
        for (c in word1) {
            q1.addLast(c)
        }
        for (c in word2) {
            q2.addLast(c)
        }
        val result = StringBuilder()
        while (q1.isNotEmpty() || q2.isNotEmpty()) {
            if (compareQueues(q1, q2) < 0) {
                val tmp = q1
                q1 = q2
                q2 = tmp
            }
            result.append(q1.removeFirst())
        }
        return result.toString()
    }

    private fun compareQueues(q1: ArrayDeque<Char>, q2: ArrayDeque<Char>): Int {
        val it1 = q1.iterator()
        val it2 = q2.iterator()
        while (it1.hasNext() && it2.hasNext()) {
            val comparison = it1.next().compareTo(it2.next())
            if (comparison != 0) {
                return comparison
            }
        }
        return q1.size.compareTo(q2.size)
    }
}
