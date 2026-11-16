package grumpybookstoreowner

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, X: Int): Int {
        var result = 0
        var maxExtra = 0
        var extra = 0
        for (i in customers.indices) {
            result += if (grumpy[i] != 0) 0 else customers[i]
            extra += if (grumpy[i] != 0) customers[i] else 0
            if (i >= X) {
                extra -= if (grumpy[i - X] != 0) customers[i - X] else 0
            }
            maxExtra = maxOf(maxExtra, extra)
        }
        return result + maxExtra
    }
}
