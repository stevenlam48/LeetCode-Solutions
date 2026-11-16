package splitwithminimumsum

// Time:  O(mlogm), m = O(logn)
// Space: O(m)

class Solution {
    fun splitNum(num: Int): Int {
        var number = num
        val sortedNum = mutableListOf<Int>()
        while (number != 0) {
            sortedNum.add(number % 10)
            number /= 10
        }
        sortedNum.sort()
        var result = 0
        for (i in sortedNum.indices) {
            if (i % 2 == sortedNum.size % 2) {
                result *= 10
            }
            result += sortedNum[i]
        }
        return result
    }
}
