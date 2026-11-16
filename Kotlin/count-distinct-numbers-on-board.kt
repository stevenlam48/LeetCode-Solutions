package countdistinctnumbersonboard

// Time:  O(1)
// Space: O(1)

// math
class Solution {
    fun distinctIntegers(n: Int): Int {
        return if (n >= 2) n - 1 else 1
    }
}
