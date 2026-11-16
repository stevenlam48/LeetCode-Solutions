package cinemaseatallocation

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val lookup = HashMap<Int, HashMap<Int, Boolean>>()
        for (seat in reservedSeats) {
            if (seat[1] in 2..5) {
                lookup.getOrPut(seat[0]) { HashMap() }[0] = true
            }
            if (seat[1] in 4..7) {
                lookup.getOrPut(seat[0]) { HashMap() }[1] = true
            }
            if (seat[1] in 6..9) {
                lookup.getOrPut(seat[0]) { HashMap() }[2] = true
            }
        }
        var result = 2 * n
        for (reserved in lookup.values) {
            if (reserved[0] != true && reserved[2] != true) {
                continue
            }
            if (reserved[0] != true || reserved[1] != true || reserved[2] != true) {
                --result
                continue
            }
            result -= 2
        }
        return result
    }
}
