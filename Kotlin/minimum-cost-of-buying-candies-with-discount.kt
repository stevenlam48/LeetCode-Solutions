package minimumcostofbuyingcandieswithdiscount

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumCost(cost: IntArray): Int {
        cost.sortDescending()
        var result = 0
        for (i in cost.indices) {
            if (i % 3 == 2) {
                continue
            }
            result += cost[i]
        }
        return result
    }
}
