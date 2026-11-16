package fillingbookcaseshelves

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        val dp = IntArray(books.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1..books.size) {
            var max_width = shelf_width
            var max_height = 0
            for (j in i - 1 downTo 0) {
                if (max_width - books[j][0] < 0) {
                    break
                }
                max_width -= books[j][0]
                max_height = maxOf(max_height, books[j][1])
                dp[i] = minOf(dp[i], dp[j] + max_height)
            }
        }
        return dp[books.size]
    }
}
