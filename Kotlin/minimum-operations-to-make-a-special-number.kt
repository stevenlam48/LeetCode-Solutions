package minimumoperationstomakeaspecialnumber

// Time:  O(n)
// Space; O(1)

class Solution {
    fun minimumOperations(num: String): Int {
        val target1 = "05"
        val target2 = "27"

        val lookup = IntArray(10)
        for (i in num.length - 1 downTo 0) {
            if ((num[i] in target1 && lookup[0] != 0) ||
                (num[i] in target2 && lookup[5] != 0)
            ) {
                return num.length - i - 2
            }
            lookup[num[i] - '0'] = 1
        }
        return num.length - lookup[0]
    }
}
