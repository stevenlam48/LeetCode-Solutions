package findallpossiblerecipesfromgivensupplies

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllPossibleRecipesFromGivenSuppliesTest {
    @Test
    fun oneRecipe() {
        assertEquals(
            listOf("bread"),
            Solution().findAllRecipes(
                listOf("bread"),
                listOf(listOf("yeast", "flour")),
                listOf("yeast", "flour", "corn")
            )
        )
    }

    @Test
    fun recipeUsedAsIngredient() {
        assertEquals(
            listOf("bread", "sandwich"),
            Solution().findAllRecipes(
                listOf("bread", "sandwich"),
                listOf(listOf("yeast", "flour"), listOf("bread", "meat")),
                listOf("yeast", "flour", "meat")
            )
        )
    }

    @Test
    fun chainOfRecipes() {
        assertEquals(
            listOf("ju", "fzjnm", "q"),
            Solution().findAllRecipes(
                listOf("ju", "fzjnm", "q"),
                listOf(listOf("d"), listOf("hveml", "f", "cpivl"), listOf("cpivl", "xlv")),
                listOf("d", "hveml", "f", "cpivl", "xlv")
            ).sortedWith(compareBy { listOf("ju", "fzjnm", "q").indexOf(it) })
        )
    }

    @Test
    fun cyclicRecipesCannotBeMade() {
        assertEquals(
            emptyList<String>(),
            Solution().findAllRecipes(
                listOf("a", "b"),
                listOf(listOf("b"), listOf("a")),
                listOf("supply")
            )
        )
    }
}
