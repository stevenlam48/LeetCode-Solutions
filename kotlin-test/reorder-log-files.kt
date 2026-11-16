package reorderlogfiles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReorderLogFilesTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(
            listOf("let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"),
            solution.reorderLogFiles(
                listOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")
            )
        )
    }

    @Test
    fun secondExample() {
        assertEquals(
            listOf("g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"),
            solution.reorderLogFiles(
                listOf("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo")
            )
        )
    }

    @Test
    fun digitLogsRetainTheirOriginalOrder() {
        val logs = listOf("d2 2 3", "d1 1 2", "d3 4 5")
        assertEquals(logs, solution.reorderLogFiles(logs))
    }

    @Test
    fun equalContentsAreOrderedByIdentifier() {
        assertEquals(
            listOf("a1 same content", "b1 same content", "c1 same content"),
            solution.reorderLogFiles(listOf("c1 same content", "a1 same content", "b1 same content"))
        )
    }
}
