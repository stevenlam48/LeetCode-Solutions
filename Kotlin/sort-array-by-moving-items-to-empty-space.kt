package sortarraybymovingitemstoemptyspace

// Time:  O(n)
// Space: O(n)

class Solution {
    fun sortArray(nums: IntArray): Int {
        fun index(x: Int, d: Int): Int {
            return if (x == 0) d * (nums.size - 1) else x - d
        }

        fun minMoves(d: Int): Int {
            val lookup = BooleanArray(nums.size)
            var result = nums.size
            var i = 0
            while (i < nums.size) {
                if (!lookup[nums[i]]) {
                    var l = 0
                    while (!lookup[nums[i]]) {
                        lookup[nums[i]] = true
                        ++l
                        i = index(nums[i], d)
                    }
                    --result
                    if (l >= 2) {
                        result += 2
                    }
                }
                ++i
            }
            return result - 2 * (if (nums[d * (nums.size - 1)] != 0) 1 else 0)
        }

        return minOf(minMoves(0), minMoves(1))
    }
}
