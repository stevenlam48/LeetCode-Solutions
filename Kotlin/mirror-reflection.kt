package mirrorreflection

// Time:  O(1)
// Space: O(1)

class Solution {
    fun mirrorReflection(p: Int, q: Int): Int {
        // explanation commented in the following solution
        return if ((p and -p) > (q and -q)) 2 else if ((p and -p) < (q and -q)) 0 else 1
    }
}
