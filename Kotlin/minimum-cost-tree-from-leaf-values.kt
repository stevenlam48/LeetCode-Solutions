package minimumcosttreefromleafvalues

// Time:  O(n)
// Space: O(n)

class Solution {
    fun mctFromLeafValues(arr: IntArray): Int {
        var result = 0
        val stk = mutableListOf(Int.MAX_VALUE)
        for (x in arr) {
            while (stk[stk.size - 1] <= x) {
                val mid = stk.removeAt(stk.size - 1)
                result += mid * minOf(stk[stk.size - 1], x)
            }
            stk.add(x)
        }
        while (stk.size > 2) {
            val right = stk.removeAt(stk.size - 1)
            result += right * stk[stk.size - 1]
        }
        return result
    }
}
