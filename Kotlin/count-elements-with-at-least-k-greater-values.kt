package countelementswithatleastkgreatervalues

// Time:  O(n)
// Space: O(1)

// quick select
class Solution {
    fun countElements(nums: IntArray, k: Int): Int {
        if (k == 0) {
            return nums.size
        }
        nthElement(nums, nums.size - k)
        val v = nums[nums.size - k]
        var result = 0
        for (x in nums) {
            if (x < v) {
                ++result
            }
        }
        return result
    }

    private fun nthElement(a: IntArray, k: Int) {
        var lo = 0
        var hi = a.size - 1
        while (lo < hi) {
            val pivot = a[(lo + hi) ushr 1]
            var lt = lo
            var i = lo
            var gt = hi
            while (i <= gt) {
                val v = a[i]
                when {
                    v < pivot -> {
                        a[i] = a[lt]
                        a[lt] = v
                        ++lt
                        ++i
                    }
                    v > pivot -> {
                        a[i] = a[gt]
                        a[gt] = v
                        --gt
                    }
                    else -> ++i
                }
            }
            if (k < lt) {
                hi = lt - 1
            } else if (k > gt) {
                lo = gt + 1
            } else {
                return
            }
        }
    }
}
