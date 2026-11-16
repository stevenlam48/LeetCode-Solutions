package checkifastringcanbreakanotherstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkIfCanBreak(s1: String, s2: String): Boolean {
        val count1 = counter(s1)
        val count2 = counter(s2)
        return isBreak(count1, count2) || isBreak(count2, count1)
    }

    private fun isBreak(count1: IntArray, count2: IntArray): Boolean {
        var curr1 = 0
        var curr2 = 0
        for (c in 0 until 26) {
            curr1 += count1[c]
            curr2 += count2[c]
            if (curr1 < curr2) {
                return false
            }
        }
        return true
    }

    private fun counter(word: String): IntArray {
        val count = IntArray(26)
        for (c in word) {
            ++count[c - 'a']
        }
        return count
    }
}
