package ringsandrods
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countPoints(rings: String): Int {
        val bits = mapOf('R' to 1, 'G' to 2, 'B' to 4)
        val rods = HashMap<Int, Int>()
        for (i in rings.indices step 2) {
            val rod = rings[i + 1] - '0'
            rods[rod] = rods.getOrDefault(rod, 0) or bits.getValue(rings[i])
        }
        return rods.values.count { it == 7 }
    }
}
