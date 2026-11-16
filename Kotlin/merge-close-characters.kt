package mergeclosecharacters
// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun mergeCharacters(s: String, k: Int): String {
        val result = StringBuilder()
        val lookup = IntArray(26) { -1 }
        for (x in s) {
            val c = x - 'a'
            if (lookup[c] != -1 && result.length - lookup[c] <= k) {
                continue
            }
            lookup[c] = result.length
            result.append(x)
        }
        return result.toString()
    }
}
