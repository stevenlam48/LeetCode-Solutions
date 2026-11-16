package subsequenceswithauniquemiddlemodei

import java.math.BigInteger

// Time:  O(n)
// Space: O(n)

// freq table, prefix sum, combinatorics
class Solution {
    fun subsequencesWithMiddleMode(nums: IntArray): Int {
        val two = BigInteger.valueOf(2)
        val one = BigInteger.ONE

        fun b(x: Int): BigInteger = BigInteger.valueOf(x.toLong())

        fun nC2(x: BigInteger): BigInteger = x.multiply(x.subtract(one)).divide(two)

        var result = BigInteger.ZERO
        val left = HashMap<Int, Int>()
        val right = HashMap<Int, Int>()
        for (x in nums) {
            right[x] = (right[x] ?: 0) + 1
        }

        var leftXSq = BigInteger.ZERO
        var rightXSq = BigInteger.ZERO
        var leftXRightX = BigInteger.ZERO
        var leftXSqRightX = BigInteger.ZERO
        var leftXRightXSq = BigInteger.ZERO
        for (v in right.values) {
            rightXSq = rightXSq.add(b(v).multiply(b(v)))
        }
        for (i in nums.indices) {
            val v = nums[i]
            val lv = left[v] ?: 0
            val rv = right[v] ?: 0
            leftXSq = leftXSq.subtract(b(lv).multiply(b(lv)))
            rightXSq = rightXSq.subtract(b(rv).multiply(b(rv)))
            leftXRightX = leftXRightX.subtract(b(lv).multiply(b(rv)))
            leftXSqRightX = leftXSqRightX.subtract(b(lv).multiply(b(lv)).multiply(b(rv)))
            leftXRightXSq = leftXRightXSq.subtract(b(lv).multiply(b(rv)).multiply(b(rv)))
            right[v] = rv - 1
            val rv2 = rv - 1

            val l = i
            val r = nums.size - (i + 1)
            result = result.add(nC2(b(l)).multiply(nC2(b(r))))
            result = result.subtract(nC2(b(l - lv)).multiply(nC2(b(r - rv2))))
            result = result.subtract(
                leftXSq.subtract(b(l - lv)).multiply(b(r - rv2))
                    .subtract(leftXSqRightX.subtract(leftXRightX))
                    .multiply(b(rv2)).divide(two)
            )
            result = result.subtract(
                rightXSq.subtract(b(r - rv2)).multiply(b(l - lv))
                    .subtract(leftXRightXSq.subtract(leftXRightX))
                    .multiply(b(lv)).divide(two)
            )
            result = result.subtract(
                b(lv).multiply(leftXRightX).multiply(b(r - rv2))
                    .subtract(b(lv).multiply(leftXRightXSq))
            )
            result = result.subtract(
                b(rv2).multiply(leftXRightX).multiply(b(l - lv))
                    .subtract(b(rv2).multiply(leftXSqRightX))
            )
            result = result.subtract(
                b(rv2).multiply(leftXSqRightX.subtract(leftXRightX)).divide(two)
            )
            result = result.subtract(
                b(lv).multiply(leftXRightXSq.subtract(leftXRightX)).divide(two)
            )

            left[v] = lv + 1
            leftXSq = leftXSq.add(b(lv + 1).multiply(b(lv + 1)))
            rightXSq = rightXSq.add(b(rv - 1).multiply(b(rv - 1)))
            leftXRightX = leftXRightX.add(b(lv + 1).multiply(b(rv - 1)))
            leftXSqRightX = leftXSqRightX.add(b(lv + 1).multiply(b(lv + 1)).multiply(b(rv - 1)))
            leftXRightXSq = leftXRightXSq.add(b(lv + 1).multiply(b(rv - 1)).multiply(b(rv - 1)))
        }

        return result.mod(BigInteger.valueOf(1000000007L)).toInt()
    }
}
