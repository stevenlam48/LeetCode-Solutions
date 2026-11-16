package numberofbitchangestomaketwointegersequal

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minChanges(n: Int, k: Int): Int {
        return if ((n and k) == k) Integer.bitCount(n xor k) else -1
    }
}
