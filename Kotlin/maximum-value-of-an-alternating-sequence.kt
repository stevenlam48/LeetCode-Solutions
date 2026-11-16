package maximumvalueofanalternatingsequence

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maximumValue(n: Int, s: Int, m: Int): Long {
        return s + (n / 2L) * m - ((n - 1) / 2L) + (if (n != 1) n % 2 else 0)
    }
}
