package minimumpossibleintegerafteratmostkadjacentswapsondigits
// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = IntArray(n)

    fun add(i: Int, value: Int) {
        var index = i
        while (index < bit.size) {
            bit[index] += value
            index += lowerBit(index)
        }
    }

    fun sum(i: Int): Int {
        var index = i
        var result = 0
        while (index > 0) {
            result += bit[index]
            index -= lowerBit(index)
        }
        return result
    }

    private fun lowerBit(i: Int): Int = i and -i
}

class Solution {
    fun minInteger(num: String, k: Int): String {
        var remaining = k
        val lookup = HashMap<Int, MutableList<Int>>()
        val bit = BIT(num.length + 1)
        for (i in num.indices.reversed()) {
            lookup.getOrPut(num[i] - '0') { ArrayList() }.add(i + 1)
            bit.add(i + 1, 1)
        }
        val result = StringBuilder()
        for (i in num.indices) {
            for (d in 0..9) {
                val positions = lookup[d]
                if (!positions.isNullOrEmpty() && bit.sum(positions.last() - 1) <= remaining) {
                    remaining -= bit.sum(positions.last() - 1)
                    bit.add(positions.last(), -1)
                    positions.removeAt(positions.lastIndex)
                    result.append('0' + d)
                    break
                }
            }
        }
        return result.toString()
    }
}
