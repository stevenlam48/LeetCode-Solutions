package maximizescoreofnumbersinranges
// Time:  O(nlogn + nlogr) = O(nlogr)
// Space: O(1)

class Solution {
    fun maxPossibleScore(start: IntArray, d: Int): Int {
        start.sort()
        var left = 1
        var right = (start.last() + d) - start.first()
        while (left <= right) {
            val mid = left + (right - left) / 2
            var curr = start[0].toLong()
            var valid = true
            for (i in 1 until start.size) {
                curr = maxOf(curr + mid, start[i].toLong())
                if (curr > start[i] + d) {
                    valid = false
                    break
                }
            }
            if (!valid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}
