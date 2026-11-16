package findthesumofencryptedintegers

// Time:  O(nlogr)
// Space: O(1)

// array
class Solution {
    fun sumOfEncryptedInt(nums: IntArray): Int {
        fun f(x0: Int): Int {
            var x = x0
            var mx = 0
            var base = 0
            while (x != 0) {
                mx = maxOf(mx, x % 10)
                x /= 10
                base = 10 * base + 1
            }
            return mx * base
        }

        var result = 0
        for (x in nums) {
            result += f(x)
        }
        return result
    }
}
