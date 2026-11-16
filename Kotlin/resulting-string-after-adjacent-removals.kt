package resultingstringafteradjacentremovals

// Time:  O(n)
// Space: O(1)

class Solution {
    fun resultingString(s: String): String {
        val result = StringBuilder()
        for (x in s) {
            if (result.isNotEmpty()) {
                val diff = kotlin.math.abs(x - result[result.length - 1])
                if (diff == 1 || diff == 25) {
                    result.setLength(result.length - 1)
                    continue
                }
            }
            result.append(x)
        }
        return result.toString()
    }
}
