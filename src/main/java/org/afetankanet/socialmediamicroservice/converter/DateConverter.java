package org.afetankanet.socialmediamicroservice.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    private static final SimpleDateFormat twitterDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);

    public static Date convertStringToDate(String dateString) {
        // Gelen tarih string'inin zaman dilimi bilgisini kullanarak GMT+3 olarak ayarla
        twitterDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));

        try {
            // Gelen tarihi Türkiye saati (GMT+3) olarak parse et
            Date date= twitterDateFormat.parse(dateString);

            // Calendar örneğini al ve mevcut tarihi ayarla
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // 3 saat ileriye taşı
            calendar.add(Calendar.HOUR_OF_DAY, 3);

            // Güncellenmiş tarihi al
            return calendar.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void main(String[] args) {
        String testDate = "Sat Dec 23 09:19:04 +0000 2023";
        Date convertedDate = convertStringToDate(testDate);

        LocalDateTime localDateTime = convertDateToLocalDateTime(convertedDate);

        System.out.println("LocalDateTime: " + localDateTime);

        System.out.println("Converted Date: " + convertedDate);
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        // Date nesnesini Instant'a çevir
        Instant instant = date.toInstant();

        // Instant'ı sistem varsayılan zaman dilimine göre LocalDateTime'a çevir
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
