package reverselettersthenspecialcharactersinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseByType(s: String): String {
        val chars = s.toCharArray()
        reverse(chars) { it.isLetter() }
        reverse(chars) { !it.isLetter() }
        return String(chars)
    }

    private fun reverse(chars: CharArray, check: (Char) -> Boolean) {
        var left = 0
        var right = chars.size - 1
        while (left < right) {
            if (!check(chars[left])) {
                ++left
            } else if (!check(chars[right])) {
                --right
            } else {
                val tmp = chars[left]
                chars[left] = chars[right]
                chars[right] = tmp
                ++left
                --right
            }
        }
    }
}
