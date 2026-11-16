package threeSum2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSum2Test {
    private val solution = Solution()

    private fun triples(nums: IntArray): List<List<Int>> {
        return solution.threeSum(nums).map { it.toList() }
    }

    @Test
    fun standardMixedInput() {
        assertEquals(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)), triples(intArrayOf(-1, 0, 1, 2, -1, -4)))
    }

    @Test
    fun noTriplets() {
        assertEquals(emptyList<List<Int>>(), triples(intArrayOf(0, 1, 1)))
    }

    @Test
    fun allZerosProduceOneTriplet() {
        assertEquals(listOf(listOf(0, 0, 0)), triples(intArrayOf(0, 0, 0)))
    }

    @Test
    fun fewerThanThreeNumbers() {
        assertEquals(emptyList<List<Int>>(), triples(intArrayOf(0, 0)))
    }

    @Test
    fun duplicatesDoNotProduceDuplicateTriplets() {
        assertEquals(listOf(listOf(-2, 0, 2), listOf(-2, 1, 1)), triples(intArrayOf(-2, 0, 0, 2, 2, 1, 1)))
    }
}
