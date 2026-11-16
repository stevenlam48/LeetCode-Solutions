package kitemswiththemaximumsum
// Time:  O(1)
// Space: O(1)

class Solution {
    fun kItemsWithMaximumSum(numOnes: Int, numZeros: Int, numNegOnes: Int, k: Int): Int {
        return minOf(numOnes, k) - maxOf(k - numOnes - numZeros, 0)
    }
}
