package dailytemperatures

// Time:  O(n)
// Space: O(n)

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stk = ArrayDeque<Int>()
        for (i in temperatures.indices) {
            while (stk.isNotEmpty() && temperatures[stk.last()] < temperatures[i]) {
                val idx = stk.removeLast()
                result[idx] = i - idx
            }
            stk.addLast(i)
        }
        return result
    }
}
