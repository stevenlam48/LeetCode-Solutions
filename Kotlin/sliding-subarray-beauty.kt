package slidingsubarraybeauty

// Time:  O(nlogk)
// Space: O(k)

class Solution {
    fun getSubarrayBeauty(nums: IntArray, k: Int, x: Int): IntArray {
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

        fun kth(order: Int): Int {
            var pos = 0
            var remaining = order
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

        val result = ArrayList<Int>()
        for (i in nums.indices) {
            if (i - k >= 0) {
                add(index[nums[i - k]]!!, -1)
            }
            add(index[nums[i]]!!, 1)
            if (i - k + 1 >= 0) {
                result.add(minOf(kth(x), 0))
            }
        }
        return result.toIntArray()
    }
}
