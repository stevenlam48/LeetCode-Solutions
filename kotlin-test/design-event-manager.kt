package designeventmanager

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignEventManagerTest {
    @Test
    fun pollsHighestPriorityAndSmallestIdOnTies() {
        val manager = EventManager(arrayOf(intArrayOf(1, 4), intArrayOf(2, 7), intArrayOf(3, 7)))
        assertEquals(2, manager.pollHighest())
        assertEquals(3, manager.pollHighest())
        assertEquals(1, manager.pollHighest())
        assertEquals(-1, manager.pollHighest())
    }

    @Test
    fun updatedPrioritiesReplaceOldEntries() {
        val manager = EventManager(arrayOf(intArrayOf(10, 1), intArrayOf(20, 2)))
        manager.updatePriority(10, 5)
        assertEquals(10, manager.pollHighest())
        manager.updatePriority(20, 9)
        manager.updatePriority(20, 3)
        assertEquals(20, manager.pollHighest())
        assertEquals(-1, manager.pollHighest())
    }

    @Test
    fun staleHeapEntriesAreDiscardedAfterRebuild() {
        val manager = EventManager(arrayOf(intArrayOf(1, 1)))
        manager.updatePriority(1, 2)
        manager.updatePriority(1, 3)
        manager.updatePriority(1, 4)
        assertEquals(1, manager.pollHighest())
        assertEquals(-1, manager.pollHighest())
    }

    @Test
    fun emptyEventList() {
        val manager = EventManager(emptyArray())
        assertEquals(-1, manager.pollHighest())
    }
}
