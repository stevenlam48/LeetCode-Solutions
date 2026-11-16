package designphonedirectory

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DesignPhoneDirectoryTest {
    @Test
    fun testExample() {
        val directory = PhoneDirectory(3)
        assertEquals(0, directory.get())
        assertEquals(1, directory.get())
        assertTrue(directory.check(2))
        assertEquals(2, directory.get())
        assertEquals(-1, directory.get())
        assertFalse(directory.check(2))
        directory.release(2)
        assertTrue(directory.check(2))
        assertEquals(2, directory.get())
    }

    @Test
    fun testReleaseUnusedIsNoOp() {
        val directory = PhoneDirectory(2)
        assertEquals(0, directory.get())
        directory.release(1)
        directory.release(1)
        assertEquals(1, directory.get())
        assertEquals(-1, directory.get())
    }

    @Test
    fun testCheckOutOfRange() {
        val directory = PhoneDirectory(2)
        assertFalse(directory.check(-1))
        assertFalse(directory.check(2))
        directory.release(-1)
        directory.release(5)
        assertEquals(0, directory.get())
        assertEquals(1, directory.get())
    }

    @Test
    fun testZeroNumbers() {
        val directory = PhoneDirectory(0)
        assertEquals(-1, directory.get())
        assertFalse(directory.check(0))
    }

    @Test
    fun testRecycleAll() {
        val directory = PhoneDirectory(3)
        repeat(3) { directory.get() }
        assertEquals(-1, directory.get())
        directory.release(1)
        directory.release(0)
        assertEquals(0, directory.get())
        assertEquals(1, directory.get())
        assertEquals(-1, directory.get())
    }
}
