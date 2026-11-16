package frequencybalancesubarray

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun getLength(nums: IntArray): Int {
        val sortedVals = nums.sorted().distinct()
        val valToIdx = HashMap<Int, Int>()
        for (i in sortedVals.indices) {
            valToIdx[sortedVals[i]] = i
        }
        val arr = IntArray(nums.size)
        for (i in nums.indices) {
            arr[i] = valToIdx.getValue(nums[i])
        }

        var result = 0
        for (left in arr.indices) {
            val cnt = IntArray(arr.size)
            val cnt2 = IntArray(arr.size + 1)
            var distinct = 0
            var total = 0
            var c = 0
            for (right in left until arr.size) {
                val value = arr[right]
                if (cnt[value] != 0) {
                    cnt2[cnt[value]]--
                    if (cnt2[cnt[value]] == 0) {
                        c--
                        total -= cnt[value]
                    }
                }
                cnt[value]++
                if (cnt[value] == 1) {
                    distinct++
                }
                cnt2[cnt[value]]++
                if (cnt2[cnt[value]] == 1) {
                    total += cnt[value]
                    c++
                }
                if (distinct == 1 || (c == 2 && total % 3 == 0 && cnt2[total / 3] != 0)) {
                    result = maxOf(result, right - left + 1)
                }
            }
        }
        return result
    }
}
