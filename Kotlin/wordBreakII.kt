package wordBreakIIOld

// Time Complexity: O(n^2) ?
// Space Complexity: O(n^2)

class Solution {
    fun wordBreak(s: String, dict: Set<String>): List<String> {
        val f = BooleanArray(s.length + 1)
        val valid = Array(s.length) { BooleanArray(s.length + 1) }
        f[0] = true
        for (i in 1..s.length) {
            for (j in i - 1 downTo 0) {
                if (f[j] && s.substring(j, i) in dict) {
                    f[i] = true
                    valid[j][i] = true
                }
            }
        }

        val answer = mutableListOf<String>()
        genPath(s, valid, s.length, mutableListOf(), answer)
        return answer
    }

    private fun genPath(
        s: String,
        valid: Array<BooleanArray>,
        length: Int,
        path: MutableList<String>,
        answer: MutableList<String>
    ) {
        if (length == 0) {
            answer.add(path.asReversed().joinToString(" "))
        }
        for (i in 0 until length) {
            if (valid[i][length]) {
                path.add(s.substring(i, length))
                genPath(s, valid, i, path, answer)
                path.removeAt(path.lastIndex)
            }
        }
    }
}
