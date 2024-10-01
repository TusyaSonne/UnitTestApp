import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    // Функция 1: Проверка, является ли год високосным
    public boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    // Функция 2: Добавление дней к дате
    public LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    // Функция 3: Определение дня недели по дате
    public String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().toString();
    }

    // Функция 4: Проверка, прошла ли дата
    public boolean hasDatePassed(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    // Функция 5: Вычисление разницы в днях между двумя датами
    // Здесь намеренно сделана ошибка: разница всегда возвращается положительной
    public long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end); // Ошибка: всегда возвращаем положительное значение
    }

    // Функция 6: Нахождение следующего високосного года (с ошибкой)
    public int findNextLeapYear(int currentYear) {
        int nextYear = currentYear + 1;
        // Ошибка: учитывается только кратность 4, без проверки на кратность 100 и 400
        while (nextYear % 4 != 0) {
            nextYear++;
        }
        return nextYear;
    }
}
