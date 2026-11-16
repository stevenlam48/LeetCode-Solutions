package operationsontree

// Time:  ctor:    O(n)
//        lock:    O(1)
//        unlock:  O(1)
//        upgrade: O(n)
// Space: O(n)

class LockingTree(parent: IntArray) {
    private val parent = parent.copyOf()
    private val children = Array(parent.size) { mutableListOf<Int>() }
    private val locked = HashMap<Int, Int>()

    init {
        for (i in parent.indices) {
            if (parent[i] != -1) {
                children[parent[i]].add(i)
            }
        }
    }

    fun lock(num: Int, user: Int): Boolean {
        if (locked.containsKey(num)) {
            return false
        }
        locked[num] = user
        return true
    }

    fun unlock(num: Int, user: Int): Boolean {
        if (!locked.containsKey(num) || locked[num] != user) {
            return false
        }
        locked.remove(num)
        return true
    }

    fun upgrade(num: Int, user: Int): Boolean {
        var node = num
        while (node != -1) {
            if (locked.containsKey(node)) {
                return false
            }
            node = parent[node]
        }
        var result = false
        val stk = ArrayDeque<Int>()
        stk.addLast(num)
        while (stk.isNotEmpty()) {
            val cur = stk.removeLast()
            for (child in children[cur]) {
                if (locked.containsKey(child)) {
                    locked.remove(child)
                    result = true
                }
                stk.addLast(child)
            }
        }
        if (result) {
            locked[num] = user
        }
        return result
    }
}
