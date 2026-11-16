package collectingchocolates

// Time:  O(n)
// Space: O(n)


class Solution {
    fun minCost(nums: IntArray, x: Int): Long {
        val n = nums.size
        var minIdx = 0
        for (i in 1 until n) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i
            }
        }
        val rotated = IntArray(n) { nums[(minIdx + it) % n] }
        val left = IntArray(n) { -1 }
        val right = IntArray(n) { n }
        val stk = ArrayList<Int>()
        for (i in 0 until n) {
            while (stk.isNotEmpty() && rotated[stk.last()] > rotated[i]) {
                right[stk.last()] = i
                stk.removeAt(stk.size - 1)
            }
            if (stk.isNotEmpty()) {
                left[i] = stk.last()
            }
            stk.add(i)
        }
        val diff2 = LongArray(n + 1)
        diff2[0] = rotated.sumOf { it.toLong() }
        diff2[1] = x.toLong()
        diff2[n] += -rotated[0].toLong()
        for (i in 1 until n) {
            val l = i - left[i]
            val r = right[i] - i
            diff2[minOf(l, r)] -= rotated[i].toLong()
            diff2[maxOf(l, r)] -= rotated[i].toLong()
            diff2[l + r] += rotated[i].toLong()
        }
        val diff1 = LongArray(n + 1)
        var acc = 0L
        for (i in diff2.indices) {
            acc += diff2[i]
            diff1[i] = acc
        }
        var result = 0L
        var best = Long.MAX_VALUE
        for (i in diff1.indices) {
            result += diff1[i]
            best = minOf(best, result)
        }
        return best
    }
}
