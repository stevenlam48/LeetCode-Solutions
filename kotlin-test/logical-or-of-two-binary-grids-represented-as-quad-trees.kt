package logicaloroftwobinarygridsrepresentedasquadtrees

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LogicalOrOfTwoBinaryGridsRepresentedAsQuadTreesTest {
    private fun leaf(value: Boolean) = Node(value, true)

    private fun internal(
        topLeft: Node,
        topRight: Node,
        bottomLeft: Node,
        bottomRight: Node
    ) = Node(true, false, topLeft, topRight, bottomLeft, bottomRight)

    @Test
    fun bothLeaves() {
        val result = Solution().intersect(leaf(true), leaf(false))
        assertTrue(result.isLeaf)
        assertTrue(result.`val`)
        assertNull(result.topLeft)
    }

    @Test
    fun zeroLeafReturnsOtherTree() {
        val other = internal(leaf(true), leaf(false), leaf(false), leaf(true))
        val result = Solution().intersect(leaf(false), other)
        assertSame(other, result)
    }

    @Test
    fun oneLeafReturnsOtherTree() {
        val other = internal(leaf(false), leaf(false), leaf(false), leaf(false))
        val result = Solution().intersect(other, leaf(false))
        assertSame(other, result)
    }

    @Test
    fun collapsesWhenChildrenAgree() {
        val first = internal(leaf(true), leaf(true), leaf(true), leaf(true))
        val second = internal(leaf(false), leaf(true), leaf(false), leaf(true))
        val result = Solution().intersect(first, second)
        assertTrue(result.isLeaf)
        assertTrue(result.`val`)
    }

    @Test
    fun keepsInternalWhenChildrenDiffer() {
        val first = internal(leaf(true), leaf(true), leaf(false), leaf(false))
        val second = internal(leaf(false), leaf(true), leaf(false), leaf(false))
        val result = Solution().intersect(first, second)
        assertFalse(result.isLeaf)
        assertTrue(result.`val`)
        assertTrue(result.topLeft!!.`val`)
        assertTrue(result.topRight!!.`val`)
        assertFalse(result.bottomLeft!!.`val`)
        assertFalse(result.bottomRight!!.`val`)
    }
}
