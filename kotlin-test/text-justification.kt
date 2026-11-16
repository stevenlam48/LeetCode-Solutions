package textjustification

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TextJustificationTest {
    @Test
    fun standardExample() {
        assertEquals(
            listOf("This    is    an", "example  of text", "justification.  "),
            Solution().fullJustify(
                listOf("This", "is", "an", "example", "of", "text", "justification."),
                16
            )
        )
    }

    @Test
    fun packingAndSingleWordLine() {
        assertEquals(
            listOf("a  b", "c   "),
            Solution().fullJustify(listOf("a", "b", "c"), 4)
        )
    }

    @Test
    fun exactWidthLastLine() {
        assertEquals(
            listOf("one two"),
            Solution().fullJustify(listOf("one", "two"), 7)
        )
    }

    @Test
    fun unevenExtraSpaces() {
        assertEquals(
            listOf("a  b c d", "e       "),
            Solution().fullJustify(listOf("a", "b", "c", "d", "e"), 8)
        )
    }
}
