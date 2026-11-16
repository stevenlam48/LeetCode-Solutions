package minimizethedifferencebetweentargetandchosenelements
// Time:  O(max_t * m * n), max_t is max_target
// Space: O(max_t)

import java.math.BigInteger

class Solution {
    fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
        var chosenMin = 0
        for (row in mat) {
            chosenMin += row.min()
        }
        if (chosenMin >= target) {
            return chosenMin - target
        }
        val maxTarget = 800
        val bitsetSize = (2 * maxTarget - 2) + 1
        val mask = BigInteger.ONE.shiftLeft(bitsetSize).subtract(BigInteger.ONE)
        var bs = BigInteger.ONE
        for (row in mat) {
            var newBs = BigInteger.ZERO
            for (x in row) {
                newBs = newBs.or(bs.shiftLeft(x))
            }
            bs = newBs.and(mask)
        }
        var result = bitsetSize
        for (total in chosenMin until bitsetSize) {
            if (!bs.testBit(total)) {
                continue
            }
            result = minOf(result, Math.abs(target - total))
            if (total > target) {
                break
            }
        }
        return result
    }
}
