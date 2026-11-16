package removesubfoldersfromthefilesystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveSubFoldersFromTheFilesystemTest {
    private val solution = Solution()

    private fun assertFolders(expected: Set<String>, folders: List<String>) {
        val actual = solution.removeSubfolders(folders)
        assertEquals(expected, actual.toSet())
        assertEquals(expected.size, actual.size)
    }

    @Test
    fun firstExample() {
        assertFolders(
            setOf("/a", "/c/d", "/c/f"),
            listOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
        )
    }

    @Test
    fun nestedFoldersShareOneParent() {
        assertFolders(setOf("/a"), listOf("/a", "/a/b/c", "/a/b/d"))
    }

    @Test
    fun similarNamesAreNotSubfolders() {
        assertFolders(
            setOf("/a/b/c", "/a/b/ca", "/a/b/d"),
            listOf("/a/b/c", "/a/b/ca", "/a/b/d")
        )
    }

    @Test
    fun parentMayAppearAfterChild() {
        assertFolders(setOf("/a", "/b/c"), listOf("/a/b", "/b/c/d", "/b/c", "/a"))
    }
}
