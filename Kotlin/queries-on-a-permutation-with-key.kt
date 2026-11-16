package queriesonapermutationwithkey

// Time:  O(nlogn)
// Space: O(n)

class BIT(n: Int) {  // Fenwick Tree, 1-indexed
    private val bit = IntArray(n)

    fun add(i0: Int, value: Int) {
        var i = i0
        while (i < bit.size) {
            bit[i] += value
            i += lowerBit(i)
        }
    }

    fun sum(i0: Int): Int {
        var i = i0
        var sum = 0
        while (i > 0) {
            sum += bit[i]
            i -= lowerBit(i)
        }
        return sum
    }

    fun lowerBit(i: Int): Int {
        return i and -i
    }
}

class Solution {
    fun processQueries(queries: IntArray, m: Int): IntArray {
        val bit = BIT(2 * m + 1)
        val lookup = HashMap<Int, Int>()
        for (i in 1..m) {
            lookup[i] = m + i
            bit.add(m + i, 1)
        }
        val result = mutableListOf<Int>()
        var curr = m
        for (q in queries) {
            val i = lookup[q]!!
            lookup.remove(q)
            result.add(bit.sum(i - 1))
            bit.add(i, -1)
            lookup[q] = curr
            bit.add(curr--, 1)
        }
        return result.toIntArray()
    }
}
