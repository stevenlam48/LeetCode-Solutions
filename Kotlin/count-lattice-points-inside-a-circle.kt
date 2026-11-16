package countlatticepointsinsideacircle

// Time:  O(n * r^2)
// Space: O(min(n * r^2, max_x * max_y))

// math, hash table
class Solution {
    fun countLatticePoints(circles: Array<IntArray>): Int {
        var maxY = 0
        for (circle in circles) {
            maxY = maxOf(maxY, circle[1] + circle[2])
        }
        val lookup = HashSet<Int>()
        for (circle in circles) {
            for (i in -circle[2]..circle[2]) {
                for (j in -circle[2]..circle[2]) {
                    if (i * i + j * j <= circle[2] * circle[2]) {
                        lookup.add((circle[0] + i) * (maxY + 1) + (circle[1] + j))
                    }
                }
            }
        }
        return lookup.size
    }
}
