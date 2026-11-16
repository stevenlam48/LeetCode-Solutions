package findproductsofelementsofbigarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindProductsOfElementsOfBigArrayTest {
    @Test
    fun testExample1() {
        val queries = arrayOf(longArrayOf(1, 3, 7))
        assertArrayEquals(intArrayOf(4), Solution().findProductsOfElements(queries))
    }

    @Test
    fun testExample2() {
        val queries = arrayOf(longArrayOf(2, 5, 3), longArrayOf(7, 7, 4))
        assertArrayEquals(intArrayOf(2, 2), Solution().findProductsOfElements(queries))
    }

    @Test
    fun testSinglePosition() {
        // The query [1, 1] covers the second element of the big array, which is 2.
        assertArrayEquals(intArrayOf(2), Solution().findProductsOfElements(arrayOf(longArrayOf(1, 1, 13))))
    }

    @Test
    fun testModuloOne() {
        assertArrayEquals(intArrayOf(0), Solution().findProductsOfElements(arrayOf(longArrayOf(1, 3, 1))))
    }
}
