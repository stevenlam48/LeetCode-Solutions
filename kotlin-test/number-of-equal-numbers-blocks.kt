package numberofequalnumbersblocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class FakeBigArray(private val values: IntArray) : BigArray {
    override fun size(): Long = values.size.toLong()

    override fun at(index: Long): Int = values[index.toInt()]
}

class NumberOfEqualNumbersBlocksTest {
    @Test
    fun testSingleBlock() {
        assertEquals(1, Solution().countBlocks(FakeBigArray(intArrayOf(3, 3, 3, 3, 3))))
    }

    @Test
    fun testThreeBlocks() {
        assertEquals(3, Solution().countBlocks(FakeBigArray(intArrayOf(1, 1, 2, 2, 3))))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(4, Solution().countBlocks(FakeBigArray(intArrayOf(1, 2, 3, 4))))
    }

    @Test
    fun testRepeatedValueInSeparateBlocks() {
        assertEquals(3, Solution().countBlocks(FakeBigArray(intArrayOf(1, 1, 1, 2, 1))))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().countBlocks(FakeBigArray(intArrayOf(5))))
    }
}
