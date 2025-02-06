package resources;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Horarios;

public class Availables {

    public static String obtenerDiaSemana(String fechaStr) {
        // Formato de la fecha de entrada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);

        // Obtener el día de la semana en español
        DayOfWeek diaSemana = fecha.getDayOfWeek();

        // Traducción de los días (ajustada a tu formato)
        String[] diasSemana = { "L/A", "M/A", "X", "J/O", "V/O", "sábado", "domingo" };

        return diasSemana[diaSemana.getValue() - 1]; // getValue() devuelve 1 para lunes, 7 para domingo
    }

    public static int obtenerFranjaHoraria(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
        LocalTime hora = fecha.toLocalTime();

        // Definir las franjas horarias
        if (!hora.isBefore(LocalTime.of(8, 0)) && hora.isBefore(LocalTime.of(9, 0))) return 1;
        if (!hora.isBefore(LocalTime.of(9, 30)) && hora.isBefore(LocalTime.of(10, 0))) return 2;
        if (!hora.isBefore(LocalTime.of(10, 0)) && hora.isBefore(LocalTime.of(11, 0))) return 3;
        if (!hora.isBefore(LocalTime.of(11, 30)) && hora.isBefore(LocalTime.of(12, 30))) return 4;
        if (!hora.isBefore(LocalTime.of(12, 30)) && hora.isBefore(LocalTime.of(13, 30))) return 5;

        return 0; // Si no está en ninguna franja
    }

    public static boolean isConflict(String date, ArrayList<Horarios> teacherSchedule) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Eliminar milisegundos si existen
        date = date.split("\\.")[0]; // Eliminar todo después del punto
        
        LocalDateTime fecha = LocalDateTime.parse(date, formatter);

        for (Horarios horario : teacherSchedule) {
            int horaInicio = Character.getNumericValue(horario.getId().getHora());

            if (horaInicio < 0 || horaInicio > 23) continue;

            LocalDateTime start = fecha.withHour(horaInicio).withMinute(0).withSecond(0);
            LocalDateTime end = start.plusHours(1);

            // Asegúrate de que la fecha esté en el rango de las 12:30 a las 13:30
            if (!fecha.isBefore(start) && fecha.isBefore(end)) {
                return true;
            }
        }
        return false;
    }
}
