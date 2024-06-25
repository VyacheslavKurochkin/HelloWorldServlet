package ru.kurochkin.helloworldservlet.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Listener2: запрос обработан");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Listener2: пришел запрос");
    }
}