package designtaskmanager

import java.util.TreeSet

// Time:  ctor:    O(tlogt)
//        add:     O(logt)
//        edit:    O(logt)
//        rmv:     O(logt)
//        execTop: O(logt)
// Space: O(t)

class TaskManager(tasks: Array<IntArray>) {
    private val lookup = HashMap<Int, Pair<Int, Int>>()
    private val bst = TreeSet<Triple<Int, Int, Int>>(
        compareBy<Triple<Int, Int, Int>>({ it.first }, { it.second }, { it.third })
    )

    init {
        for (t in tasks) {
            add(t[0], t[1], t[2])
        }
    }

    fun add(userId: Int, taskId: Int, priority: Int) {
        bst.add(Triple(priority, taskId, userId))
        lookup[taskId] = Pair(userId, priority)
    }

    fun edit(taskId: Int, newPriority: Int) {
        val userId = lookup[taskId]!!.first
        rmv(taskId)
        add(userId, taskId, newPriority)
    }

    fun rmv(taskId: Int) {
        val (userId, priority) = lookup[taskId]!!
        lookup.remove(taskId)
        bst.remove(Triple(priority, taskId, userId))
    }

    fun execTop(): Int {
        if (bst.isEmpty()) {
            return -1
        }
        val (_, taskId, userId) = bst.last()
        rmv(taskId)
        return userId
    }
}
