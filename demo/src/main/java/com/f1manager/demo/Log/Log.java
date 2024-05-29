package com.f1manager.demo.Log;

public class Log {
    /**
     * Affiche un message d'erreur.
     *
     * @param message le message d'erreur à afficher.
     */
    public static void errorLog(String message){
        System.err.println(message);
    }

    /**
     * Affiche un message d'information.
     *
     * @param message le message d'information à afficher.
     */
    public static void infoLog(String message){
        System.out.println(message);
    }

    /**
     * Affiche un message d'avertissement.
     *
     * @param message le message d'avertissement à afficher.
     */
    public static void warnLog(String message){
        System.out.println("WARNING : " + message);
    }

    /**
     * Affiche un message de débogage (utilse en developpement et en recette).
     *
     * @param message le message de débogage à afficher.
     */
    public static void debugLog(String message){
        System.out.println("DEBUG LOG : " + message);
    }

    /**
     * Affiche un message de traçage.
     *
     * @param message le message de traçage à afficher.
     */
    public static void traceLog(String message){
        System.out.println("TRACE LOG : " + message);
    }

    /**
     * Affiche un message d'erreur fatale.
     *
     * @param message le message d'erreur fatale à afficher.
     */
    public static void fatalLog(String message) {
        System.out.println("FATAL LOG : " + message);
    }
}
