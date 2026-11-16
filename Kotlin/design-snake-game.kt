package designsnakegame

// Time:  O(1) per move
// Space: O(s), s is the current length of the snake.

class SnakeGame(width: Int, height: Int, food: Array<IntArray>) {
    private val food = food
    private var f = 0
    private val width = width
    private val height = height
    private var score = 0
    private val snake = ArrayDeque<IntArray>()
    private val lookup = HashSet<Int>()

    init {
        snake.addLast(intArrayOf(0, 0))
        lookup.add(hash(0, 0))
    }

    fun move(direction: String): Int {
        val dir = DIRECTIONS[direction]!!
        val head = snake.last()
        val x = head[0] + dir[0]
        val y = head[1] + dir[1]
        val tail = snake.first()
        lookup.remove(hash(tail[0], tail[1]))
        snake.removeFirst()
        if (!valid(x, y)) {
            return -1
        } else if (f != food.size && food[f][0] == x && food[f][1] == y) {
            ++score
            ++f
            snake.addFirst(tail)
            lookup.add(hash(tail[0], tail[1]))
        }
        snake.addLast(intArrayOf(x, y))
        lookup.add(hash(x, y))
        return score
    }

    private fun valid(x: Int, y: Int): Boolean {
        if (x < 0 || x >= height || y < 0 || y >= width) {
            return false
        }
        return !lookup.contains(hash(x, y))
    }

    private fun hash(x: Int, y: Int): Int = x * width + y

    companion object {
        private val DIRECTIONS = mapOf(
            "U" to intArrayOf(-1, 0),
            "L" to intArrayOf(0, -1),
            "R" to intArrayOf(0, 1),
            "D" to intArrayOf(1, 0)
        )
    }
}
