package similarrgbcolor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimilarRgbColorTest {
    private val solution = Solution()

    @Test
    fun `rounds each component independently`() {
        assertEquals("#11ee66", solution.similarRGB("#09f166"))
    }

    @Test
    fun `chooses nearest shorthand color`() {
        assertEquals("#5544dd", solution.similarRGB("#4e3fe1"))
    }

    @Test
    fun `keeps endpoints`() {
        assertEquals("#000000", solution.similarRGB("#000000"))
        assertEquals("#ffffff", solution.similarRGB("#ffffff"))
    }

    @Test
    fun `outputs lowercase hexadecimal`() {
        assertEquals("#aabbcc", solution.similarRGB("#A9B8C7"))
    }
}
