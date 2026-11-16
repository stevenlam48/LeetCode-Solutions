package numberofsingledivisortriplets

// Time:  O(d^3), d is the number of distinct nums
// Space: O(d)

// combinatorics
class Solution {
    fun singleDivisorTriplet(nums: IntArray): Long {
        fun check(a: Int, b: Int, c: Int): Boolean {
            val total = a + b + c
            val divisors = (if (total % a == 0) 1 else 0) +
                (if (total % b == 0) 1 else 0) +
                (if (total % c == 0) 1 else 0)
            return divisors == 1
        }

        val cnt = HashMap<Int, Long>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0L) + 1
        }
        val uniqueNums = cnt.keys.toList()
        var result: Long = 0
        for (i in uniqueNums.indices) {
            for (j in i + 1 until uniqueNums.size) {
                for (k in j + 1 until uniqueNums.size) {
                    if (check(uniqueNums[i], uniqueNums[j], uniqueNums[k])) {
                        result += cnt[uniqueNums[i]]!! * cnt[uniqueNums[j]]!! * cnt[uniqueNums[k]]!!
                    }
                }
            }
        }
        for (i in uniqueNums.indices) {
            for (j in uniqueNums.indices) {
                if (check(uniqueNums[i], uniqueNums[i], uniqueNums[j])) {
                    result += cnt[uniqueNums[i]]!! * (cnt[uniqueNums[i]]!! - 1) / 2 * cnt[uniqueNums[j]]!!
                }
            }
        }
        return result * 6
    }
}
