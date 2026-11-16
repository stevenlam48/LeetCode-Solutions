package lastremainingintegerafteralternatingdeletionoperations

// Time:  O(1)
// Space: O(1)

class Solution {
    fun lastInteger(n: Long): Long {
        return ((n - 1) and MASK) + 1
    }

    companion object {
        private const val MASK = 0xAAAAAAAAAAAAAAL
    }
}
