package minimumnumberofoperationstohavedistinctelements

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun minOperations(nums: IntArray): Int {
        val l = 3
        fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

        val lookup = HashSet<Int>()
        var n = nums.size
        while (n > 0) {
            if (!lookup.add(nums[n - 1])) {
                break
            }
            --n
        }
        return ceilDivide(n, l)
    }
}
