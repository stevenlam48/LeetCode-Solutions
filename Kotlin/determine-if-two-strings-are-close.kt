package determineiftwostringsareclose

// Time:  O(n)
// Space: O(1)

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        val count1 = IntArray(26)
        val count2 = IntArray(26)
        for (c in word1) {
            ++count1[c - 'a']
        }
        for (c in word2) {
            ++count2[c - 'a']
        }
        val diff = HashMap<Int, Int>()
        for (i in count1.indices) {
            if (count1[i] == 0 && count2[i] == 0) {
                continue
            }
            if (count1[i] == 0 || count2[i] == 0) {
                return false
            }
            diff[count1[i]] = diff.getOrDefault(count1[i], 0) + 1
            diff[count2[i]] = diff.getOrDefault(count2[i], 0) - 1
        }
        return diff.values.all { it == 0 }
    }
}
