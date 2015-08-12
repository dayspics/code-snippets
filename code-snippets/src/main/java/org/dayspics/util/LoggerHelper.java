package org.dayspics.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class LoggerHelper {
	
    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     */
    public static void debug(Class currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.debug(message + "\r\n",args);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     * @param t 记录抛出的异常信息。
     */
    public static void debug(Class currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.debug(message, t);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     */
    public static void info(Class currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.info(message + "\r\n",args);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     * @param t 记录抛出的异常信息。
     */
    public static void info(Class currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.info(message, t);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     */
    public static void warn(Class currentClass, String message,Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.warn(message + "\r\n",args);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     * @param t 记录抛出的异常信息。
     */
    public static void warn(Class currentClass, String message, Throwable t) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.warn(message, t);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     */
    public static void err(Class currentClass, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(currentClass);
        log.error(message + "\r\n",args);
    }

    /**
     *
     * @param currentClass
     * @param message 写入的日志消息
     * @param t 记录抛出的异常信息。
     */
    public static void err(Class currentClass, String message, Throwable t) {
    	Logger log = LoggerFactory.getLogger(currentClass);
    	log.error(message, t);
    }
    
    /**
     *
     * @param name
     * @param message 写入的日志消息
     */
    public static void err(String name, String message,Object... args) {
        Logger log = LoggerFactory.getLogger(name);
        log.error(message + "\r\n",args);
    }
    
    /**
     *
     * @param name
     * @param message 写入的日志消息
     */
    public static void err(String name, String message, Throwable t) {
    	Logger log = LoggerFactory.getLogger(name);
    	log.error(message, t);
    	
    }

    /**
     *
     * @param name
     * @param message 写入的日志消息
     */
    public static void warn(String name, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(name);
        log.warn(message + "\r\n",args);
    }

    /**
     *
     * @param name
     * @param message 写入的日志消息
     */
    public static void info(String name, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(name);
        log.info(message + "\r\n",args);
    }

    /**
     *
     * @param name
     * @param message 写入的日志消息
     */
    public static void debug(String name, String message, Object... args) {
        Logger log = LoggerFactory.getLogger(name);
        log.debug(message + "\r\n",args);
    }
    
    
}
