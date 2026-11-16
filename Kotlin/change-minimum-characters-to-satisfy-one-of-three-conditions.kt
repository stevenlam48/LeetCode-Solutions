package changeminimumcharacterstosatisfyoneofthreeconditions

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun minCharacters(a: String, b: String): Int {
        val count1 = IntArray(26)
        val count2 = IntArray(26)
        for (c in a) {
            ++count1[c.code - 'a'.code]
        }
        for (c in b) {
            ++count2[c.code - 'a'.code]
        }
        var result = a.length + b.length
        for (i in 0 until 26) {
            result = minOf(result, a.length + b.length - count1[i] - count2[i])
            if (i > 0) {
                count1[i] += count1[i - 1]
                count2[i] += count2[i - 1]
            }
            if (i < 25) {
                result = minOf(result, a.length - count1[i] + count2[i])
                result = minOf(result, b.length - count2[i] + count1[i])
            }
        }
        return result
    }
}
