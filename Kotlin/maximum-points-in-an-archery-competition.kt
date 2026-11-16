package maximumpointsinanarcherycompetition
// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
        var result = IntArray(aliceArrows.size)
        var best = 0
        val fullMask = (1 shl aliceArrows.size) - 1
        for (mask in 1..fullMask) {
            val (score, count) = check(aliceArrows, mask, numArrows)
            if (score > best) {
                best = score
                result = count
            }
        }
        return result
    }

    private fun check(aliceArrows: IntArray, mask: Int, numArrows: Int): Pair<Int, IntArray> {
        var currentMask = mask
        var remainingArrows = numArrows
        var score = 0
        val count = IntArray(aliceArrows.size)
        for (k in aliceArrows.indices) {
            if ((currentMask and 1) != 0) {
                val need = aliceArrows[k] + 1
                if (need > remainingArrows) {
                    return 0 to IntArray(aliceArrows.size)
                }
                remainingArrows -= need
                count[k] = need
                score += k
            }
            currentMask = currentMask shr 1
        }
        count[count.lastIndex] += remainingArrows
        return score to count
    }
}
