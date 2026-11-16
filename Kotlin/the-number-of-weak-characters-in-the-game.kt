package thenumberofweakcharactersinthegame

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith(compareBy<IntArray>({ it[0] }).thenByDescending { it[1] })
        var result = 0
        var maxD = 0
        for (i in properties.size - 1 downTo 0) {
            if (properties[i][1] < maxD) {
                ++result
            }
            maxD = Math.max(maxD, properties[i][1])
        }
        return result
    }
}
