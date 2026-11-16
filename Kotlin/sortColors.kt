package sortColorsOld

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    fun sortColors(A: IntArray, n: Int) {
        var red = 0
        var blue = n - 1
        var i = 0
        while (i < blue + 1) {
            if (A[i] == 0) {
                val tmp = A[i]
                A[i] = A[red]
                A[red] = tmp
                ++i
                ++red
            } else if (A[i] == 2) {
                val tmp = A[i]
                A[i] = A[blue]
                A[blue] = tmp
                --blue
            } else {
                ++i
            }
        }
    }
}