package keyboardrow

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findWords(words: List<String>): List<String> {
        val result = ArrayList<String>()
        for (word in words) {
            var k = 0
            for (i in rows.indices) {
                if (rows[i].contains(word[0].lowercaseChar())) {
                    k = i
                    break
                }
            }
            result.add(word)
            for (c in word) {
                if (!rows[k].contains(c.lowercaseChar())) {
                    result.removeAt(result.size - 1)
                    break
                }
            }
        }
        return result
    }

    private companion object {
        val rows = listOf(
            setOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'),
            setOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'),
            setOf('z', 'x', 'c', 'v', 'b', 'n', 'm')
        )
    }
}
