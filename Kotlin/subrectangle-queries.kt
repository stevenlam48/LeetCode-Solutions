package subrectanglequeries

// Time:  ctor:   O(1)
//        update: O(1)
//        get:    O(u), u is the number of updates
// Space: O(u)

class SubrectangleQueries(private val rectangle: Array<IntArray>) {
    private val updates = mutableListOf<IntArray>()

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        updates.add(intArrayOf(row1, col1, row2, col2, newValue))
    }

    fun getValue(row: Int, col: Int): Int {
        for (i in updates.size - 1 downTo 0) {
            val u = updates[i]
            if (u[0] <= row && row <= u[2] && u[1] <= col && col <= u[3]) {
                return u[4]
            }
        }
        return rectangle[row][col]
    }
}
