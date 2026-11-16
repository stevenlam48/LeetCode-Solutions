package applysubstitutions

// Time:  O(r * 2^r)
// Space: O(r * 2^r)

class Solution {
    fun applySubstitutions(replacements: List<List<String>>, text: String): String {
        val lookup = HashMap<String, String>()

        fun findAdj(s: String): Set<String> {
            val result = HashSet<String>()
            var i = 0
            while (i < s.length) {
                if (s[i] != '%') {
                    ++i
                    continue
                }
                var j = i + 1
                while (j < s.length && s[j] != '%') {
                    ++j
                }
                result.add(s.substring(i + 1, j))
                i = j + 1
            }
            return result
        }

        fun replace(s: String): String {
            val result = StringBuilder()
            var i = 0
            while (i < s.length) {
                if (s[i] != '%') {
                    result.append(s[i])
                    ++i
                    continue
                }
                var j = i + 1
                while (j < s.length && s[j] != '%') {
                    ++j
                }
                result.append(lookup.getValue(s.substring(i + 1, j)))
                i = j + 1
            }
            return result.toString()
        }

        for (x in replacements) {
            lookup[x[0]] = x[1]
        }

        val adj = HashMap<String, MutableSet<String>>()
        val inDegree = HashMap<String, Int>()
        for (x in replacements) {
            for (v in findAdj(x[1])) {
                adj.getOrPut(v) { HashSet() }.add(x[0])
                inDegree[x[0]] = inDegree.getOrDefault(x[0], 0) + 1
            }
        }
        var q = replacements.filter { !inDegree.containsKey(it[0]) }.map { it[0] }
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<String>()
            for (u in q) {
                lookup[u] = replace(lookup.getValue(u))
                for (v in adj[u].orEmpty()) {
                    inDegree[v] = inDegree.getValue(v) - 1
                    if (inDegree.getValue(v) != 0) {
                        continue
                    }
                    newQ.add(v)
                }
            }
            q = newQ
        }
        return replace(text)
    }
}
