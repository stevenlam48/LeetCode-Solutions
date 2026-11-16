package constructquadtree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructQuadTreeTest {
    @Test
    fun testMixedTwoByTwo() {
        val root = Solution().construct(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)))!!
        assertFalse(root.isLeaf)
        assertTrue(root.`val`)
        assertEquals(false, root.topLeft!!.`val`)
        assertTrue(root.topLeft!!.isLeaf)
        assertEquals(true, root.topRight!!.`val`)
        assertTrue(root.topRight!!.isLeaf)
        assertEquals(true, root.bottomLeft!!.`val`)
        assertTrue(root.bottomLeft!!.isLeaf)
        assertEquals(false, root.bottomRight!!.`val`)
        assertTrue(root.bottomRight!!.isLeaf)
    }

    @Test
    fun testAllOnes() {
        val root = Solution().construct(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1)))!!
        assertTrue(root.isLeaf)
        assertTrue(root.`val`)
        assertNull(root.topLeft)
        assertNull(root.topRight)
        assertNull(root.bottomLeft)
        assertNull(root.bottomRight)
    }

    @Test
    fun testSingleCellZero() {
        val root = Solution().construct(arrayOf(intArrayOf(0)))!!
        assertTrue(root.isLeaf)
        assertFalse(root.`val`)
    }

    @Test
    fun testFourByFour() {
        val root = Solution().construct(
            arrayOf(
                intArrayOf(1, 1, 0, 0),
                intArrayOf(1, 1, 0, 0),
                intArrayOf(0, 0, 1, 1),
                intArrayOf(0, 0, 1, 1)
            )
        )!!
        assertFalse(root.isLeaf)
        assertTrue(root.topLeft!!.isLeaf)
        assertTrue(root.topLeft!!.`val`)
        assertTrue(root.topRight!!.isLeaf)
        assertFalse(root.topRight!!.`val`)
        assertTrue(root.bottomLeft!!.isLeaf)
        assertFalse(root.bottomLeft!!.`val`)
        assertTrue(root.bottomRight!!.isLeaf)
        assertTrue(root.bottomRight!!.`val`)
    }

    @Test
    fun testEmpty() {
        assertNull(Solution().construct(arrayOf()))
    }
}
