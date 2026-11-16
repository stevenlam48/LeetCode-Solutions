package countgoodtripletsinanarray

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun goodTriplets(nums1: IntArray, nums2: IntArray): Long {
        val lookup = HashMap<Int, Int>()
        for (i in nums1.indices) {
            lookup[nums1[i]] = i
        }
        var result = 0L
        val bit = BIT(nums1.size)
        for (i in nums2.indices) {
            val index = lookup[nums2[i]]!!
            val smaller = bit.query(index - 1).toLong()
            val larger = (nums1.size - (index + 1)) - (i - smaller)
            result += smaller * larger
            bit.add(index, 1)
        }
        return result
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(index: Int, value: Int) {
            var i = index + 1
            while (i < bit.size) {
                bit[i] += value
                i += i and -i
            }
        }

        fun query(index: Int): Int {
            var i = index + 1
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
