package determinethewinnerofabowlinggame

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isWinner(player1: IntArray, player2: IntArray): Int {
        fun score(arr: IntArray): Int {
            var result = 0
            var count = 0
            for (i in arr.indices) {
                result += if (count != 0) 2 * arr[i] else arr[i]
                if (arr[i] == 10) {
                    ++count
                }
                if (i - 2 >= 0 && arr[i - 2] == 10) {
                    --count
                }
            }
            return result
        }

        val a = score(player1)
        val b = score(player2)
        return if (a > b) 1 else if (a < b) 2 else 0
    }
}
