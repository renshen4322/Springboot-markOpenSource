package com.mark.springbootmarkopensource.schedule;

import com.mark.springbootmarkopensource.service.impl.CacheManagerImpl;

import java.util.logging.Logger;

public class CacheListener {
    Logger logger = Logger.getLogger("cacheLog");
    private CacheManagerImpl cacheManagerImpl;

    public CacheListener(CacheManagerImpl cacheManagerImpl) {
        this.cacheManagerImpl = cacheManagerImpl;
    }

    public void startListen() {
        new Thread() {
            public void run() {
                while (true) {
                    for (String key : cacheManagerImpl.getAllKeys()) {
                        if (cacheManagerImpl.isTimeOut(key)) {
                            cacheManagerImpl.clearByKey(key);
                            logger.info(key + "缓存被清除");
                        }
                    }
                }
            }
        }.start();

    }

}
