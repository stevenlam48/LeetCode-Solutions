package zigzagiterator

// Time:  O(n)
// Space: O(k)

class ZigzagIterator(v1: IntArray, v2: IntArray) {
    private val q = ArrayDeque<Pair<IntArray, Int>>()

    init {
        if (v1.isNotEmpty()) {
            q.addLast(v1 to 0)
        }
        if (v2.isNotEmpty()) {
            q.addLast(v2 to 0)
        }
    }

    fun next(): Int {
        val (arr, pos) = q.removeFirst()
        if (arr.size - pos > 1) {
            q.addLast(arr to pos + 1)
        }
        return arr[pos]
    }

    fun hasNext(): Boolean = q.isNotEmpty()
}
