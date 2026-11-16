package rearrangespacesbetweenwords

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reorderSpaces(text: String): String {
        val chars = text.toCharArray()
        var spaceCount = 0
        var wordCount = 0
        for (i in chars.indices) {
            if (chars[i] == ' ') {
                ++spaceCount
            } else if (i == 0 || chars[i - 1] == ' ') {
                ++wordCount
            }
        }
        var left = 0
        var i = 0
        while (i < chars.size) {
            var hasWord = false
            while (i < chars.size && chars[i] != ' ') {
                val tmp = chars[left]
                chars[left] = chars[i]
                chars[i] = tmp
                ++left
                ++i
                hasWord = true
            }
            if (hasWord) {
                ++left
            }
            ++i
        }
        val equalCount = if (wordCount - 1 > 0) spaceCount / (wordCount - 1) else 0
        val extraCount = if (wordCount - 1 > 0) spaceCount % (wordCount - 1) else spaceCount
        var right = chars.size - 1 - extraCount
        i = chars.size - 1
        while (i >= 0) {
            var hasWord = false
            while (i >= 0 && chars[i] != ' ') {
                val tmp = chars[right]
                chars[right] = chars[i]
                chars[i] = tmp
                --right
                --i
                hasWord = true
            }
            if (hasWord) {
                right -= equalCount
            }
            --i
        }
        return String(chars)
    }
}
