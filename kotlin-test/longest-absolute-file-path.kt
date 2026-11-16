package longestabsolutefilepath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestAbsoluteFilePathTest {
    @Test
    fun nestedDirectories() {
        val input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
        assertEquals(20, Solution().lengthLongestPath(input))
    }

    @Test
    fun deeperNesting() {
        val input =
            "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        assertEquals(32, Solution().lengthLongestPath(input))
    }

    @Test
    fun noFile() {
        assertEquals(0, Solution().lengthLongestPath("a"))
    }

    @Test
    fun emptyInput() {
        assertEquals(0, Solution().lengthLongestPath(""))
    }

    @Test
    fun fileAtRoot() {
        assertEquals(8, Solution().lengthLongestPath("file.txt"))
    }

    @Test
    fun singleNestedFile() {
        assertEquals(12, Solution().lengthLongestPath("dir\n\tfile.txt"))
    }
}
