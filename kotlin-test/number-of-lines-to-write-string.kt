package numberoflinestowritestring

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfLinesToWriteStringTest {
    @Test
    fun alphabetWithUniformWidths() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(3, 60), solution.numberOfLines(IntArray(26) { 10 }, "abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun mixedWidthsExample() {
        val solution = Solution()
        val widths = IntArray(26) { 10 }
        widths[0] = 4
        assertArrayEquals(intArrayOf(2, 4), solution.numberOfLines(widths, "bbbcccdddaaa"))
    }

    @Test
    fun emptyStringUsesOneEmptyLine() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(1, 0), solution.numberOfLines(IntArray(26) { 10 }, ""))
    }

    @Test
    fun exactCapacityDoesNotWrapEarly() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(2, 10), solution.numberOfLines(IntArray(26) { 10 }, "aaaaaaaaaaa"))
    }
}
