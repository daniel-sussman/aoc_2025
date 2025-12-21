import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayThree

class DayThreeTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(357, DayThree("3t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(17085, DayThree("3a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(3121910778619L, DayThree("3t.txt").second())
    }
}