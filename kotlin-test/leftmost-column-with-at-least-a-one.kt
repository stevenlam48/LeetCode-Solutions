package leftmostcolumnwithatleastaone

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LeftmostColumnWithAtLeastAOneTest {
    @Test
    fun findsLeftmostColumnInFirstExample() {
        val matrix = BinaryMatrix(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1)))

        assertEquals(0, Solution().leftMostColumnWithOne(matrix))
    }

    @Test
    fun findsLeftmostColumnInSecondExample() {
        val matrix = BinaryMatrix(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)))

        assertEquals(1, Solution().leftMostColumnWithOne(matrix))
    }

    @Test
    fun returnsMinusOneWhenMatrixHasNoOnes() {
        val matrix = BinaryMatrix(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))

        assertEquals(-1, Solution().leftMostColumnWithOne(matrix))
    }

    @Test
    fun scansAcrossMultipleRows() {
        val matrix = BinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0, 1),
                intArrayOf(0, 0, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )

        assertEquals(1, Solution().leftMostColumnWithOne(matrix))
    }

    @Test
    fun handlesEmptyMatrix() {
        assertEquals(-1, Solution().leftMostColumnWithOne(BinaryMatrix(emptyArray())))
    }
}
