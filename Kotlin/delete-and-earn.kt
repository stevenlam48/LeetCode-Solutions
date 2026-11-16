package deleteandearn

// Time:  O(n)
// Space: O(1)
class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val vals = IntArray(10001)
        for (num in nums) vals[num] += num
        var valI = vals[0]
        var valI1 = 0
        var valI2 = 0
        for (i in 1 until vals.size) {
            valI2 = valI1
            valI1 = valI
            valI = maxOf(vals[i] + valI2, valI1)
        }
        return valI
    }
}
