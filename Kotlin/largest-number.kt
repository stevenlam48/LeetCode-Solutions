package largestnumber

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun largestNumber(nums: IntArray): String {
        val sorted = nums.sortedWith(Comparator { i, j ->
            (j.toString() + i.toString()).compareTo(i.toString() + j.toString())
        })

        val maxNum = StringBuilder()
        for (i in sorted) {
            maxNum.append(i.toString())
        }

        if (maxNum.isNotEmpty() && maxNum[0] == '0') {
            return "0"
        }

        return maxNum.toString()
    }
}
