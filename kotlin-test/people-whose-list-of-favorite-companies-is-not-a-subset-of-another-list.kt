package peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherListTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val favoriteCompanies = listOf(
            listOf("leetcode", "google", "facebook"),
            listOf("google", "microsoft"),
            listOf("google", "facebook"),
            listOf("google"),
            listOf("amazon")
        )
        assertEquals(listOf(0, 1, 4), solution.peopleIndexes(favoriteCompanies))
    }

    @Test
    fun testExample2() {
        val favoriteCompanies = listOf(
            listOf("leetcode", "google", "facebook"),
            listOf("leetcode", "amazon"),
            listOf("facebook", "google")
        )
        assertEquals(listOf(0, 1), solution.peopleIndexes(favoriteCompanies))
    }

    @Test
    fun testSinglePerson() {
        val favoriteCompanies = listOf(listOf("a", "b"))
        assertEquals(listOf(0), solution.peopleIndexes(favoriteCompanies))
    }

    @Test
    fun testIdenticalLists() {
        val favoriteCompanies = listOf(
            listOf("a", "b"),
            listOf("a", "b")
        )
        assertEquals(emptyList<Int>(), solution.peopleIndexes(favoriteCompanies))
    }
}
