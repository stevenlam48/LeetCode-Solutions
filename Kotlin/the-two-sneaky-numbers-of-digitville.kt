package thetwosneakynumbersofdigitville

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val n = nums.size - 2

        fun f(check: (Int) -> Boolean): Int {
            var result = 0
            for (x in nums) {
                if (check(x)) {
                    result = result xor x
                }
            }
            for (i in 0 until n) {
                if (check(i)) {
                    result = result xor i
                }
            }
            return result
        }

        val xXorY = f { true }
        val bit = xXorY and (-xXorY)
        return intArrayOf(f { (it and bit) == 0 }, f { (it and bit) != 0 })
    }
}
