package rotatenonnegativeelements

// Time:  O(n)
// Space: O(n)

// array
class Solution {
    fun rotateElements(nums: IntArray, k: Int): IntArray {
        val result = ArrayList<Int>()
        for (x in nums) {
            if (x >= 0) {
                result.add(x)
            }
        }
        if (result.isEmpty()) {
            return nums
        }
        rotate(result, k)
        var j = 0
        for (i in nums.indices) {
            if (nums[i] < 0) {
                continue
            }
            nums[i] = result[j++]
        }
        return nums
    }

    private fun rotate(nums: MutableList<Int>, k0: Int) {
        val n = nums.size
        val k = k0 % n
        val c = gcd(n, k)
        for (i in 0 until c) {
            for (j in 1 until n / c) {
                val idx = (((i - j.toLong() * k) % n + n) % n).toInt()
                val tmp = nums[i]
                nums[i] = nums[idx]
                nums[idx] = tmp
            }
        }
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
