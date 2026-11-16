package snapshotarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SnapshotArrayTest {
    @Test
    fun exampleSequence() {
        val snapshotArray = SnapshotArray(3)
        snapshotArray.set(0, 5)
        assertEquals(0, snapshotArray.snap())
        snapshotArray.set(0, 6)
        assertEquals(5, snapshotArray.get(0, 0))
    }

    @Test
    fun multipleSnapshots() {
        val snapshotArray = SnapshotArray(3)
        snapshotArray.set(0, 5)
        assertEquals(0, snapshotArray.snap())
        snapshotArray.set(0, 6)
        assertEquals(1, snapshotArray.snap())
        snapshotArray.set(0, 7)
        assertEquals(2, snapshotArray.snap())
        assertEquals(5, snapshotArray.get(0, 0))
        assertEquals(6, snapshotArray.get(0, 1))
        assertEquals(7, snapshotArray.get(0, 2))
        assertEquals(0, snapshotArray.get(1, 2))
    }

    @Test
    fun untouchedIndices() {
        val snapshotArray = SnapshotArray(2)
        assertEquals(0, snapshotArray.snap())
        assertEquals(0, snapshotArray.get(1, 0))
        assertEquals(0, snapshotArray.get(0, 0))
    }

    @Test
    fun repeatedSetWithinSameSnapshot() {
        val snapshotArray = SnapshotArray(1)
        snapshotArray.set(0, 1)
        snapshotArray.set(0, 2)
        assertEquals(0, snapshotArray.snap())
        snapshotArray.set(0, 3)
        assertEquals(1, snapshotArray.snap())
        assertEquals(2, snapshotArray.get(0, 0))
        assertEquals(3, snapshotArray.get(0, 1))
    }
}
