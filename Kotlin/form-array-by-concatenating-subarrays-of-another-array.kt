package formarraybyconcatenatingsubarraysofanotherarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        var pos = 0
        for (group in groups) {
            pos = kmp(nums, group, pos)
            if (pos == -1) {
                return false
            }
            pos += group.size
        }
        return true
    }

    private fun kmp(text: IntArray, pattern: IntArray, start: Int): Int {
        val prefix = getPrefix(pattern)
        var j = -1
        for (i in start until text.size) {
            while (j + 1 > 0 && pattern[j + 1] != text[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == text[i]) {
                ++j
            }
            if (j + 1 == pattern.size) {
                return i - j
            }
        }
        return -1
    }

    private fun getPrefix(pattern: IntArray): IntArray {
        val prefix = IntArray(pattern.size) { -1 }
        var j = -1
        for (i in 1 until pattern.size) {
            while (j + 1 > 0 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }
}
