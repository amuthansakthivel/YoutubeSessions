package com.assertj;



import org.assertj.jodatime.api.Assertions;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

public class AssertJodaDemo {
	
	@Test
	public void dateTimeTest() {
		
		LocalDate date = new LocalDate(2000,1,1); //org.joda.time.LocalDate
		
		Assertions.assertThat(date)
			.hasYear(2000)
            .hasMonthOfYear(1)
            .hasDayOfMonth(1)
            .isBefore(new LocalDate(2000, 1, 2))
            .isBefore("2000-01-02")
            .isBeforeOrEqualTo(new LocalDate(2000, 1, 1))
            .isBeforeOrEqualTo("2000-01-01")
            .isBeforeOrEqualTo(new LocalDate(2000, 1, 2))
            .isBeforeOrEqualTo("2000-01-02")
            .isEqualTo(new LocalDate(2000, 1, 1))
            .isEqualTo("2000-01-01")
            .isAfterOrEqualTo(new LocalDate(2000, 1, 1))
            .isAfterOrEqualTo("2000-01-01")
            .isAfterOrEqualTo(new LocalDate(1999, 12, 31))
            .isAfterOrEqualTo("1999-12-31")
            .isAfter(new LocalDate(1999, 12, 31))
            .isAfter("1999-12-31")
            .isNotEqualTo("2000-01-15")
            .isNotEqualTo(new LocalDate(2000, 1, 15))
            .isIn(new LocalDate(1999, 12, 31), new LocalDate(2000, 1, 1))
            .isIn("1999-12-31", "2000-01-01")
            .isNotIn(new LocalDate(1999, 12, 31), new LocalDate(2000, 1, 2))
            .isNotIn("1999-12-31", "2000-01-02");
        
		
	}

}
