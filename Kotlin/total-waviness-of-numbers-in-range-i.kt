package totalwavinessofnumbersinrangei

// Time:  O(nlogn)
// Space: O(logn)

class Solution {
    fun totalWaviness(num1: Int, num2: Int): Int {
        var result = 0
        for (i in num1..num2) {
            val s = i.toString()
            for (j in 1 until s.length - 1) {
                if ((s[j - 1] < s[j] && s[j] > s[j + 1]) ||
                    (s[j - 1] > s[j] && s[j] < s[j + 1])
                ) {
                    ++result
                }
            }
        }
        return result
    }
}
