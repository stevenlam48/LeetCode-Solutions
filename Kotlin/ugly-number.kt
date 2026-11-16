package uglynumber

// Time:  O(logn) = O(1)
// Space: O(1)

class Solution {
    fun isUgly(num: Int): Boolean {
        var num = num
        if (num == 0) {
            return false
        }
        for (i in intArrayOf(2, 3, 5)) {
            while (num % i == 0) {
                num /= i
            }
        }
        return num == 1
    }
}
