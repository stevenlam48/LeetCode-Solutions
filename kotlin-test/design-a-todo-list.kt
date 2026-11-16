package designatodolist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignATodoListTest {
    @Test
    fun testExample() {
        val todo = TodoList()
        assertEquals(1, todo.addTask(1, "Task1", 50, emptyList()))
        assertEquals(2, todo.addTask(1, "Task2", 100, listOf("P1")))
        assertEquals(listOf("Task1", "Task2"), todo.getAllTasks(1))
        assertEquals(emptyList<String>(), todo.getAllTasks(5))
        assertEquals(3, todo.addTask(1, "Task3", 30, listOf("P1")))
        assertEquals(listOf("Task3", "Task2"), todo.getTasksForTag(1, "P1"))
        todo.completeTask(1, 2)
        assertEquals(listOf("Task3"), todo.getTasksForTag(1, "P1"))
        assertEquals(listOf("Task3", "Task1"), todo.getAllTasks(1))
    }

    @Test
    fun testOrderedByDueDate() {
        val todo = TodoList()
        todo.addTask(1, "c", 30, emptyList())
        todo.addTask(1, "a", 10, emptyList())
        todo.addTask(1, "b", 20, emptyList())
        assertEquals(listOf("a", "b", "c"), todo.getAllTasks(1))
    }

    @Test
    fun testMultipleUsers() {
        val todo = TodoList()
        todo.addTask(1, "u1", 5, listOf("x"))
        todo.addTask(2, "u2", 5, listOf("x"))
        assertEquals(listOf("u1"), todo.getAllTasks(1))
        assertEquals(listOf("u2"), todo.getAllTasks(2))
        assertEquals(listOf("u1"), todo.getTasksForTag(1, "x"))
    }

    @Test
    fun testCompleteUnknownTask() {
        val todo = TodoList()
        todo.addTask(1, "t", 1, emptyList())
        todo.completeTask(1, 99)
        assertEquals(listOf("t"), todo.getAllTasks(1))
    }

    @Test
    fun testTagNotPresent() {
        val todo = TodoList()
        todo.addTask(1, "t", 1, listOf("a"))
        assertEquals(emptyList<String>(), todo.getTasksForTag(1, "b"))
    }
}
