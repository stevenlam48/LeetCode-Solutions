package threedivisors
// Time:  O(sqrt(n))
// Space: O(1)

class Solution {
    fun isThree(n: Int): Boolean {
        var count = 0
        var i = 1
        while (i <= n / i && count <= 3) {
            if (n % i == 0) {
                count += if (i == n / i) 1 else 2
            }
            ++i
        }
        return count == 3
    }
}
