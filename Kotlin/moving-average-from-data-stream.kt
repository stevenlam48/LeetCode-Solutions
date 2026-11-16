package movingaveragefromdatastream

// Time:  O(1)
// Space: O(w)

class MovingAverage(private val size: Int) {
    private var sum = 0
    private val q = ArrayDeque<Int>()

    fun next(`val`: Int): Double {
        if (q.size == size) {
            sum -= q.removeFirst()
        }
        q.addLast(`val`)
        sum += `val`
        return 1.0 * sum / q.size
    }
}
