package maximumprofitofoperatingacentennialwheel

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {
        var maxRun = -1
        var i = 0
        var prof = 0
        var run = 1
        var waiting = 0
        var maxProf = 0
        while (i < customers.size || waiting > 0) {
            if (i < customers.size) {
                waiting += customers[i++]
            }
            val boarding = minOf(waiting, 4)
            waiting -= boarding
            prof += boarding * boardingCost - runningCost
            if (prof > maxProf) {
                maxProf = prof
                maxRun = run
            }
            ++run
        }
        return maxRun
    }
}
