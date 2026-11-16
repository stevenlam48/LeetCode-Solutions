package calculatescoreafterperforminginstructions

// Time:  O(n)
// Space: O(n)

class Solution {
    fun calculateScore(instructions: Array<String>, values: IntArray): Long {
        var result = 0L
        val lookup = BooleanArray(instructions.size)
        var i = 0
        while (i >= 0 && i < instructions.size) {
            if (lookup[i]) {
                break
            }
            lookup[i] = true
            if (instructions[i] == "add") {
                result += values[i]
                ++i
            } else {
                i += values[i]
            }
        }
        return result
    }
}
