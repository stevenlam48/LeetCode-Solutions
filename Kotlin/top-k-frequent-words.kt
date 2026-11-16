package topkfrequentwords

// Time:  O(n + klogk) on average
// Space: O(n)

class Solution {
    fun topKFrequent(words: List<String>, k: Int): List<String> {
        val counts = HashMap<String, Int>()
        for (word in words) {
            counts[word] = (counts[word] ?: 0) + 1
        }
        val p = counts.map { (word, cnt) -> -cnt to word }
        val ordered = p.sortedWith(compareBy({ it.first }, { it.second }))
        return ordered.take(k).map { it.second }
    }
}
