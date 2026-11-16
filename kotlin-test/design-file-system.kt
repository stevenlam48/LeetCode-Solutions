package designfilesystem

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignFileSystemTest {
    @Test
    fun leetCodeExample() {
        val fileSystem = FileSystem()
        assertTrue(fileSystem.create("/a", 1))
        assertEquals(1, fileSystem.get("/a"))
    }

    @Test
    fun nestedPathsRequireExistingParent() {
        val fileSystem = FileSystem()
        assertFalse(fileSystem.create("/a/b", 2))
        assertTrue(fileSystem.create("/a", 1))
        assertTrue(fileSystem.create("/a/b", 2))
        assertTrue(fileSystem.create("/a/b/c", 3))
        assertEquals(2, fileSystem.get("/a/b"))
        assertEquals(3, fileSystem.get("/a/b/c"))
    }

    @Test
    fun missingPathReturnsMinusOne() {
        val fileSystem = FileSystem()
        assertEquals(-1, fileSystem.get(""))
        assertEquals(-1, fileSystem.get("/missing"))
    }

    @Test
    fun existingPathIsOverwrittenLikeCppReference() {
        val fileSystem = FileSystem()
        assertTrue(fileSystem.create("/a", 1))
        assertTrue(fileSystem.create("/a", 9))
        assertEquals(9, fileSystem.get("/a"))
    }
}
