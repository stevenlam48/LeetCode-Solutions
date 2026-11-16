package weightedwordmapping

// Time:  O(n * l)
// Space: O(1)

// string
class Solution {
    fun mapWordWeights(words: List<String>, weights: IntArray): String {
        val result = StringBuilder(words.size)
        for (w in words) {
            var i = 0
            for (x in w) {
                i = (i + weights[x - 'a']) % 26
            }
            result.append('z' - i)
        }
        return result.toString()
    }
}
