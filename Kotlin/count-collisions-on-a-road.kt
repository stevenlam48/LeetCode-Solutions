package countcollisionsonaroad

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countCollisions(directions: String): Int {
        var result = 0
        var cnt = 0
        var smooth = true
        for (x in directions) {
            if (x == 'R') {
                ++cnt
            } else if (x == 'S' || cnt != 0 || !smooth) {
                result += cnt + if (x == 'L') 1 else 0
                cnt = 0
                smooth = false
            }
        }
        return result
    }
}
