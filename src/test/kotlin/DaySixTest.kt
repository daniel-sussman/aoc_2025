import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DaySix

class DaySixTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(4277556, DaySix("6t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(5346286649122, DaySix("6a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(3263827, DaySix("6t.txt").second())
    }
}