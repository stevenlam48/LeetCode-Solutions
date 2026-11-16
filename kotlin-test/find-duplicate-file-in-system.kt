package findduplicatefileinsystem

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindDuplicateFileInSystemTest {
    private fun asSets(result: List<List<String>>): Set<Set<String>> =
        result.map { it.toSet() }.toSet()

    @Test
    fun standardExample() {
        val paths = arrayOf(
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"
        )
        assertEquals(
            setOf(
                setOf("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                setOf("root/a/1.txt", "root/c/3.txt")
            ),
            asSets(Solution().findDuplicate(paths))
        )
    }

    @Test
    fun noDuplicates() {
        val paths = arrayOf(
            "root/a 1.txt(abcd)",
            "root/c 3.txt(efgh)"
        )
        assertEquals(emptySet<Set<String>>(), asSets(Solution().findDuplicate(paths)))
    }

    @Test
    fun duplicatesInSameDirectory() {
        val paths = arrayOf("root/a 1.txt(abcd) 2.txt(abcd)")
        assertEquals(
            setOf(setOf("root/a/1.txt", "root/a/2.txt")),
            asSets(Solution().findDuplicate(paths))
        )
    }

    @Test
    fun threeCopies() {
        val paths = arrayOf(
            "a 1.txt(x)",
            "b 2.txt(x)",
            "c 3.txt(x)"
        )
        assertEquals(
            setOf(setOf("a/1.txt", "b/2.txt", "c/3.txt")),
            asSets(Solution().findDuplicate(paths))
        )
    }
}
