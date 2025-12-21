import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DayOne

class DayOneTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(3, DayOne("1t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(1064, DayOne("1a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(6, DayOne("1t.txt").second())
    }
}