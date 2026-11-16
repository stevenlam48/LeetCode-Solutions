package maximumnumberofones
// Time:  O(1)
// Space: O(1)

class Solution {
    fun maximumNumberOfOnes(width: Int, height: Int, sideLength: Int, maxOnes: Int): Int {
        var w = width
        var h = height
        if (w < h) {
            val temp = w
            w = h
            h = temp
        }
        val bigR = h / sideLength
        val r = h % sideLength
        val bigC = w / sideLength
        val c = w % sideLength
        val areaCounts = arrayOf(
            Pair(r * c, (bigR + 1) * (bigC + 1)),
            Pair(r * (sideLength - c), (bigR + 1) * bigC),
            Pair((sideLength - r) * c, bigR * (bigC + 1)),
            Pair((sideLength - r) * (sideLength - c), bigR * bigC)
        )
        var result = 0
        var remainingOnes = maxOnes
        for ((area, count) in areaCounts) {
            result += count * minOf(remainingOnes, area)
            remainingOnes -= minOf(remainingOnes, area)
            if (remainingOnes == 0) {
                break
            }
        }
        return result
    }
}
