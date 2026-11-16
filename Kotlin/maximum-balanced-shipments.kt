package maximumbalancedshipments

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxBalancedShipments(weight: IntArray): Int {
        var result = 0
        var mx = 0
        for (x in weight) {
            if (x < mx) {
                mx = 0
                ++result
            } else {
                mx = x
            }
        }
        return result
    }
}
