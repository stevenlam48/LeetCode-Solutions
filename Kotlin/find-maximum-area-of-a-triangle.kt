package findmaximumareaofatriangle

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxArea(coords: Array<IntArray>): Long {
        var mxX = Int.MIN_VALUE
        var mnX = Int.MAX_VALUE
        var mxY = Int.MIN_VALUE
        var mnY = Int.MAX_VALUE
        val lookupMxY = HashMap<Int, Int>()
        val lookupMnY = HashMap<Int, Int>()
        val lookupMxX = HashMap<Int, Int>()
        val lookupMnX = HashMap<Int, Int>()
        for (c in coords) {
            val x = c[0]
            val y = c[1]
            mxX = maxOf(mxX, x)
            mnX = minOf(mnX, x)
            mxY = maxOf(mxY, y)
            mnY = minOf(mnY, y)
            if (!lookupMxY.containsKey(x)) {
                lookupMxY[x] = y
            } else {
                lookupMxY[x] = maxOf(lookupMxY[x]!!, y)
            }
            if (!lookupMnY.containsKey(x)) {
                lookupMnY[x] = y
            } else {
                lookupMnY[x] = minOf(lookupMnY[x]!!, y)
            }
            if (!lookupMxX.containsKey(y)) {
                lookupMxX[y] = x
            } else {
                lookupMxX[y] = maxOf(lookupMxX[y]!!, x)
            }
            if (!lookupMnX.containsKey(y)) {
                lookupMnX[y] = x
            } else {
                lookupMnX[y] = minOf(lookupMnX[y]!!, x)
            }
        }
        var result = 0L
        for (x in lookupMxY.keys) {
            result = maxOf(
                result,
                (lookupMxY[x]!! - lookupMnY[x]!!).toLong() * maxOf(mxX - x, x - mnX)
            )
        }
        for (y in lookupMxX.keys) {
            result = maxOf(
                result,
                (lookupMxX[y]!! - lookupMnX[y]!!).toLong() * maxOf(mxY - y, y - mnY)
            )
        }
        return if (result != 0L) result else -1L
    }
}
