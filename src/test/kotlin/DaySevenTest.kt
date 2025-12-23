import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import solutions.DaySeven

class DaySevenTest {
    @Test
    fun partOneIsCorrect() {
        assertEquals(21, DaySeven("7t.txt").first())
    }

    @Test
    fun partOneIsReallyCorrect() {
        assertEquals(1598, DaySeven("7a.txt").first())
    }

    @Test
    fun partTwoIsCorrect() {
        assertEquals(40, DaySeven("7t.txt").second())
    }

    @Test
    fun partTwoIsDefinitelyCorrect() {
        assert(DaySeven("7a.txt").second() > 68727457238L) // got the wrong answer due to counting with Int rather than Long
    }
}