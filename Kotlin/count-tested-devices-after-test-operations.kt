package counttesteddevicesaftertestoperations

// Time:  O(n)
// Space: O(1)

// simulation
class Solution {
    fun countTestedDevices(batteryPercentages: IntArray): Int {
        var result = 0
        for (x in batteryPercentages) {
            if (x > result) {
                ++result
            }
        }
        return result
    }
}
