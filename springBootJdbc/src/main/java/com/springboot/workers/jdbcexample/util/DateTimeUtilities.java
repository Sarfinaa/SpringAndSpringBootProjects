package com.springboot.workers.jdbcexample.util;

import java.sql.Timestamp;

public class DateTimeUtilities {
public static Timestamp getTimeStamp() {
	return new Timestamp(System.currentTimeMillis());

}
}
