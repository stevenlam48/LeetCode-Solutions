package rangesumqueryimmutable
// Time:  ctor:   O(n),
//        lookup: O(1)
// Space: O(n)
class NumArray(nums: IntArray) {
    private val accu = IntArray(nums.size + 1)

    init {
        for (i in nums.indices) {
            accu[i + 1] = accu[i] + nums[i]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return accu[j + 1] - accu[i]
    }
}
