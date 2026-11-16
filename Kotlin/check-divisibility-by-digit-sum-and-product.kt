package checkdivisibilitybydigitsumandproduct

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun checkDivisibility(n: Int): Boolean {
        var total = 0
        var product = 1
        var curr = n
        while (curr != 0) {
            total += curr % 10
            product *= curr % 10
            curr /= 10
        }
        return n % (total + product) == 0
    }
}
