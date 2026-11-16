package replacenoncoprimenumbersinarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ReplaceNonCoprimeNumbersInArrayTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(12, 7, 6, 5),
            Solution().replaceNonCoprimes(intArrayOf(6, 4, 3, 2, 7, 6, 5))
        )
    }

    @Test
    fun allCoprime() {
        assertArrayEquals(
            intArrayOf(2, 3, 5),
            Solution().replaceNonCoprimes(intArrayOf(2, 3, 5))
        )
    }

    @Test
    fun chainMergesToSingleValue() {
        assertArrayEquals(
            intArrayOf(36),
            Solution().replaceNonCoprimes(intArrayOf(4, 6, 9))
        )
    }

    @Test
    fun cascadingMerge() {
        assertArrayEquals(
            intArrayOf(210),
            Solution().replaceNonCoprimes(intArrayOf(10, 15, 21))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().replaceNonCoprimes(intArrayOf(1))
        )
    }

    @Test
    fun oneBlocksMerging() {
        assertArrayEquals(
            intArrayOf(2, 1, 3),
            Solution().replaceNonCoprimes(intArrayOf(2, 1, 3))
        )
    }
}
