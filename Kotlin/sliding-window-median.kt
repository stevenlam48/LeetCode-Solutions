package slidingwindowmedian

// Time:  O(nlogk)
// Space: O(k)

class Solution {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val sorted = nums.distinct().sorted()
        val index = HashMap<Int, Int>()
        for (i in sorted.indices) {
            index[sorted[i]] = i
        }
        val bit = IntArray(sorted.size + 1)

        fun add(i: Int, delta: Int) {
            var p = i + 1
            while (p < bit.size) {
                bit[p] += delta
                p += p and -p
            }
        }

        fun kth(rank: Int): Int {
            var pos = 0
            var remaining = rank + 1
            var step = Integer.highestOneBit(bit.size - 1)
            while (step > 0) {
                if (pos + step < bit.size && bit[pos + step] < remaining) {
                    pos += step
                    remaining -= bit[pos]
                }
                step = step shr 1
            }
            return sorted[pos]
        }

        for (i in 0 until k) {
            add(index[nums[i]]!!, 1)
        }
        val result = ArrayList<Double>()
        val upper = k / 2
        val lower = upper - (1 - k % 2)
        result.add((kth(upper) + kth(lower)) / 2.0)
        for (i in k until nums.size) {
            add(index[nums[i]]!!, 1)
            add(index[nums[i - k]]!!, -1)
            result.add((kth(upper) + kth(lower)) / 2.0)
        }
        return result.toDoubleArray()
    }
}
