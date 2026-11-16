package maximumfonttofitasentenceinascreen

// Time:  O(n + logm), n is the length of text, m is the number of fonts
// Space: O(1)

interface FontInfo {
    fun getWidth(fontSize: Int, ch: Char): Int
    fun getHeight(fontSize: Int): Int
}

class Solution {
    fun maxFont(text: String, w: Int, h: Int, fonts: IntArray, fontInfo: FontInfo): Int {
        val count = IntArray(26)
        for (c in text) {
            ++count[c - 'a']
        }
        var left = 0
        var right = fonts.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(count, w, h, fonts, fontInfo, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (right >= 0) fonts[right] else -1
    }

    private fun check(
        count: IntArray,
        w: Int,
        h: Int,
        fonts: IntArray,
        fontInfo: FontInfo,
        x: Int
    ): Boolean {
        if (fontInfo.getHeight(fonts[x]) > h) {
            return false
        }
        var width = 0
        for (c in count.indices) {
            width += count[c] * fontInfo.getWidth(fonts[x], 'a' + c)
            if (width > w) {
                return false
            }
        }
        return true
    }
}
