package palindromepairs
// Time:  O(n * k^2), n is the number of the words, k is the max length of the words.
// Space: O(n * k)

class Solution {
    fun palindromePairs(words: Array<String>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        val lookup = HashMap<Int, HashMap<String, Int>>()
        for (i in words.indices) {
            lookup.getOrPut(words[i].length) { HashMap() }[words[i]] = i
        }
        for (i in words.indices) {
            for (j in 0..words[i].length) {
                if (lookup.containsKey(j) && isPalindrome(words[i], j, words[i].length - 1)) {
                    val suffix = words[i].substring(0, j).reversed()
                    val bucket = lookup[suffix.length]!!
                    if (bucket.containsKey(suffix) && i != bucket[suffix]) {
                        result.add(intArrayOf(i, bucket[suffix]!!))
                    }
                }
                if (j > 0 && lookup.containsKey(words[i].length - j) && isPalindrome(words[i], 0, j - 1)) {
                    val prefix = words[i].substring(j).reversed()
                    val bucket = lookup[prefix.length]!!
                    if (bucket.containsKey(prefix) && bucket[prefix] != i) {
                        result.add(intArrayOf(bucket[prefix]!!, i))
                    }
                }
            }
        }
        return result.toTypedArray()
    }

    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var left = start
        var right = end
        while (left < right) {
            if (s[left++] != s[right--]) {
                return false
            }
        }
        return true
    }
}
