package countvalidwordoccurrences

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countWordOccurrences(chunks: List<String>, queries: List<String>): IntArray {
        val curr = StringBuilder()
        fun check(i: Int, j: Int): Boolean {
            val c = chunks[i][j]
            return (c in 'a'..'z') ||
                (c == '-' &&
                    curr.isNotEmpty() && curr.last() in 'a'..'z' &&
                    ((j + 1 < chunks[i].length && chunks[i][j + 1] in 'a'..'z') ||
                        (j + 1 == chunks[i].length && i + 1 < chunks.size && chunks[i + 1][0] in 'a'..'z'))
                )
        }

        val cnt = HashMap<String, Int>()
        for (i in chunks.indices) {
            for (j in chunks[i].indices) {
                if (check(i, j)) {
                    curr.append(chunks[i][j])
                    continue
                }
                if (curr.isNotEmpty()) {
                    cnt[curr.toString()] = (cnt[curr.toString()] ?: 0) + 1
                    curr.setLength(0)
                }
            }
        }
        if (curr.isNotEmpty()) {
            cnt[curr.toString()] = (cnt[curr.toString()] ?: 0) + 1
            curr.setLength(0)
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            cnt[queries[i]]?.let { result[i] = it }
        }
        return result
    }
}
