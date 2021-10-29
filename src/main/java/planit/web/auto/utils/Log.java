package planit.web.auto.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Log {
    private static final Map<String, Logger> loggerInstances = new HashMap<String, Logger>();


    public static void debug(Object clazz, String message) {
        getLogger(clazz).debug(message);
    }

    public static void debug(Object clazz, String message, Object... params) {
        getLogger(clazz).debug(message, params);
    }

    public static void info(Object clazz, String message) {
        getLogger(clazz).info(message);
    }


    public static void info(Object clazz, String message, Object... params) {
        getLogger(clazz).info(message, params);
    }

    public static void warn(Object clazz, String message) {
        getLogger(clazz).warn(message);
    }

    public static void warn(Object clazz, String message, Object... params) {
        getLogger(clazz).warn(message, params);
    }


    public static void trace(Object clazz, String message) {
        getLogger(clazz).trace(message);
    }


    public static void trace(Object clazz, String message, Object... params) {
        getLogger(clazz).trace(message, params);
    }


    public static void error(Object clazz, String message) {
        getLogger(clazz).error(message);
    }

    public static void error(Object clazz, String message, Object... params) {
        getLogger(clazz).error(message, params);
    }

    public static Logger getLogger(Object obj) {
        if (loggerInstances.containsKey(obj.getClass().getSimpleName())) {
            return loggerInstances.get(obj.getClass().getSimpleName());
        } else {
            Logger log = fromFactory(obj.getClass());
            loggerInstances.put(obj.getClass().getSimpleName(), log);
            return log;
        }
    }

    private static Logger fromFactory(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
