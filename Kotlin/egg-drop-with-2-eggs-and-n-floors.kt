package eggdropwith2eggsandnfloors

// Time:  O(1)
// Space: O(1)
import kotlin.math.ceil
import kotlin.math.sqrt

class Solution {
    fun twoEggDrop(n: Int): Int {
        return ceil((-1 + sqrt(1.0 + 8 * n)) / 2).toInt()
    }
}
