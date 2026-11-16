package dotproductoftwosparsevectors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DotProductOfTwoSparseVectorsTest {
    @Test
    fun example1() {
        val v1 = SparseVector(intArrayOf(1, 0, 0, 2, 3))
        val v2 = SparseVector(intArrayOf(0, 3, 0, 4, 0))
        assertEquals(8, v1.dotProduct(v2))
    }

    @Test
    fun example2() {
        val v1 = SparseVector(intArrayOf(0, 1, 0, 0, 0))
        val v2 = SparseVector(intArrayOf(0, 0, 0, 0, 2))
        assertEquals(0, v1.dotProduct(v2))
    }

    @Test
    fun example3() {
        val v1 = SparseVector(intArrayOf(0, 1, 0, 0, 2, 0, 0))
        val v2 = SparseVector(intArrayOf(1, 0, 0, 0, 3, 0, 4))
        assertEquals(6, v1.dotProduct(v2))
    }

    @Test
    fun allZeros() {
        val v1 = SparseVector(intArrayOf(0, 0, 0))
        val v2 = SparseVector(intArrayOf(0, 0, 0))
        assertEquals(0, v1.dotProduct(v2))
    }

    @Test
    fun negatives() {
        val v1 = SparseVector(intArrayOf(-1, 2, 0))
        val v2 = SparseVector(intArrayOf(3, -4, 5))
        assertEquals(-11, v1.dotProduct(v2))
    }
}
