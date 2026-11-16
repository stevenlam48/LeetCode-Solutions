package maximumnumberofbooksyoucantake

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumBooks(books: IntArray): Long {
        fun count(right: Long, l: Long): Long {
            val left = maxOf(right - l + 1, 0L)
            return (left + right) * (right - left + 1) / 2
        }

        var result = 0L
        val stk = ArrayDeque<Int>()
        stk.addLast(-1)
        var curr = 0L
        for (i in books.indices) {
            while (stk.last() != -1 && books[stk.last()] >= books[i] - (i - stk.last())) {
                val j = stk.removeLast()
                curr -= count(books[j].toLong(), (j - stk.last()).toLong())
            }
            curr += count(books[i].toLong(), (i - stk.last()).toLong())
            stk.addLast(i)
            result = maxOf(result, curr)
        }
        return result
    }
}
