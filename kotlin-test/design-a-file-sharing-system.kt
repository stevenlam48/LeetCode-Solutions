package designafilesharingsystem

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAFileSharingSystemTest {
    @Test
    fun testExample() {
        val fs = FileSharing(4)
        assertEquals(1, fs.join(listOf(1, 2)))
        assertEquals(2, fs.join(listOf(2, 3)))
        assertEquals(3, fs.join(listOf(4)))
        assertEquals(listOf(2), fs.request(1, 3))
        assertEquals(listOf(1, 2), fs.request(2, 2))
        fs.leave(1)
        assertEquals(emptyList<Int>(), fs.request(2, 1))
        assertEquals(1, fs.join(emptyList()))
        assertEquals(listOf(2), fs.request(2, 2))
    }

    @Test
    fun testReuseLowestId() {
        val fs = FileSharing(2)
        assertEquals(1, fs.join(listOf(1)))
        assertEquals(2, fs.join(listOf(2)))
        fs.leave(1)
        fs.leave(2)
        assertEquals(1, fs.join(emptyList()))
        assertEquals(2, fs.join(emptyList()))
    }

    @Test
    fun testRequestOwnedChunk() {
        val fs = FileSharing(3)
        val id = fs.join(listOf(1, 2, 3))
        assertEquals(listOf(id), fs.request(id, 1))
    }

    @Test
    fun testLeaveUnknownUser() {
        val fs = FileSharing(1)
        fs.leave(5)
        assertEquals(1, fs.join(listOf(1)))
    }
}
