package distinctechosubstrings

// Time:  O(n^2 + d), d is the duplicated of result substrings size
// Space: O(r), r is the size of result substrings set

class Solution {
    fun distinctEchoSubstrings(text: String): Int {
        val result = HashSet<String>()
        var l = text.length - 1
        for (i in 0 until l) {
            val substrLen = kmp(text, i, result)
            if (substrLen != Int.MAX_VALUE) {
                l = minOf(l, i + substrLen)
            }
        }
        return result.size
    }

    private fun kmp(text: String, l: Int, result: MutableSet<String>): Int {
        val prefix = IntArray(text.length - l) { -1 }
        var j = -1
        for (i in 1 until prefix.size) {
            while (j > -1 && text[l + j + 1] != text[l + i]) {
                j = prefix[j]
            }
            if (text[l + j + 1] == text[l + i]) {
                ++j
            }
            prefix[i] = j
            if ((j + 1) != 0 && (i + 1) % ((i + 1) - (j + 1)) == 0 &&
                (i + 1) / ((i + 1) - (j + 1)) % 2 == 0
            ) {
                result.add(text.substring(l, l + i + 1))
            }
        }
        val last = prefix.last()
        return if (last + 1 != 0 && prefix.size % (prefix.size - (last + 1)) == 0) {
            prefix.size - (last + 1)
        } else {
            Int.MAX_VALUE
        }
    }
}
