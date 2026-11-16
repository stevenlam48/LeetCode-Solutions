package comparestringsbyfrequencyofthesmallestcharacter

// Time:  O((m + n)logn), m is the number of queries, n is the number of words
// Space: O(n)


class Solution {
    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val wordsFreq = IntArray(words.size) { f(words[it]) }
        wordsFreq.sort()
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            result[i] = wordsFreq.size - upperBound(wordsFreq, f(queries[i]))
        }
        return result
    }

    private fun f(word: String): Int {
        var smallest = 'z'
        for (ch in word) {
            if (ch < smallest) {
                smallest = ch
            }
        }
        var count = 0
        for (ch in word) {
            if (ch == smallest) {
                ++count
            }
        }
        return count
    }

    private fun upperBound(a: IntArray, v: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (a[mid] <= v) lo = mid + 1 else hi = mid
        }
        return lo
    }
}
