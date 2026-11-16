package happynumber

// Time:  O(k), where k is the steps to be happy number
// Space: O(k)
class Solution {
    fun isHappy(n: Int): Boolean {
        var current = n
        val visited = HashSet<Int>()
        while (current != 1 && !visited.contains(current)) {
            visited.add(current)
            current = nextNumber(current)
        }
        return current == 1
    }

    fun nextNumber(n: Int): Int {
        var current = n
        var sum = 0
        while (current != 0) {
            val digit = current % 10
            sum += digit * digit
            current /= 10
        }
        return sum
    }
}
