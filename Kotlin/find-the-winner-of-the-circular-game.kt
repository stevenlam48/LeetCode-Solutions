package findthewinnerofthecirculargame

// Time:  O(n)
// Space: O(1)

// bottom-up solution
class Solution {
    fun findTheWinner(n: Int, k: Int): Int {
        var idx = 0
        for (i in 1 until n) {
            idx = (idx + k) % (i + 1)
        }
        return idx + 1
    }
}
