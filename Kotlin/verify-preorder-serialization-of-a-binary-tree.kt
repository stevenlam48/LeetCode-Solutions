package verifypreorderserializationofabinarytree
// Time:  O(n)
// Space: O(1)

class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        if (preorder.isEmpty()) {
            return false
        }
        val tokens = Tokenizer(preorder)
        var depth = 0
        var i = 0
        while (i < tokens.size && depth >= 0) {
            if (tokens.getNext() == "#") {
                --depth
            } else {
                ++depth
            }
            ++i
        }
        return i == tokens.size && depth < 0
    }

    private class Tokenizer(private val str: String) {
        val size = str.count { it == ',' } + 1
        private var index = 0
        private var count = 0

        fun getNext(): String {
            if (count >= size) {
                return ""
            }
            val separator = str.indexOf(',', index)
            val end = if (separator < 0) str.length else separator
            val next = str.substring(index, end)
            index = separator + 1
            ++count
            return next
        }
    }
}
