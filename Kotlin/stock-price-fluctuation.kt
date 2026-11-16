package stockpricefluctuation

// Time:  ctor:    O(1)
//        update:  O(logn)
//        current: O(1)
//        max:     O(1)
//        min:     O(1)
// Space: O(n)

class StockPrice {
    private var curr = 0
    private val lookup = HashMap<Int, Int>()
    private val minBst = java.util.TreeMap<Int, Int>()

    fun update(timestamp: Int, price: Int) {
        if (timestamp > curr) {
            curr = timestamp
        }
        if (lookup.containsKey(timestamp)) {
            val old = lookup[timestamp]!!
            val c = minBst[old]!!
            if (c == 1) {
                minBst.remove(old)
            } else {
                minBst[old] = c - 1
            }
        }
        lookup[timestamp] = price
        minBst[price] = (minBst[price] ?: 0) + 1
    }

    fun current(): Int {
        return lookup[curr]!!
    }

    fun maximum(): Int {
        return minBst.lastKey()
    }

    fun minimum(): Int {
        return minBst.firstKey()
    }
}
