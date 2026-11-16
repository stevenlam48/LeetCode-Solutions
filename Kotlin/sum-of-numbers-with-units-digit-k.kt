package sumofnumberswithunitsdigitk

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minimumNumbers(num: Int, k: Int): Int {
        if (num == 0) {
            return 0
        }
        val d = if (k != 0) minOf(num / k, 10) else 1
        for (i in 1..d) {
            if ((num - i * k) % 10 == 0) {
                return i
            }
        }
        return -1
    }
}
