package designinmemoryfilesystem

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignInMemoryFileSystemTest {
    @Test
    fun leetCodeExample() {
        val fileSystem = FileSystem()
        assertEquals(emptyList<String>(), fileSystem.ls("/"))
        fileSystem.mkdir("/a/b/c")
        fileSystem.addContentToFile("/a/b/c/d", "hello")
        assertEquals(listOf("a"), fileSystem.ls("/"))
        assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d"))
    }

    @Test
    fun listingFileReturnsItsName() {
        val fileSystem = FileSystem()
        fileSystem.addContentToFile("/docs/note.txt", "a")
        assertEquals(listOf("note.txt"), fileSystem.ls("/docs/note.txt"))
    }

    @Test
    fun directoryListingIsSorted() {
        val fileSystem = FileSystem()
        fileSystem.mkdir("/root/z")
        fileSystem.mkdir("/root/a")
        fileSystem.addContentToFile("/root/m", "x")
        assertEquals(listOf("a", "m", "z"), fileSystem.ls("/root"))
    }

    @Test
    fun contentIsAppendedAcrossCalls() {
        val fileSystem = FileSystem()
        fileSystem.addContentToFile("/file", "hello")
        fileSystem.addContentToFile("/file", " ")
        fileSystem.addContentToFile("/file", "world")
        assertEquals("hello world", fileSystem.readContentFromFile("/file"))
    }
}
