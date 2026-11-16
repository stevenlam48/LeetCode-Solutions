package shoppingoffers

// Time:  O(n * 2^n)
// Space: O(n)

class Solution {
    fun shoppingOffers(price: IntArray, special: Array<IntArray>, needs: IntArray): Int {
        return shoppingOffersHelper(price, special, needs, 0)
    }

    private fun shoppingOffersHelper(
        price: IntArray,
        special: Array<IntArray>,
        needs: IntArray,
        i: Int
    ): Int {
        if (i == special.size) {
            var result = 0
            for (j in price.indices) {
                result += price[j] * needs[j]
            }
            return result
        }
        var result = shoppingOffersHelper(price, special, needs, i + 1)
        for (j in needs.indices) {
            needs[j] -= special[i][j]
        }
        if (needs.all { it >= 0 }) {
            result = minOf(
                result,
                special[i].last() + shoppingOffersHelper(price, special, needs, i)
            )
        }
        for (j in needs.indices) {
            needs[j] += special[i][j]
        }
        return result
    }
}
