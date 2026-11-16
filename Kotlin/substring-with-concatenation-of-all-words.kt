package substringwithconcatenationofallwords

// Time:  O((m + n) * k), m is the length of the string,
//                        n is the size of the dictionary,
//                        k is the length of each word
// Space: O(n * k)
class Solution {
    fun findSubstring(s: String, words: List<String>): IntArray {
        if (words.isEmpty()) {
            return intArrayOf()
        }
        val result = mutableListOf<Int>()
        val m = s.length
        val n = words.size
        val k = words.first().length
        if (m < n * k) {
            return result.toIntArray()
        }
        val lookup = HashMap<String, Int>()
        for (word in words) {
            lookup[word] = lookup.getOrDefault(word, 0) + 1
        }
        for (i in 0 until k) {
            val tmp = HashMap<String, Int>()
            var left = i
            var count = 0
            var j = i
            while (j <= m - k) {
                val str = s.substring(j, j + k)
                if (lookup.containsKey(str)) {
                    tmp[str] = tmp.getOrDefault(str, 0) + 1
                    ++count
                    while (tmp.getValue(str) > lookup.getValue(str)) {
                        val leftWord = s.substring(left, left + k)
                        tmp[leftWord] = tmp.getValue(leftWord) - 1
                        --count
                        left += k
                    }
                    if (count == n) {
                        result.add(left)
                    }
                } else {
                    tmp.clear()
                    count = 0
                    left = j + k
                }
                j += k
            }
        }
        return result.toIntArray()
    }
}
