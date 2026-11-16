package rearrangecharacterstomaketargetstring
// Time:  O(n + m)
// Space: O(1)
class Solution {
    fun rearrangeCharacters(s: String, target: String): Int {
        val count1 = IntArray(26)
        val count2 = IntArray(26)
        for (c in s) {
            count1[c - 'a']++
        }
        for (c in target) {
            count2[c - 'a']++
        }
        var result = Int.MAX_VALUE
        for (i in count2.indices) {
            if (count2[i] == 0) {
                continue
            }
            result = minOf(result, count1[i] / count2[i])
        }
        return result
    }
}
