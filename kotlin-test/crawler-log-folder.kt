package crawlerlogfolder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CrawlerLogFolderTest {
    @Test
    fun `counts depth after moving up and staying`() {
        val logs = listOf("d1/", "d2/", "../", "d21/", "./")
        assertEquals(2, Solution().minOperations(logs))
    }

    @Test
    fun `counts operations to return to a nested folder`() {
        val logs = listOf("d1/", "d2/", "./", "d3/", "../", "d31/")
        assertEquals(3, Solution().minOperations(logs))
    }

    @Test
    fun `ignores attempts to move above the root`() {
        val logs = listOf("d1/", "../", "../", "../")
        assertEquals(0, Solution().minOperations(logs))
    }

    @Test
    fun `empty logs leave the current folder unchanged`() {
        assertEquals(0, Solution().minOperations(emptyList()))
    }
}
