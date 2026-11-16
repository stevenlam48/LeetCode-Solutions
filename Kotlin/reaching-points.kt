package reachingpoints
// Time:  O(log(max(m, n)))
// Space: O(1)
class Solution {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        var startX = sx
        var startY = sy
        var targetX = tx
        var targetY = ty
        while (targetX >= startX && targetY >= startY) {
            if (targetX < targetY) {
                startX = startY.also { startY = startX }
                targetX = targetY.also { targetY = targetX }
            }
            if (targetY > startY) {
                targetX %= targetY
            } else {
                return (targetX - startX) % targetY == 0
            }
        }
        return false
    }
}
