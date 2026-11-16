package maximumgoodsubtreescore

// Time:  O(n * (2^10)^2)
// Space: O(2^10)

class Solution {
    fun goodSubtreeSum(vals: IntArray, par: IntArray): Int {
        val mod = 1_000_000_007
        val adj = Array(vals.size) { mutableListOf<Int>() }

        fun getMask(x: Int): Int {
            var value = x
            var mask = 0
            while (value != 0) {
                val d = value % 10
                if (mask and (1 shl d) != 0) {
                    return -1
                }
                mask = mask or (1 shl d)
                value /= 10
            }
            return mask
        }

        data class Frame(
            val step: Int,
            val u: Int,
            val i: Int,
            val newRet: HashMap<Int, Int>?,
            val ret: HashMap<Int, Int>
        )

        for (u in 1 until par.size) {
            adj[par[u]].add(u)
        }
        val ret = HashMap<Int, Int>()
        val stack = java.util.ArrayDeque<Frame>()
        stack.push(Frame(1, 0, -1, null, ret))
        var result = 0
        while (stack.isNotEmpty()) {
            val (step, u, i, newRet, currentRet) = stack.pop()
            when (step) {
                1 -> {
                    currentRet[0] = 0
                    val mask = getMask(vals[u])
                    if (mask != -1) {
                        currentRet[mask] = vals[u]
                    }
                    stack.push(Frame(4, u, -1, null, currentRet))
                    stack.push(Frame(2, u, 0, null, currentRet))
                }
                2 -> {
                    if (i == adj[u].size) {
                        continue
                    }
                    val v = adj[u][i]
                    stack.push(Frame(2, u, i + 1, null, currentRet))
                    val childRet = HashMap<Int, Int>()
                    stack.push(Frame(3, -1, -1, childRet, currentRet))
                    stack.push(Frame(1, v, -1, null, childRet))
                }
                3 -> {
                    val copyDp = HashMap(currentRet)
                    for ((m1, v1) in copyDp) {
                        for ((m2, v2) in newRet!!) {
                            if (m1 and m2 != 0) {
                                continue
                            }
                            val mask = m1 or m2
                            currentRet[mask] = maxOf(currentRet[mask] ?: 0, v1 + v2)
                        }
                    }
                }
                4 -> {
                    var mx = 0
                    for (value in currentRet.values) {
                        mx = maxOf(mx, value)
                    }
                    result = (result + mx) % mod
                }
            }
        }
        return result
    }
}
