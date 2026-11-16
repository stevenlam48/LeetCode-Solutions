package lettercasepermutation

// Time:  O(n * 2^n)
// Space: O(1)

class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val result = mutableListOf("")
        for (c in S) {
            if (c in 'a'..'z' || c in 'A'..'Z') {
                val size = result.size
                for (i in 0 until size) {
                    val lower = result[i] + c.lowercaseChar()
                    val upper = result[i] + c.uppercaseChar()
                    result[i] = lower
                    result.add(upper)
                }
            } else {
                for (i in result.indices) {
                    result[i] = result[i] + c
                }
            }
        }
        return result
    }
}
