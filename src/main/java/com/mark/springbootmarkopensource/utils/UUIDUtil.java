package com.mark.springbootmarkopensource.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtil {
    public UUIDUtil() {
    }

    public static String uuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static String uuid_short() {
        return (new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16)).toString(36);
    }

    public static UUIDUtil.SnowflakeIdWorker snowflake(long workerId, long datacenterId) {
        return new UUIDUtil.SnowflakeIdWorker(workerId, datacenterId);
    }

    public static void main(String[] args) {
        UUIDUtil.SnowflakeIdWorker idWorker = new UUIDUtil.SnowflakeIdWorker(1L, 1L);

        for(int i = 0; i < 1000; ++i) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("今天是yyyy年MM月dd日 E hh:mm:ss，是yyyy年的第DD天，在该月是第dd天");
        System.out.println(format.format(date));



        System.out.println(System.currentTimeMillis());
    }

    public static class SnowflakeIdWorker {
        private final long twepoch = 1546272000000L;
        private final long workerIdBits = 5L;
        private final long datacenterIdBits = 5L;
        private final long maxWorkerId = 31L;
        private final long maxDatacenterId = 31L;
        private final long sequenceBits = 12L;
        private final long workerIdShift = 12L;
        private final long datacenterIdShift = 17L;
        private final long timestampLeftShift = 22L;
        private final long sequenceMask = 4095L;
        private long workerId;
        private long datacenterId;
        private long sequence = 0L;
        private long lastTimestamp = -1L;

        public SnowflakeIdWorker(long workerId, long datacenterId) {
            if (workerId <= 31L && workerId >= 0L) {
                if (datacenterId <= 31L && datacenterId >= 0L) {
                    this.workerId = workerId;
                    this.datacenterId = datacenterId;
                } else {
                    throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", 31L));
                }
            } else {
                throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", 31L));
            }
        }

        public synchronized long nextId() {
            long timestamp = this.timeGen();
            if (timestamp < this.lastTimestamp) {
                throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
            } else {
                if (this.lastTimestamp == timestamp) {
                    this.sequence = this.sequence + 1L & 4095L;
                    if (this.sequence == 0L) {
                        timestamp = this.tilNextMillis(this.lastTimestamp);
                    }
                } else {
                    this.sequence = 0L;
                }

                this.lastTimestamp = timestamp;
                return timestamp - 1546272000000L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
            }
        }

        protected long tilNextMillis(long lastTimestamp) {
            long timestamp;
            for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            }

            return timestamp;
        }

        protected long timeGen() {
            return System.currentTimeMillis();
        }
    }
}
