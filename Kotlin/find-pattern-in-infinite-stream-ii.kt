package findpatternininfinitestreamii

// Time:  O(p + n)
// Space: O(p)

interface InfiniteStream {
    fun next(): Int
}

class Solution {
    fun findPattern(stream: InfiniteStream, pattern: IntArray): Int {
        fun getPrefix(pattern: IntArray): IntArray {
            val prefix = IntArray(pattern.size) { -1 }
            var j = -1
            for (i in 1 until pattern.size) {
                while (j > -1 && pattern[j + 1] != pattern[i]) {
                    j = prefix[j]
                }
                if (pattern[j + 1] == pattern[i]) {
                    ++j
                }
                prefix[i] = j
            }
            return prefix
        }

        val prefix = getPrefix(pattern)
        var j = -1
        var i = 0
        while (true) {
            val d = stream.next()
            while (j > -1 && pattern[j + 1] != d) {
                j = prefix[j]
            }
            if (pattern[j + 1] == d) {
                ++j
            }
            if (j == pattern.size - 1) {
                return i - j
            }
            ++i
        }
    }
}
