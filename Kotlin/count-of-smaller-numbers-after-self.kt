package countofsmallernumbersafterself

// Time:  O(nlogn)
// Space: O(n)

// BIT solution. (24ms)
class Solution {
    fun countSmaller(nums: IntArray): IntArray {
        val idx = (0 until nums.size).sortedWith(Comparator { a, b ->
            if (nums[a] == nums[b]) a.compareTo(b) else nums[a].compareTo(nums[b])
        }).toIntArray()
        val lookup = IntArray(nums.size)
        for (i in idx.indices) {
            lookup[idx[i]] = i
        }
        val bit = BIT(nums.size)
        val result = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
            result[i] = bit.query(lookup[i] - 1)
            bit.add(lookup[i], 1)
        }
        return result
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i0: Int, value: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] += value
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total += bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
