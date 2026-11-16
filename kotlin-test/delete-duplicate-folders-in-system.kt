package deleteduplicatefoldersinsystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DeleteDuplicateFoldersInSystemTest {
    private val solution = Solution()

    @Test
    fun removesAllCopiesOfDuplicateSubtree() {
        val paths = listOf(
            listOf("a"), listOf("a", "c"), listOf("a", "d"),
            listOf("b"), listOf("b", "c"), listOf("b", "d"), listOf("e")
        )
        assertEquals(setOf(listOf("e")), solution.deleteDuplicateFolder(paths).toSet())
    }

    @Test
    fun removesNestedDuplicatesAndKeepsUniqueFolder() {
        val paths = listOf(
            listOf("a"), listOf("a", "b"), listOf("a", "b", "c"),
            listOf("x"), listOf("x", "b"), listOf("x", "b", "c"),
            listOf("p"), listOf("p", "q")
        )
        assertEquals(setOf(listOf("p"), listOf("p", "q")), solution.deleteDuplicateFolder(paths).toSet())
    }

    @Test
    fun leafFoldersWithSameNameAreNotDuplicatesWithoutParents() {
        val paths = listOf(listOf("a"), listOf("b"))
        assertEquals(paths.toSet(), solution.deleteDuplicateFolder(paths).toSet())
    }

    @Test
    fun emptyPaths() {
        assertEquals(emptyList<List<String>>(), solution.deleteDuplicateFolder(emptyList()))
    }
}
