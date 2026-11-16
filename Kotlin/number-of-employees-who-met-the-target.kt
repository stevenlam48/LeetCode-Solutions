package numberofemployeeswhometthetarget

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
        var result = 0
        for (x in hours) {
            if (x >= target) {
                ++result
            }
        }
        return result
    }
}
