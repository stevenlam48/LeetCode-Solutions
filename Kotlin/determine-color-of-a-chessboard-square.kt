package determinecolorofachessboardsquare

// Time:  O(1)
// Space: O(1)

class Solution {
    fun squareIsWhite(coordinates: String): Boolean =
        (coordinates[0] - 'a') % 2 != (coordinates[1] - '1') % 2
}
