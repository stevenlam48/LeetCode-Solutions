package appleredistributionintoboxes

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        capacity.sortDescending()
        var total = apple.sum()
        for (i in capacity.indices) {
            total -= capacity[i]
            if (total <= 0) {
                return i + 1
            }
        }
        return -1
    }
}
