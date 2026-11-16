package creategridwithexactlyonepath

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CreateGridWithExactlyOnePathTest {
    @Test
    fun `creates one path across the top and down the right`() {
        val expected = arrayOf("...", "##.", "##.")
        assertArrayEquals(expected, Solution().createGrid(3, 3))
    }

    @Test
    fun `handles a single cell`() {
        assertArrayEquals(arrayOf("."), Solution().createGrid(1, 1))
    }

    @Test
    fun `handles one row`() {
        assertArrayEquals(arrayOf("...."), Solution().createGrid(1, 4))
    }

    @Test
    fun `handles a narrow tall grid`() {
        val expected = arrayOf("..", "#.", "#.", "#.")
        assertArrayEquals(expected, Solution().createGrid(4, 2))
    }
}
