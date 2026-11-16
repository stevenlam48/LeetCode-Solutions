package braceexpansionii

// Time:  O(p*l * log(p*l)), p is the production of all number of options
//                         , l is the length of a word
// Space: O(p*l)

class Solution {
    fun braceExpansionII(expression: String): List<String> {
        val i = intArrayOf(0)
        return generateWords(expression, i)
    }

    private fun generateWords(expr: String, i: IntArray): List<String> {
        val options = mutableListOf<List<String>>()
        while (i[0] != expr.length && ",}".indexOf(expr[i[0]]) == -1) {
            var tmp: List<String> = emptyList()
            if ("{,}".indexOf(expr[i[0]]) == -1) {
                tmp = listOf(expr[i[0]].toString())
                ++i[0]
            } else if (expr[i[0]] == '{') {
                tmp = generateOption(expr, i)
            }
            options.add(tmp)
        }
        return formWords(options)
    }

    private fun generateOption(expr: String, i: IntArray): List<String> {
        val optionSet = sortedSetOf<String>()
        while (i[0] != expr.length && expr[i[0]] != '}') {
            ++i[0]
            for (option in generateWords(expr, i)) {
                optionSet.add(option)
            }
        }
        ++i[0]
        return optionSet.toList()
    }

    private fun formWords(options: List<List<String>>): List<String> {
        val wordsSet = sortedSetOf<String>()
        var total = 1
        for (opt in options) {
            total *= opt.size
        }
        for (i in 0 until total) {
            val tmp = mutableListOf<String>()
            var curr = i
            for (j in options.size - 1 downTo 0) {
                tmp.add(options[j][curr % options[j].size])
                curr /= options[j].size
            }
            tmp.reverse()
            wordsSet.add(tmp.joinToString(""))
        }
        return wordsSet.toList()
    }
}
