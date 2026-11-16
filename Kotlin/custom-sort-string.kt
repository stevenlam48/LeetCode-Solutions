package customsortstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun customSortString(S: String, T: String): String {
        val s = S.toHashSet()
        val counter = HashMap<Char, Int>()
        for (c in T) {
            counter[c] = (counter[c] ?: 0) + 1
        }
        val result = StringBuilder()
        for (c in S) {
            repeat(counter[c] ?: 0) { result.append(c) }
        }
        for ((c, count) in counter) {
            if (c !in s) {
                repeat(count) { result.append(c) }
            }
        }
        return result.toString()
    }
}
