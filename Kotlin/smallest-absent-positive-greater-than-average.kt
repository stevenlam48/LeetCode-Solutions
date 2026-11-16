package smallestabsentpositivegreaterthanaverage

// Time:  O(n)
// Space: O(n)

class Solution {
    fun smallestAbsent(nums: IntArray): Int {
        val floorDivide = { a: Int, b: Int ->
            val q = a / b
            val r = a % b
            q - (if (r != 0 && (a > 0) != (b > 0)) 1 else 0)
        }

        val total = nums.sum()
        val lookup = nums.toHashSet()
        var i = maxOf(floorDivide(total, nums.size) + 1, 1)
        val limit = maxOf(nums.max() + 1, 1)
        while (i <= limit) {
            if (!lookup.contains(i) && nums.size * i > total) {
                break
            }
            ++i
        }
        return i
    }
}
