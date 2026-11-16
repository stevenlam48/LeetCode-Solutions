package parselispexpression

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun evaluate(expression: String): Int {
        var tokens = mutableListOf("")
        var lookup = HashMap<String, String>()
        val stk = ArrayList<Pair<MutableList<String>, HashMap<String, String>>>()
        for (c in expression) {
            when (c) {
                '(' -> {
                    if (tokens[0] == "let") {
                        evaluate(tokens, lookup)
                    }
                    stk.add(Pair(tokens, HashMap(lookup)))
                    tokens = mutableListOf("")
                }
                ' ' -> tokens.add("")
                ')' -> {
                    val value = evaluate(tokens, lookup)
                    val (savedTokens, savedLookup) = stk.removeAt(stk.size - 1)
                    tokens = savedTokens
                    lookup = savedLookup
                    tokens[tokens.size - 1] += value
                }
                else -> tokens[tokens.size - 1] += c
            }
        }
        return tokens[0].toInt()
    }

    private fun evaluate(tokens: List<String>, lookup: MutableMap<String, String>): String {
        if (tokens[0] == "add" || tokens[0] == "mult") {
            val a = getval(lookup, tokens[1]).toInt()
            val b = getval(lookup, tokens[2]).toInt()
            return (if (tokens[0] == "add") a + b else a * b).toString()
        }
        var i = 1
        while (i < tokens.size - 1) {
            if (tokens[i + 1].isNotEmpty()) {
                lookup[tokens[i]] = getval(lookup, tokens[i + 1])
            }
            i += 2
        }
        return getval(lookup, tokens[tokens.size - 1])
    }

    private fun getval(lookup: Map<String, String>, x: String): String {
        return lookup[x] ?: x
    }
}
