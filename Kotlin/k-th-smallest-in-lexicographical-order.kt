package kthsmallestinlexicographicalorder

// Time:  O(logn)
// Space: O(logn)

class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var k = k
        var result = 0

        val cnts = IntArray(11)
        for (i in 1..9) {
            cnts[i] = cnts[i - 1] * 10 + 1
        }

        val nums = ArrayList<Int>()
        var x = n
        while (x > 0) {
            nums.add(x % 10)
            x /= 10
        }
        var total = n
        var target = 0
        for (i in nums.size - 1 downTo 0) {
            if (k == 0) {
                break
            }
            target = target * 10 + nums[i]
            val start = if (i == nums.size - 1) 1 else 0
            for (j in start..9) {
                val candidate = result * 10 + j
                val num: Int
                if (candidate < target) {
                    num = cnts[i + 1]
                } else if (candidate > target) {
                    num = cnts[i]
                } else {
                    num = total - cnts[i + 1] * (j - start) - cnts[i] * (9 - j)
                }
                if (k > num) {
                    k -= num
                } else {
                    result = candidate
                    --k
                    total = num - 1
                    break
                }
            }
        }
        return result
    }
}
