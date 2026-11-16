package designa3dbinarymatrixwithefficientlayertracking

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignA3dBinaryMatrixWithEfficientLayerTrackingTest {
    @Test
    fun testExample() {
        val matrix = Matrix3D(2)
        matrix.setCell(0, 0, 0)
        matrix.setCell(1, 1, 1)
        matrix.setCell(0, 0, 0)
        assertEquals(1, matrix.largestMatrix())
        matrix.unsetCell(1, 1, 1)
        assertEquals(0, matrix.largestMatrix())
    }

    @Test
    fun testLargestTracksCounts() {
        val matrix = Matrix3D(3)
        matrix.setCell(0, 0, 0)
        matrix.setCell(0, 0, 1)
        matrix.setCell(1, 0, 0)
        assertEquals(0, matrix.largestMatrix())
        matrix.setCell(1, 0, 1)
        assertEquals(1, matrix.largestMatrix())
        matrix.setCell(2, 0, 0)
        assertEquals(1, matrix.largestMatrix())
    }

    @Test
    fun testUnsetNonExistent() {
        val matrix = Matrix3D(2)
        matrix.unsetCell(0, 0, 0)
        assertEquals(1, matrix.largestMatrix())
    }

    @Test
    fun testLastRowAlwaysCandidate() {
        val matrix = Matrix3D(2)
        matrix.setCell(0, 0, 0)
        matrix.setCell(0, 0, 1)
        assertEquals(0, matrix.largestMatrix())
        matrix.unsetCell(0, 0, 0)
        matrix.unsetCell(0, 0, 1)
        assertEquals(1, matrix.largestMatrix())
    }
}
