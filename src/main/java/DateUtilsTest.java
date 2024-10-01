
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class DateUtilsTest {

    private final DateUtils dateUtils = new DateUtils();

    // Тестирование функции проверки на високосный год
    @Test
    public void testIsLeapYear() {
        assertTrue(dateUtils.isLeapYear(2020)); // Високосный год
        assertFalse(dateUtils.isLeapYear(2021)); // Не високосный год
        assertTrue(dateUtils.isLeapYear(2000)); // Високосный
        assertFalse(dateUtils.isLeapYear(1900)); // Не високосный
    }

    // Тестирование функции добавления дней к дате
    @Test
    public void testAddDays() {
        LocalDate date = LocalDate.of(2023, 9, 28);
        LocalDate result = dateUtils.addDays(date, 10);
        assertEquals(LocalDate.of(2023, 10, 8), result);
    }

    // Тестирование функции получения дня недели
    @Test
    public void testGetDayOfWeek() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        assertEquals("MONDAY", dateUtils.getDayOfWeek(date)); // 1 января 2024 года - это понедельник
    }

    // Тестирование функции проверки, прошла ли дата
    @Test
    public void testHasDatePassed() {
        LocalDate pastDate = LocalDate.of(2020, 1, 1);
        assertTrue(dateUtils.hasDatePassed(pastDate)); // Дата в прошлом

        LocalDate futureDate = LocalDate.of(2050, 1, 1);
        assertFalse(dateUtils.hasDatePassed(futureDate)); // Дата в будущем
    }

    // Тестирование функции вычисления разницы в днях
    @Test
    public void testDaysBetween() {
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 1, 10);

        assertEquals(9, dateUtils.daysBetween(start, end)); // Разница 9 дней


        assertEquals(-9, dateUtils.daysBetween(end, start));
    }

    @Test
    public void testFindNextLeapYear() {
        assertEquals(2024, dateUtils.findNextLeapYear(2023)); // Ожидаем, что 2024 будет следующим
        assertEquals(2028, dateUtils.findNextLeapYear(2025)); // Следующий после 2025 - 2028

        // Скрытая ошибка: 1900 не високосный, хотя кратен 4
        assertEquals(1904, dateUtils.findNextLeapYear(1899)); // Ожидаем, что будет 1904

        // Проверка на год 2000 (должен быть високосным)
        assertEquals(2000, dateUtils.findNextLeapYear(1999));
    }
}
