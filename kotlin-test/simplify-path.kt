package simplifypath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimplifyPathTest {
    private val solution = Solution()

    @Test
    fun `removes trailing slash`() {
        assertEquals("/home", solution.simplifyPath("/home/"))
    }

    @Test
    fun `cannot move above root`() {
        assertEquals("/", solution.simplifyPath("/../"))
    }

    @Test
    fun `collapses repeated slashes`() {
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"))
    }

    @Test
    fun `resolves current and parent directories`() {
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"))
    }

    @Test
    fun `triple dots are a directory name`() {
        assertEquals("/.../a/b", solution.simplifyPath("/.../a//b"))
    }
}
