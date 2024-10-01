import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    // Функция 1: Добавление дней к дате
    public LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    // Функция 2: Определение дня недели по дате
    public String getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().toString();
    }

    // Функция 3: Проверка, прошла ли дата
    public boolean hasDatePassed(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    // Функция 4: Вычисление разницы в днях между двумя датами
    public long daysBetween(LocalDate start, LocalDate end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    // Функция 5: Нахождение следующего високосного года (с ошибкой)
    public int findNextLeapYear(int currentYear) {
        int nextYear = currentYear + 1;
        // Ошибка: учитывается только кратность 4, без проверки на кратность 100 и 400
        while (nextYear % 4 != 0) {
            nextYear++;
        }
        return nextYear;
    }
}
