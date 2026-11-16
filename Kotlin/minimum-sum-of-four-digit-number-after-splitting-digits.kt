package minimumsumoffourdigitnumberaftersplittingdigits

// Time:  O(d) = O(1), d is the number of digits
// Space: O(d) = O(1)

class Solution {
    fun minimumSum(num: Int): Int {
        var value = num
        val nums = mutableListOf<Int>()
        while (value != 0) {
            nums.add(value % 10)
            value /= 10
        }
        inplaceCountingSort(nums, false)
        var a = 0
        var b = 0
        for (x in nums) {
            a = a * 10 + x
            val temp = a
            a = b
            b = temp
        }
        return a + b
    }

    private fun inplaceCountingSort(nums: MutableList<Int>, isReverse: Boolean) {
        val maxNum = nums.max()
        val count = IntArray(maxNum + 1)
        for (num in nums) {
            ++count[num]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        for (i in nums.size - 1 downTo 0) {
            while (nums[i] >= 0) {
                val num = nums[i]
                --count[num]
                val j = count[num]
                nums[i] = nums[j]
                nums[j] = num.inv()
            }
        }
        for (i in nums.indices) {
            nums[i] = nums[i].inv()
        }
        if (isReverse) {
            nums.reverse()
        }
    }
}
