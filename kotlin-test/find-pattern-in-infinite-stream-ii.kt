package findpatternininfinitestreamii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPatternInInfiniteStreamIITest {
    private val solution = Solution()

    @Test
    fun patternInMiddle() {
        assertEquals(1, solution.findPattern(FakeInfiniteStream(intArrayOf(1, 0, 1, 1, 0)), intArrayOf(0, 1, 1)))
    }

    @Test
    fun singleBitPattern() {
        assertEquals(3, solution.findPattern(FakeInfiniteStream(intArrayOf(0, 0, 0, 1)), intArrayOf(1)))
    }

    @Test
    fun prefixFallback() {
        assertEquals(3, solution.findPattern(FakeInfiniteStream(intArrayOf(0, 1, 0, 0, 1, 0, 1)), intArrayOf(0, 1, 0, 1)))
    }
}

private class FakeInfiniteStream(private val values: IntArray) : InfiniteStream {
    private var index = 0

    override fun next(): Int {
        val result = values[index]
        index = (index + 1) % values.size
        return result
    }
}
