
package config;

import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;



public class AgeCalculator {
    
     public static int calculateAge(Date dateOfBirth) {
        LocalDate birthDate = dateOfBirth.toLocalDate();
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
    
}
