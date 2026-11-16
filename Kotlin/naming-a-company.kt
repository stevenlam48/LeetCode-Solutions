package namingacompany

// Time:  O(26 * n * l)
// Space: O(n * l)

class Solution {
    fun distinctNames(ideas: List<String>): Long {
        val lookup = Array(26) { HashSet<String>() }
        for (idea in ideas) {
            lookup[idea[0] - 'a'].add(idea.substring(1))
        }
        var result = 0L
        for (i in 0 until 26) {
            for (j in i + 1 until 26) {
                var common = 0
                for (x in lookup[i]) {
                    if (lookup[j].contains(x)) {
                        ++common
                    }
                }
                result += (lookup[i].size - common).toLong() * (lookup[j].size - common)
            }
        }
        return result * 2
    }
}
