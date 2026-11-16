package findsmallestcommonelementinallrows

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun smallestCommonElement(mat: Array<IntArray>): Int {
        // values could be duplicated in each row
        var intersections: MutableSet<Int> = mat[0].toMutableSet()
        for (i in 1 until mat.size) {
            val a = intersections
            val b = mat[i].toSet()
            intersections = a.filterTo(mutableSetOf()) { it in b }
            if (intersections.isEmpty()) {
                return -1
            }
        }
        return intersections.minOrNull()!!
    }
}
