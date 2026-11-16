package capitalizethetitle

// Time:  O(n)
// Space: O(1)

class Solution {
    fun capitalizeTitle(title: String): String {
        val chars = title.toCharArray()
        var j = 0
        var i = 0
        while (i <= chars.size) {
            if (i < chars.size && chars[i] != ' ') {
                chars[i] = Character.toLowerCase(chars[i])
                ++i
                continue
            }
            if (i - j > 2) {
                chars[j] = Character.toUpperCase(chars[j])
            }
            j = i + 1
            ++i
        }
        return String(chars)
    }
}
