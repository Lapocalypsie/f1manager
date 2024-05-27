package com.f1manager.demo.Logging;

public class Log {
    public static void errorLog(String message){
        System.err.println(message);
    }
    public static void infoLog(String message){
        System.out.println(message);
    }
    public static void warnLog(String message){
        System.out.println("WARNING : " + message);
    }
    public static void debugLog(String message){
        System.out.println("DEBUG LOG : " + message);
    }
    public static void traceLog(String message){
        System.out.println("TRACE LOG : " + message);
    }
    public static void fatalLog(String message) {
        System.out.println("FATAL LOG : " + message);
    }
}
