package asteroidcollision

// Time:  O(n)
// Space: O(n)

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (x in asteroids) {
            if (x > 0) {
                result.add(x)
            }
            while (result.isNotEmpty() && 0 < result.last() && result.last() < -x) {
                result.removeAt(result.size - 1)
            }
            if (result.isNotEmpty() && 0 < result.last()) {
                if (result.last() == -x) {
                    result.removeAt(result.size - 1)
                }
                continue
            }
            result.add(x)
        }
        return result.toIntArray()
    }
}
