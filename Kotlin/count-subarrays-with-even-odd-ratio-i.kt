package countsubarrayswithevenoddratioi

// Time:  O(nlogn)
// Space: O(n)

// prefix sum, sort, coordinate compression, fenwick tree
class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i0: Int, v: Int) {
        var i = i0 + 1
        while (i < bit.size) {
            bit[i] += v
            i += i and -i
        }
    }

    fun query(i0: Int): Int {
        var i = i0 + 1
        var total = 0
        while (i > 0) {
            total += bit[i]
            i -= i and -i
        }
        return total
    }
}

class Solution {
    fun countRatioSubarrays(nums: IntArray, a: Int, b: Int): Int {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + if (nums[i] % 2 == 0) b else -a
        }
        val sortedNums = prefix.sorted().distinct()
        val valToIdx = HashMap<Int, Int>()
        for (i in sortedNums.indices) {
            valToIdx[sortedNums[i]] = i
        }
        val bit = BIT(valToIdx.size)
        var result = 0
        for (i in prefix.indices) {
            val idx = valToIdx[prefix[i]]!!
            result += i - bit.query(idx - 1)
            bit.add(idx, 1)
        }
        return result
    }
}
