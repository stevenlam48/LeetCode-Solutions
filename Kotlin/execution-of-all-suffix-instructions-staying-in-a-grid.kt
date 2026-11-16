package executionofallsuffixinstructionsstayinginagrid

// Time:  O(m)
// Space: O(m)

class Solution {
    fun executeInstructions(n: Int, startPos: IntArray, s: String): IntArray {
        val directions = mapOf(
            'U' to (-1 to 0), 'R' to (0 to 1), 'D' to (1 to 0), 'L' to (0 to -1)
        )

        val x0 = startPos[0]
        val y0 = startPos[1]
        var x = 0
        var y = 0
        val result = IntArray(s.length) { s.length - it }
        val lookupX = mutableMapOf<Int, MutableList<Int>>()
        val lookupY = mutableMapOf<Int, MutableList<Int>>()
        lookupX.getOrPut(x0 - x) { mutableListOf() }.add(0)
        lookupY.getOrPut(y0 - y) { mutableListOf() }.add(0)
        for (i in s.indices) {
            val (dx, dy) = directions.getValue(s[i])
            x += dx
            y += dy
            for (k in intArrayOf(n - x, -x - 1)) {
                val indices = lookupX[k] ?: continue
                for (j in indices) {
                    result[j] = minOf(result[j], i - j)
                }
                lookupX.remove(k)
            }
            for (k in intArrayOf(n - y, -y - 1)) {
                val indices = lookupY[k] ?: continue
                for (j in indices) {
                    result[j] = minOf(result[j], i - j)
                }
                lookupY.remove(k)
            }
            lookupX.getOrPut(x0 - x) { mutableListOf() }.add(i + 1)
            lookupY.getOrPut(y0 - y) { mutableListOf() }.add(i + 1)
        }
        return result
    }
}
