package subtracttheproductandsumofdigitsofaninteger

// Time:  O(n)
// Space: O(1)
class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var value = n
        var product = 1
        var total = 0
        while (value != 0) {
            product *= value % 10
            total += value % 10
            value /= 10
        }
        return product - total
    }
}
