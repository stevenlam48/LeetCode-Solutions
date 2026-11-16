package lastvisitedintegers

// Time:  O(n)
// Space: O(n)

class Solution {
    fun lastVisitedIntegers(words: List<String>): IntArray {
        val result = mutableListOf<Int>()
        val stk = mutableListOf<Int>()
        var i = -1
        for (x in words) {
            if (x == "prev") {
                result.add(if (i >= 0) stk[i--] else -1)
                continue
            }
            stk.add(x.toInt())
            i = stk.size - 1
        }
        return result.toIntArray()
    }
}
