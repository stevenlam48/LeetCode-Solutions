package maximumvalueofconcatenatedbinarysegments

// Time:  O(r + nlogn)
// Space: O(r + n)

private const val MOD = 1_000_000_007L
private const val MAX_TOTAL = 200_000

private val POW2: LongArray = LongArray(MAX_TOTAL + 1).also { p ->
    p[0] = 1L
    for (i in 0 until MAX_TOTAL) {
        p[i + 1] = p[i] * 2 % MOD
    }
}

class Solution {
    fun maxValue(nums1: IntArray, nums0: IntArray): Int {
        val segments = ArrayList<IntArray>()
        var l = 0
        for (i in nums1.indices) {
            if (nums0[i] != 0) {
                segments.add(intArrayOf(nums1[i], nums0[i]))
            } else {
                l += nums1[i]
            }
        }
        segments.sortWith(compareByDescending<IntArray> { it[0] }.thenBy { it[1] })
        var result = ((POW2[l] - 1) + MOD) % MOD
        for (s in segments) {
            val cnt1 = s[0]
            val cnt0 = s[1]
            result = ((result * POW2[cnt1 + cnt0]) % MOD +
                ((((POW2[cnt1] - 1) + MOD) % MOD) * POW2[cnt0]) % MOD) % MOD
        }
        return result.toInt()
    }
}
