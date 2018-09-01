package com.myapp.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public final class LogManager implements com.myapp.logging.Logger {

  private static final String APP_LOGGER_NAME = "sampleLog";
  private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(APP_LOGGER_NAME);
  private static final com.myapp.logging.Logger APP_LOGGER;
  private static final char COLAN = ':';
  private static final char HYPEN = '-';

  private static final String CUSTOM_LEVEL_PERFORMANCE = "PERFO";
  private static final Level perfoLevel = Level.getLevel(CUSTOM_LEVEL_PERFORMANCE);
  private static final String ERROR_MSG_PREFIX = "Error Performing Operation.";

  private LogManager() {
    // private constructor to restrict instance creation.
  }

  static {
    APP_LOGGER = new LogManager();
  }

  public static com.myapp.logging.Logger getLogger() {
    return APP_LOGGER;
  }

  private String getMessage(String className, String methodName, String msg) {
    StringBuilder strBuffer = new StringBuilder();
    strBuffer.append(className);
    strBuffer.append(COLAN);
    strBuffer.append(methodName);
    strBuffer.append(HYPEN);
    strBuffer.append(msg);
    return strBuffer.toString();
  }

  @Override
  public void debug(String className, String methodName, String msg) {
    log(Level.DEBUG, className, methodName, msg);
  }

  @Override
  public void debug(String className, String methodName, String msg, Object... parms) {
    log(Level.DEBUG, className, methodName, msg, parms);
  }

  @Override
  public void error(String className, String methodName, String msg) {
    log(Level.ERROR, className, methodName, msg);
  }

  @Override
  public void error(String className, String methodName, String msg, Object... parms) {
    log(Level.ERROR, className, methodName, msg, parms);
  }

  @Override
  public void error(String className, String methodName, Throwable th) {
    logError(className, methodName, ERROR_MSG_PREFIX, th);
  }

  @Override
  public void info(String className, String methodName, String msg) {
    log(Level.INFO, className, methodName, msg);
  }

  @Override
  public void info(String className, String methodName, String msg, Object... parms) {
    log(Level.INFO, className, methodName, msg, parms);
  }

  @Override
  public boolean isDebugEnabled() {
    return LOGGER.isDebugEnabled();
  }

  @Override
  public boolean isTraceEnabled() {
    return LOGGER.isTraceEnabled();
  }

  private void log(Level level, String className, String methodName, String msg) {
    if (LOGGER.isEnabled(level)) {
      LOGGER.log(level, getMessage(className, methodName, msg));
    }
  }

  private void log(Level level, String className, String methodName, String msg, Object... parms) {
    if (LOGGER.isEnabled(level)) {
      LOGGER.log(level, getMessage(className, methodName, msg), parms);
    }
  }

  private void logError(String className, String methodName, String msg, Throwable th) {
    LOGGER.error(getMessage(className, methodName, msg), th);
  }

  @Override
  public void trace(String className, String methodName, String msg) {
    log(Level.TRACE, className, methodName, msg);
  }

  @Override
  public void trace(String className, String methodName, String msg, Object... parms) {
    log(Level.TRACE, className, methodName, msg, parms);
  }

  @Override
  public void warn(String className, String methodName, String msg) {
    log(Level.WARN, className, methodName, msg);
  }

  @Override
  public void warn(String className, String methodName, String msg, Object... parms) {
    log(Level.WARN, className, methodName, msg, parms);
  }

  @Override
  public void performance(String className, String methodName, String msg) {
    LOGGER.log(perfoLevel, getMessage(className, methodName, msg));
  }

  @Override
  public void performance(String className, String methodName, String msg, Object... parms) {
    LOGGER.log(perfoLevel, getMessage(className, methodName, msg), parms);
  }
}
