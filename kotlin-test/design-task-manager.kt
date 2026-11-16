package designtaskmanager

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignTaskManagerTest {
    @Test
    fun testExample() {
        val manager = TaskManager(
            arrayOf(
                intArrayOf(1, 101, 10),
                intArrayOf(2, 102, 20),
                intArrayOf(3, 103, 30)
            )
        )
        assertEquals(3, manager.execTop())
        manager.add(4, 104, 30)
        assertEquals(4, manager.execTop())
        manager.rmv(102)
        manager.edit(101, 25)
        assertEquals(1, manager.execTop())
        assertEquals(-1, manager.execTop())
    }

    @Test
    fun testHigherPriorityWins() {
        val manager = TaskManager(arrayOf(intArrayOf(1, 1, 5), intArrayOf(2, 2, 6)))
        assertEquals(2, manager.execTop())
        assertEquals(1, manager.execTop())
        assertEquals(-1, manager.execTop())
    }

    @Test
    fun testHigherTaskIdBreaksTie() {
        val manager = TaskManager(arrayOf(intArrayOf(1, 10, 5), intArrayOf(2, 20, 5)))
        assertEquals(2, manager.execTop())
        assertEquals(1, manager.execTop())
    }

    @Test
    fun testEditPriorityChangesOrder() {
        val manager = TaskManager(arrayOf(intArrayOf(1, 1, 1), intArrayOf(2, 2, 2)))
        assertEquals(2, manager.execTop())
        manager.edit(1, 100)
        assertEquals(1, manager.execTop())
        assertEquals(-1, manager.execTop())
    }

    @Test
    fun testRemoveThenExec() {
        val manager = TaskManager(arrayOf(intArrayOf(1, 1, 1), intArrayOf(2, 2, 2)))
        manager.rmv(2)
        assertEquals(1, manager.execTop())
        assertEquals(-1, manager.execTop())
    }

    @Test
    fun testEmpty() {
        val manager = TaskManager(arrayOf())
        assertEquals(-1, manager.execTop())
    }
}
