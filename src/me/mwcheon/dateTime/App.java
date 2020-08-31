package me.mwcheon.dateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        //이전
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat();

        //instant 기계식
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT

        //내가 있는 로컬을 기준으로 시간을 보겠다
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);


        //localDataTime 휴먼용
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime.of(2020, Month.APRIL, 15, 6, 0,0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);


        //기간을 표현하는 방법
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthData = LocalDate.of(2021,Month.MARCH, 1);

        //휴먼용
        Period period = Period.between(today, thisYearBirthData);
        System.out.println(period);

        Period untils = today.until(thisYearBirthData);
        System.out.println(untils.get(ChronoUnit.DAYS));

        //머신용
        Instant now2 = Instant.now();
        Instant plus = now2.plus(10, ChronoUnit.SECONDS);

        Duration between = Duration.between(now2, plus);
        System.out.println(between);

        //포맷팅
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter MMDDYY = DateTimeFormatter.ofPattern("MM/DD/yyyy");
        System.out.println(dateTime.format(MMDDYY));

        //파싱
        LocalDate parse = LocalDate.parse("06/12/1945", MMDDYY);
        System.out.println(parse);


         
    }
}
