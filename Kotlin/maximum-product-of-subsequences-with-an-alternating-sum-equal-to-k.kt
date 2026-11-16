package maximumproductofsubsequenceswithanalternatingsumequaltok

// Time:  O(n * k * l), l = limits
// Space: O(n * k * l)

// dp
class Solution {
    fun maxProduct(nums: IntArray, k: Int, limit: Int): Int {
        val total = nums.sumOf { it.toLong() }
        if (k.toLong() > total || k.toLong() < -total) {
            return -1
        }
        var dp = HashMap<Int, HashMap<Int, HashSet<Int>>>()
        for (x in nums) {
            val newDp = HashMap<Int, HashMap<Int, HashSet<Int>>>()
            for ((p, totalProducts) in dp) {
                for ((t, products) in totalProducts) {
                    newDp.getOrPut(p) { HashMap() }[t] = HashSet(products)
                }
            }
            newDp.getOrPut(1) { HashMap() }.getOrPut(x) { HashSet() }.add(minOf(x, limit + 1))
            for ((p, totalProducts) in dp) {
                val newP = p xor 1
                val v = if (p == 0) x else -x
                for ((t, products) in totalProducts) {
                    val newTotal = t + v
                    val dest = newDp.getOrPut(newP) { HashMap() }.getOrPut(newTotal) { HashSet() }
                    for (product in products) {
                        dest.add(minOf(product * x, limit + 1))
                    }
                }
            }
            dp = newDp
        }
        var result = -1
        for ((_, totalProducts) in dp) {
            for ((t, products) in totalProducts) {
                if (t != k) {
                    continue
                }
                for (v in products) {
                    if (v <= limit) {
                        result = maxOf(result, v)
                    }
                }
            }
        }
        return result
    }
}
