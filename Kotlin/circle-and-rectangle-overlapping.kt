package circleandrectangleoverlapping

// Time:  O(1)
// Space: O(1)

class Solution {
    fun checkOverlap(
        radius: Int,
        xCenter: Int,
        yCenter: Int,
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int
    ): Boolean {
        val left = x1 - xCenter
        val bottom = y1 - yCenter
        val right = x2 - xCenter
        val top = y2 - yCenter
        val x = if (left > 0) left else if (right < 0) right else 0
        val y = if (bottom > 0) bottom else if (top < 0) top else 0
        return x * x + y * y <= radius * radius
    }
}
