package applydiscounteverynorders

// Time:  ctor:    O(m), m is the number of all products
//        getBill: O(p), p is the number of products to bill
// Space: O(m)

class Cashier(
    private val n: Int,
    private val discount: Int,
    products: IntArray,
    prices: IntArray
) {
    private var curr = 0
    private val lookup = HashMap<Int, Int>()

    init {
        for (i in products.indices) {
            lookup[products[i]] = prices[i]
        }
    }

    fun getBill(product: IntArray, amount: IntArray): Double {
        curr = (curr + 1) % n
        var result = 0.0
        for (i in product.indices) {
            result += lookup.getValue(product[i]) * amount[i]
        }
        return if (curr == 0) result * (1.0 - discount / 100.0) else result
    }
}
