package com.arahlf.cribbage;

import java.util.ArrayList;
import java.util.List;

public final class Logger {
    
    public static synchronized void log(String message) {
        _messages.add(message);
        
        for (LoggerListener listener : _listeners) {
            listener.onLog(message);
        }
    }
    
    public static synchronized void addListener(LoggerListener listener) {
        _listeners.add(listener);
    }
    
    private Logger() {
    }
    
    
    private static final List<String> _messages = new ArrayList<String>();
    private static final List<LoggerListener> _listeners = new ArrayList<LoggerListener>();
    
    public static interface LoggerListener {
        /**
         * Callback for when a new message is logged.
         * @param message
         */
        public void onLog(String message);
    }
}
