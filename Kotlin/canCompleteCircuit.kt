package canCompleteCircuit

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var total = 0
        var sum = 0
        var j = -1

        for (i in gas.indices) {
            total += gas[i] - cost[i]
            sum += gas[i] - cost[i]
            if (sum < 0) { // find the gas station which should be the last one
                sum = 0
                j = i
            }
        }

        return if (total >= 0) j + 1 else -1
    }
}
