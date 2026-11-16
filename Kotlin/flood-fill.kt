package floodfill

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val color = image[sr][sc]
        if (color == newColor) return image
        dfs(image, sr, sc, newColor, color)
        return image
    }

    private fun dfs(image: Array<IntArray>, r: Int, c: Int, newColor: Int, color: Int) {
        if (r < 0 || r >= image.size ||
            c < 0 || c >= image[0].size ||
            image[r][c] != color
        ) {
            return
        }
        image[r][c] = newColor
        for (d in DIRECTIONS) {
            dfs(image, r + d[0], c + d[1], newColor, color)
        }
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )
    }
}
