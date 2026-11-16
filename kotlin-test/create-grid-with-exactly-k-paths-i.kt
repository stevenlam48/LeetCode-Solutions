package creategridwithexactlykpathsi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CreateGridWithExactlyKPathsITest {
    @Test
    fun `zero paths produces an empty grid`() {
        assertArrayEquals(emptyArray<String>(), Solution().createGrid(3, 3, 0))
    }

    @Test
    fun `extends the one path pattern to the requested dimensions`() {
        val expected = arrayOf(".###", ".###", "....")
        assertArrayEquals(expected, Solution().createGrid(3, 4, 1))
    }

    @Test
    fun `uses a three row pattern for three paths`() {
        val expected = arrayOf("..##", "..##", "....")
        assertArrayEquals(expected, Solution().createGrid(3, 4, 3))
    }

    @Test
    fun `skips patterns that do not fit`() {
        val expected = arrayOf("....#", ".....")
        assertArrayEquals(expected, Solution().createGrid(2, 5, 4))
        assertArrayEquals(emptyArray<String>(), Solution().createGrid(1, 1, 2))
    }
}
