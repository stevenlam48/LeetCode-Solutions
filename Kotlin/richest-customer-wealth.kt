package richestcustomerwealth
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var result = 0
        for (account in accounts) {
            var total = 0
            for (amount in account) total += amount
            result = maxOf(result, total)
        }
        return result
    }
}
