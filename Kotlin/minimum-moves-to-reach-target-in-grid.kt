package minimummovestoreachtargetingrid

// Time:  O(logtx + logty)
// Space: O(1)

class Solution {
    fun minMoves(sx: Int, sy: Int, tx: Int, ty: Int): Int {
        var result = 0
        var targetX = tx
        var targetY = ty
        while (sx != targetX || sy != targetY) {
            if (!(sx <= targetX && sy <= targetY)) {
                return -1
            }
            if (targetX < targetY) {
                if (targetX > targetY - targetX) {
                    targetY -= targetX
                } else {
                    if (targetY % 2 != 0) {
                        return -1
                    }
                    targetY -= targetY / 2
                }
            } else if (targetX > targetY) {
                if (targetY > targetX - targetY) {
                    targetX -= targetY
                } else {
                    if (targetX % 2 != 0) {
                        return -1
                    }
                    targetX -= targetX / 2
                }
            } else {
                if (sx == 0) {
                    targetX -= targetY
                } else if (sy == 0) {
                    targetY -= targetX
                } else {
                    return -1
                }
            }
            ++result
        }
        return result
    }
}
