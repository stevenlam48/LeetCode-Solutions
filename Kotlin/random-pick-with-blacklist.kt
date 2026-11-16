package randompickwithblacklist

// Time:  ctor: O(b)
//        pick: O(1)
// Space: O(b)

class Solution(N: Int, blacklist: IntArray) {
    private val n = N - blacklist.size
    private val lookup = HashMap<Int, Int>()
    private val gen = java.util.Random()

    init {
        val whitelist = HashSet<Int>()
        for (i in n until N) {
            whitelist.add(i)
        }
        for (black in blacklist) {
            whitelist.remove(black)
        }
        val white = whitelist.iterator()
        for (black in blacklist) {
            if (black < n) {
                lookup[black] = white.next()
            }
        }
    }

    fun pick(): Int {
        val index = gen.nextInt(n)
        return lookup[index] ?: index
    }
}
