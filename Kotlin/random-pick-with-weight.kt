package randompickwithweight

// Time:  ctor: O(n)
//        pickIndex: O(logn)
// Space: O(n)

class Solution(w: IntArray) {
    private val prefixSum = IntArray(w.size)
    private val gen = java.util.Random()

    init {
        var sum = 0
        for (i in w.indices) {
            sum += w[i]
            prefixSum[i] = sum
        }
    }

    fun pickIndex(): Int {
        val target = gen.nextInt(prefixSum[prefixSum.size - 1])
        var left = 0
        var right = prefixSum.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (prefixSum[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
