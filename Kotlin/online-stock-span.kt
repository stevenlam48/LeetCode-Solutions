package onlinestockspan

// Time:  O(n)
// Space: O(n)

class StockSpanner {
    private val s = ArrayDeque<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var result = 1
        while (s.isNotEmpty() && s.last().first <= price) {
            result += s.last().second
            s.removeLast()
        }
        s.addLast(price to result)
        return result
    }
}
