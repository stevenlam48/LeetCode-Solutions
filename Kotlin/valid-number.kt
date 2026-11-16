package validnumber

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isNumber(s: String): Boolean {
        val transitionTable = arrayOf(
            intArrayOf(-1, 0, 3, 1, 2, -1),
            intArrayOf(-1, 8, -1, 1, 4, 5),
            intArrayOf(-1, -1, -1, 4, -1, -1),
            intArrayOf(-1, -1, -1, 1, 2, -1),
            intArrayOf(-1, 8, -1, 4, -1, 5),
            intArrayOf(-1, -1, 6, 7, -1, -1),
            intArrayOf(-1, -1, -1, 7, -1, -1),
            intArrayOf(-1, 8, -1, 7, -1, -1),
            intArrayOf(-1, 8, -1, -1, -1, -1)
        )

        var state = 0
        for (c in s) {
            val inputType = when {
                c == ' ' || c == '\t' || c == '\n' || c == '\u000B' || c == '\u000C' || c == '\r' -> InputType.SPACE
                c == '+' || c == '-' -> InputType.SIGN
                c in '0'..'9' -> InputType.DIGIT
                c == '.' -> InputType.DOT
                c == 'e' || c == 'E' -> InputType.EXPONENT
                else -> InputType.INVALID
            }
            state = transitionTable[state][inputType.ordinal]
            if (state == -1) {
                return false
            }
        }
        return state == 1 || state == 4 || state == 7 || state == 8
    }

    private enum class InputType {
        INVALID,
        SPACE,
        SIGN,
        DIGIT,
        DOT,
        EXPONENT
    }
}
