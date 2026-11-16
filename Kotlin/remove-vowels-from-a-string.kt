package removevowelsfromastring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun removeVowels(S: String): String {
        return buildString {
            for (c in S) {
                if (c !in "aeiou") {
                    append(c)
                }
            }
        }
    }
}
