package designatodolist

import java.util.TreeMap

// Time:  ctor:           O(1)
//        addTask:        O(l + logn), n is the number of user's tasks, l is the max length of a task
//        getAllTasks:    O(r), r is the length of result
//        getTasksForTag: O(r * c), r is the length of result, c is the length of the tag
//        completeTask:   O(l + logn)
// Space: O(n * l)

class TodoList {
    private val tasks = mutableListOf<Triple<Int, String, Set<String>>>()
    private val userTaskIds = HashMap<String, TreeMap<Int, Int>>()

    fun addTask(userId: Int, taskDescription: String, dueDate: Int, tags: List<String>): Int {
        tasks.add(Triple(dueDate, taskDescription, tags.toHashSet()))
        userTaskIds.getOrPut(userId.toString()) { TreeMap() }[dueDate] = tasks.size
        return tasks.size
    }

    fun getAllTasks(userId: Int): List<String> {
        val result = mutableListOf<String>()
        val key = userId.toString()
        userTaskIds[key]?.let { map ->
            for (i in map.values) {
                result.add(tasks[i - 1].second)
            }
        }
        return result
    }

    fun getTasksForTag(userId: Int, tag: String): List<String> {
        val result = mutableListOf<String>()
        val key = userId.toString()
        userTaskIds[key]?.let { map ->
            for (i in map.values) {
                if (tasks[i - 1].third.contains(tag)) {
                    result.add(tasks[i - 1].second)
                }
            }
        }
        return result
    }

    fun completeTask(userId: Int, taskId: Int) {
        val key = userId.toString()
        if (!(taskId - 1 < tasks.size && userTaskIds.containsKey(key))) {
            return
        }
        userTaskIds[key]!!.remove(tasks[taskId - 1].first)
    }
}
