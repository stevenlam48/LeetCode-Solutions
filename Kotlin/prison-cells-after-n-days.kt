package prisoncellsafterndays

// Time:  O(1)
// Space: O(1)

class Solution {
    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        var n = (N - 1) % 14 + 1
        while (n > 0) {
            val cells2 = IntArray(8)
            for (i in 1 until 7) {
                cells2[i] = if (cells[i - 1] == cells[i + 1]) 1 else 0
            }
            cells2.copyInto(cells)
            --n
        }
        return cells
    }
}
