package minimumcutstodivideacircle

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numberOfCuts(n: Int): Int {
        return if (n == 1) 0 else if (n % 2 != 0) n else n / 2
    }
}
