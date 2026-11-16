package destroyingasteroids

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var m = mass
        for (x in asteroids) {
            if (x > m) {
                return false
            }
            m += minOf(x, asteroids.last() - m)
        }
        return true
    }
}
