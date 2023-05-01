package com.shop.choisi.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeUtil {

    public static Long nowGMT0() {
        return Instant.now().toEpochMilli();
    }

    public static LocalDateTime utcToLocalDateTimeGMT3(Long millis) {
        return utcToLocalDateTime(millis, ZoneId.of("GMT+3"));
    }

    public static LocalDateTime utcToLocalDateTime(Long millis, ZoneId zoneId) {
        Instant instant = Instant.ofEpochSecond(millis);
        return LocalDateTime.ofInstant(instant, zoneId);
    }
}
