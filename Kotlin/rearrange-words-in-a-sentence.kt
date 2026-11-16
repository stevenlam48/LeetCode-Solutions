package rearrangewordsinasentence

import java.util.TreeMap

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun arrangeWords(text: String): String {
        val lowered = text[0].lowercaseChar() + text.substring(1)
        val lookup = TreeMap<Int, StringBuilder>()
        for (word in lowered.split(" ")) {
            if (word.isEmpty()) {
                continue
            }
            lookup.getOrPut(word.length) { StringBuilder() }.append(word).append(' ')
        }
        val result = StringBuilder()
        for (sb in lookup.values) {
            result.append(sb)
        }
        result.deleteCharAt(result.length - 1)
        result.setCharAt(0, result[0].uppercaseChar())
        return result.toString()
    }
}
