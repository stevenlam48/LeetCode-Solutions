package ksimilarstrings
// Time:  O(n * n!/(c_a!*...*c_z!), n is the length of A, B,
//                                  c_a...c_z is the count of each alphabet,
//                                  n = sum(c_a...c_z)
// Space: O(n * n!/(c_a!*...*c_z!)

import java.util.ArrayDeque

class Solution {
    fun kSimilarity(A: String, B: String): Int {
        val q = ArrayDeque<String>()
        val lookup = HashSet<String>()
        lookup.add(A)
        q.add(A)
        var result = 0
        while (q.isNotEmpty()) {
            for (size in q.size - 1 downTo 0) {
                val s = q.removeFirst()
                if (s == B) {
                    return result
                }
                val chars = s.toCharArray()
                var i = 0
                while (chars[i] == B[i]) {
                    ++i
                }
                for (j in i + 1 until chars.size) {
                    if (chars[j] == B[j] || chars[i] != B[j]) {
                        continue
                    }
                    val tmp = chars[i]
                    chars[i] = chars[j]
                    chars[j] = tmp
                    val next = String(chars)
                    if (lookup.add(next)) {
                        q.add(next)
                    }
                    val restore = chars[i]
                    chars[i] = chars[j]
                    chars[j] = restore
                }
            }
            ++result
        }
        return result
    }
}
