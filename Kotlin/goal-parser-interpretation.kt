package goalparserinterpretation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun interpret(command: String): String {
        val result = StringBuilder()
        var i = 0
        while (i < command.length) {
            if (command[i] == 'G') {
                result.append('G')
                i++
            } else if (command[i + 1] == ')') {
                result.append('o')
                i += 2
            } else {
                result.append("al")
                i += 4
            }
        }
        return result.toString()
    }
}
