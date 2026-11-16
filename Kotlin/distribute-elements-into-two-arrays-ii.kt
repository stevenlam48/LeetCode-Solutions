package distributeelementsintotwoarraysii
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun resultArray(nums: IntArray): IntArray {
        val values = nums.distinct().sorted()
        val tree1 = FenwickTree(values.size)
        val tree2 = FenwickTree(values.size)
        val a = mutableListOf(nums[0])
        val b = mutableListOf(nums[1])
        tree1.add(rank(values, nums[0]), 1)
        tree2.add(rank(values, nums[1]), 1)
        for (i in 2 until nums.size) {
            val index = rank(values, nums[i])
            val cnt1 = tree1.sum() - tree1.sum(index + 1)
            val cnt2 = tree2.sum() - tree2.sum(index + 1)
            if (cnt1 > cnt2 || (cnt1 == cnt2 && a.size <= b.size)) {
                tree1.add(index, 1)
                a.add(nums[i])
            } else {
                tree2.add(index, 1)
                b.add(nums[i])
            }
        }
        a.addAll(b)
        return a.toIntArray()
    }

    private fun rank(values: List<Int>, value: Int): Int = values.binarySearch(value)

    private class FenwickTree(size: Int) {
        private val tree = IntArray(size + 1)

        fun add(index: Int, delta: Int) {
            var i = index + 1
            while (i < tree.size) {
                tree[i] += delta
                i += i and -i
            }
        }

        fun sum(end: Int = tree.size - 1): Int {
            var result = 0
            var i = end
            while (i > 0) {
                result += tree[i]
                i -= i and -i
            }
            return result
        }
    }
}
