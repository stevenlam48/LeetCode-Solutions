package carfleetii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
        val stk = mutableListOf<Int>()
        val result = DoubleArray(cars.size) { -1.0 }
        for (i in cars.size - 1 downTo 0) {
            val p = cars[i][0]
            val s = cars[i][1]
            while (stk.isNotEmpty() &&
                (cars[stk.last()][1] >= s ||
                    (0.0 < result[stk.last()] &&
                        result[stk.last()] <= (cars[stk.last()][0] - p).toDouble() / (s - cars[stk.last()][1])))) {
                stk.removeAt(stk.size - 1)
            }
            if (stk.isNotEmpty()) {
                result[i] = (cars[stk.last()][0] - p).toDouble() / (s - cars[stk.last()][1])
            }
            stk.add(i)
        }
        return result
    }
}
