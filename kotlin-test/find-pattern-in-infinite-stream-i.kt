package findpatternininfinitestreami

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPatternInInfiniteStreamITest {
    private val solution = Solution()

    @Test
    fun patternInMiddle() {
        assertEquals(2, solution.findPattern(FakeInfiniteStream(intArrayOf(0, 1, 1, 0, 1)), intArrayOf(1, 0, 1)))
    }

    @Test
    fun patternAtBeginning() {
        assertEquals(0, solution.findPattern(FakeInfiniteStream(intArrayOf(1, 1, 0)), intArrayOf(1, 1)))
    }

    @Test
    fun overlappingMatches() {
        assertEquals(3, solution.findPattern(FakeInfiniteStream(intArrayOf(1, 1, 0, 1, 1, 1)), intArrayOf(1, 1, 1)))
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
