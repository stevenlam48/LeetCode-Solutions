package findcommoncharacters

// Time:  O(n * l)
// Space: O(1)

class Solution {
    fun commonChars(A: Array<String>): List<String> {
        val count = IntArray(26) { Int.MAX_VALUE }
        val result = mutableListOf<String>()
        for (a in A) {
            val tmpCount = IntArray(count.size)
            for (c in a) {
                ++tmpCount[c - 'a']
            }
            for (i in count.indices) {
                count[i] = minOf(count[i], tmpCount[i])
            }
        }
        for (i in count.indices) {
            for (j in 0 until count[i]) {
                result.add((i + 'a'.code).toChar().toString())
            }
        }
        return result
    }
}
