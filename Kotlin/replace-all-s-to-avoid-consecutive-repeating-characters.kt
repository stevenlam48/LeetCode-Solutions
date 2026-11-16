package replaceallstoavoidconsecutiverepeatingcharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun modifyString(s: String): String {
        val result = StringBuilder(s)
        for (i in result.indices) {
            if (result[i] != '?') {
                continue
            }
            for (c in 'a'..'c') {
                if ((i == 0 || result[i - 1] != c) &&
                    (i == result.lastIndex || result[i + 1] != c)
                ) {
                    result[i] = c
                    break
                }
            }
        }
        return result.toString()
    }
}
