package sequentialdigits

// Time:  O((8 + 1) * 8 / 2) = O(1)
// Space: O(8) = O(1)

class Solution {
    fun sequentialDigits(low: Int, high: Int): IntArray {
        val result = ArrayList<Int>()
        val q = ArrayDeque<Int>()
        for (i in 1..8) {
            q.addLast(i)
        }
        while (q.isNotEmpty()) {
            val num = q.removeFirst()
            if (num > high) {
                continue
            }
            if (low <= num) {
                result.add(num)
            }
            if (num % 10 + 1 < 10) {
                q.addLast(num * 10 + num % 10 + 1)
            }
        }
        return result.toIntArray()
    }
}
