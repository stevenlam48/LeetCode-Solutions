package randompointinnonoverlappingrectangles

// Time:  ctor: O(n)
//        pick: O(logn)
// Space: O(n)

class Solution(rects: Array<IntArray>) {
    private val rects = rects
    private val prefixSum = mutableListOf<Int>()
    private val gen = java.util.Random()

    init {
        for (rect in this.rects) {
            val width = rect[2] - rect[0] + 1
            val height = rect[3] - rect[1] + 1
            if (prefixSum.isEmpty()) {
                prefixSum.add(width * height)
            } else {
                prefixSum.add(prefixSum[prefixSum.size - 1] + width * height)
            }
        }
    }

    fun pick(): IntArray {
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
        val rect = rects[left]
        val width = rect[2] - rect[0] + 1
        val height = rect[3] - rect[1] + 1
        val base = prefixSum[left] - width * height
        return intArrayOf(rect[0] + (target - base) % width, rect[1] + (target - base) / width)
    }
}
