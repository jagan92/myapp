package com.myapp.logging;

public interface Logger {

  boolean isTraceEnabled();

  boolean isDebugEnabled();

  void trace(String className, String methodName, String msg);

  void trace(String className, String methodName, String msg, Object... parms);

  void debug(String className, String methodName, String msg);

  void debug(String className, String methodName, String msg, Object... parms);

  void info(String className, String methodName, String msg);

  void info(String className, String methodName, String msg, Object... parms);

  void warn(String className, String methodName, String msg);

  void warn(String className, String methodName, String msg, Object... parms);

  void error(String className, String methodName, String msg);

  void error(String className, String methodName, String msg, Object... parms);

  void error(String className, String methodName, Throwable th);

  // Custom Log level
  void performance(String className, String methodName, String msg);

  void performance(String className, String methodName, String msg, Object... parms);
}
