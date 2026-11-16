package generatetagforvideocaption

// Time:  O(n)
// Space: O(1)

class Solution {
    fun generateTag(caption: String): String {
        val result = StringBuilder(100)
        result.append('#')
        for (i in caption.indices) {
            if (caption[i] == ' ') {
                continue
            }
            result.append(if (i == 0 || caption[i - 1] == ' ') caption[i].uppercaseChar() else caption[i].lowercaseChar())
            if (result.length == 100) {
                break
            }
        }
        if (result.length > 1) {
            result[1] = result[1].lowercaseChar()
        }
        return result.toString()
    }
}
