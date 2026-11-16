package firstuniquenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstUniqueNumberTest {
    @Test
    fun leetCodeExample() {
        val firstUnique = FirstUnique(intArrayOf(2, 3, 5))
        assertEquals(2, firstUnique.showFirstUnique())
        firstUnique.add(5)
        assertEquals(2, firstUnique.showFirstUnique())
        firstUnique.add(2)
        assertEquals(3, firstUnique.showFirstUnique())
        firstUnique.add(3)
        assertEquals(-1, firstUnique.showFirstUnique())
    }

    @Test
    fun allDuplicates() {
        val firstUnique = FirstUnique(intArrayOf(7, 7, 7, 7, 7, 7))
        assertEquals(-1, firstUnique.showFirstUnique())
    }

    @Test
    fun addDuplicatesTheOnlyUnique() {
        val firstUnique = FirstUnique(intArrayOf(1))
        assertEquals(1, firstUnique.showFirstUnique())
        firstUnique.add(1)
        assertEquals(-1, firstUnique.showFirstUnique())
        firstUnique.add(2)
        assertEquals(2, firstUnique.showFirstUnique())
    }

    @Test
    fun emptyInitialList() {
        val firstUnique = FirstUnique(intArrayOf())
        assertEquals(-1, firstUnique.showFirstUnique())
        firstUnique.add(3)
        assertEquals(3, firstUnique.showFirstUnique())
    }
}
