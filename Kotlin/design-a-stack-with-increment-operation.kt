package designastackwithincrementoperation

// Time:  cotr:      O(1)
//        push:      O(1)
//        pop:       O(1)
//        increment: O(1)
// Space: O(n)

class CustomStack(private val maxSize: Int) {
    private val stk = mutableListOf<IntArray>()

    fun push(x: Int) {
        if (stk.size == maxSize) {
            return
        }
        stk.add(intArrayOf(x, 0))
    }

    fun pop(): Int {
        if (stk.isEmpty()) {
            return -1
        }
        val top = stk.removeAt(stk.size - 1)
        val x = top[0]
        val inc = top[1]
        if (stk.isNotEmpty()) {
            stk[stk.size - 1][1] += inc
        }
        return x + inc
    }

    fun increment(k: Int, `val`: Int) {
        val i = minOf(stk.size, k) - 1
        if (i >= 0) {
            stk[i][1] += `val`
        }
    }
}
