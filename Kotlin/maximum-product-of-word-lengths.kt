package maximumproductofwordlengths

// Time:  O(n) ~ O(n^2)
// Space: O(n)

// Counting Sort + Pruning + Bit Manipulation
class Solution {
    fun maxProduct(words: List<String>): Int {
        val sorted = countingSort(words)
        val bits = IntArray(sorted.size)
        for (i in sorted.indices) {
            for (c in sorted[i]) {
                bits[i] = bits[i] or (1 shl (c - 'a'))
            }
        }
        var maxProduct = 0
        var i = 0
        while (i + 1 < sorted.size && sorted[i].length * sorted[i].length > maxProduct) {
            var j = i + 1
            while (j < sorted.size && sorted[i].length * sorted[j].length > maxProduct) {
                if (bits[i] and bits[j] == 0) {
                    maxProduct = sorted[i].length * sorted[j].length
                }
                ++j
            }
            ++i
        }
        return maxProduct
    }

    private fun countingSort(words: List<String>): List<String> {
        val k = 1000
        val buckets = Array(k) { ArrayList<String>() }
        for (word in words) {
            buckets[word.length].add(word)
        }
        val res = ArrayList<String>()
        for (i in k - 1 downTo 0) {
            if (buckets[i].isNotEmpty()) {
                res.addAll(buckets[i])
            }
        }
        return res
    }
}
