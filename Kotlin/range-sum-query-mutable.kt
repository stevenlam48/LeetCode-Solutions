package rangesumquerymutable
// Time:  ctor:   O(n),
//        update: O(logn),
//        query:  O(logn)
// Space: O(n)
class NumArray(private val nums: IntArray) {
    private val bit = IntArray(nums.size + 1)

    init {
        for (i in 1 until bit.size) {
            bit[i] = nums[i - 1] + bit[i - 1]
        }
        for (i in bit.size - 1 downTo 1) {
            val lastI = i - lowerBit(i)
            bit[i] -= bit[lastI]
        }
    }

    fun update(i: Int, `val`: Int) {
        if (`val` - nums[i] != 0) {
            add(i, `val` - nums[i])
            nums[i] = `val`
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sum(j) - sum(i - 1)
    }

    private fun sum(i: Int): Int {
        var index = i + 1
        var result = 0
        while (index > 0) {
            result += bit[index]
            index -= lowerBit(index)
        }
        return result
    }

    private fun add(i: Int, `val`: Int) {
        var index = i + 1
        while (index <= nums.size) {
            bit[index] += `val`
            index += lowerBit(index)
        }
    }

    private fun lowerBit(i: Int): Int = i and -i
}
