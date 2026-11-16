package flatten2dvector

// Time:  O(1)
// Space: O(1)

class Vector2D(vec2d: List<List<Int>>) {
    private val vec = vec2d
    private var x = 0
    private var y = 0

    init {
        adjustNextIter()
    }

    fun next(): Int {
        val ret = vec[x][y]
        ++y
        adjustNextIter()
        return ret
    }

    fun hasNext(): Boolean {
        return x < vec.size && y < vec[x].size
    }

    private fun adjustNextIter() {
        while (x < vec.size && y == vec[x].size) {
            ++x
            if (x < vec.size) {
                y = 0
            }
        }
    }
}
