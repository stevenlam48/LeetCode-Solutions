package maximumvalueofanorderedtripletii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        val NEG_INF = Long.MIN_VALUE

        var result = 0L
        var mxDiff = NEG_INF
        var mx = NEG_INF
        for (x0 in nums) {
            val x = x0.toLong()
            if (mxDiff != NEG_INF) {
                result = maxOf(result, mxDiff * x)
            }
            if (mx != NEG_INF) {
                mxDiff = maxOf(mxDiff, mx - x)
            }
            mx = maxOf(mx, x)
        }
        return result
    }
}
