package minimumoperationstoformsubsequencewithtargetsum

// Time:  O(n)
// Space: O(logn)

// codeforces, https://codeforces.com/problemset/problem/1303/D
// counting sort, greedy
class Solution {
    fun minOperations(nums: IntArray, target0: Int): Int {
        fun floorLog2(x: Int): Int {
            return 32 - Integer.numberOfLeadingZeros(x) - 1
        }

        var target = target0
        var total = 0L
        for (x in nums) {
            total += x
        }
        if (total < target) {
            return -1
        }
        val cnt = IntArray(floorLog2(nums.max()) + 1)
        for (x in nums) {
            ++cnt[floorLog2(x)]
        }
        var result = 0
        for (i in cnt.size - 1 downTo 0) {
            val x = 1 shl i
            repeat(cnt[i]) {
                if (x <= target) {
                    target -= x
                    total -= x
                } else if (total - x >= target) {
                    total -= x
                } else {
                    cnt[i - 1] += 2
                    ++result
                }
            }
        }
        return result
    }
}
