package evaluatethebracketpairsofastring

// Time:  O(n + m)
// Space: O(n + m)
class Solution {
    fun evaluate(s: String, knowledge: Array<Array<String>>): String {
        val lookup = HashMap<String, String>()
        for (pair in knowledge) {
            lookup[pair[0]] = pair[1]
        }
        val result = StringBuilder()
        val curr = StringBuilder()
        var hasPair = false
        for (i in s.indices) {
            if (s[i] == '(') {
                hasPair = true
            } else if (s[i] == ')') {
                hasPair = false
                val value = lookup[curr.toString()]
                if (value != null) {
                    result.append(value)
                } else {
                    result.append('?')
                }
                curr.setLength(0)
            } else if (hasPair) {
                curr.append(s[i])
            } else {
                result.append(s[i])
            }
        }
        return result.toString()
    }
}
