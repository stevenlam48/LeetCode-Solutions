package findthesequenceofstringsappearedonthescreen

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun stringSequence(target: String): List<String> {
        val result = ArrayList<String>()
        for (x in target) {
            val i = result.size - 1
            var c = 'a'
            while (c <= x) {
                result.add((if (i != -1) result[i] else "") + c)
                ++c
            }
        }
        return result
    }
}
