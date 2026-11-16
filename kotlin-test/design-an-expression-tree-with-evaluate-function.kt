package designanexpressiontreewithevaluatefunction

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAnExpressionTreeWithEvaluateFunctionTest {
    private val builder = TreeBuilder()

    @Test
    fun testExample1() {
        val tree = builder.buildTree(listOf("3", "4", "+", "2", "*", "7", "/"))
        assertEquals(2, tree.evaluate())
    }

    @Test
    fun testExample2() {
        val tree = builder.buildTree(listOf("4", "5", "2", "7", "+", "-", "*"))
        assertEquals(-16, tree.evaluate())
    }

    @Test
    fun testSimpleAddition() {
        val tree = builder.buildTree(listOf("2", "1", "+", "3", "*"))
        assertEquals(9, tree.evaluate())
    }

    @Test
    fun testSingleNumber() {
        val tree = builder.buildTree(listOf("18"))
        assertEquals(18, tree.evaluate())
    }

    @Test
    fun testSubtraction() {
        val tree = builder.buildTree(listOf("10", "3", "-"))
        assertEquals(7, tree.evaluate())
    }

    @Test
    fun testDivision() {
        val tree = builder.buildTree(listOf("20", "4", "/"))
        assertEquals(5, tree.evaluate())
    }
}
