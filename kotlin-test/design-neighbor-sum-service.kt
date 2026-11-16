package designneighborsumservice

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignNeighborSumServiceTest {
    private fun grid(): Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8)
    )

    @Test
    fun testExample() {
        val service = neighborSum(grid())
        assertEquals(6, service.adjacentSum(1))
        assertEquals(16, service.diagonalSum(4))
        assertEquals(12, service.adjacentSum(8))
        assertEquals(4, service.diagonalSum(8))
    }

    @Test
    fun testCorners() {
        val service = neighborSum(grid())
        assertEquals(1 + 3, service.adjacentSum(0))
        assertEquals(4, service.diagonalSum(0))
        assertEquals(5 + 7, service.adjacentSum(8))
        assertEquals(4, service.diagonalSum(8))
    }

    @Test
    fun testEdges() {
        val service = neighborSum(grid())
        assertEquals(0 + 2 + 4, service.adjacentSum(1))
        assertEquals(0 + 8, service.diagonalSum(1))
        assertEquals(6 + 8 + 4, service.adjacentSum(7))
        assertEquals(3 + 5, service.diagonalSum(7))
    }

    @Test
    fun testSingleCell() {
        val service = neighborSum(arrayOf(intArrayOf(0)))
        assertEquals(0, service.adjacentSum(0))
        assertEquals(0, service.diagonalSum(0))
    }
}
