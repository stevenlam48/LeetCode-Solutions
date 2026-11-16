package findthedivisibilityarrayofastring

// Time:  O(n)
// Space: O(1)
class Solution {
    fun divisibilityArray(word: String, m: Int): IntArray {
        val result = ArrayList<Int>(word.length)
        var curr = 0
        for (c in word) {
            curr = ((curr * 10L + (c - '0')) % m).toInt()
            result.add(if (curr == 0) 1 else 0)
        }
        return result.toIntArray()
    }
}
