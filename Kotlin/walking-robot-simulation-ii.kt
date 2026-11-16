package walkingrobotsimulationii

// Time:  O(1)
// Space: O(1)

class Robot(private val width: Int, private val height: Int) {
    private var curr = 0

    fun move(num: Int) {
        curr += num
    }

    fun getPos(): IntArray {
        var n = curr % (2 * ((width - 1) + height - 1))
        if (n < width) {
            return intArrayOf(n, 0)
        }
        n -= width - 1
        if (n < height) {
            return intArrayOf(width - 1, n)
        }
        n -= height - 1
        if (n < width) {
            return intArrayOf((width - 1) - n, height - 1)
        }
        n -= width - 1
        return intArrayOf(0, (height - 1) - n)
    }

    fun getDir(): String {
        var n = curr % (2 * ((width - 1) + height - 1))
        if (n < width) {
            return if (n == 0 && curr != 0) "South" else "East"
        }
        n -= width - 1
        if (n < height) {
            return "North"
        }
        n -= height - 1
        if (n < width) {
            return "West"
        }
        n -= width - 1
        return "South"
    }
}
