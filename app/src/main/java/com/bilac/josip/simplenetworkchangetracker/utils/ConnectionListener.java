package com.bilac.josip.simplenetworkchangetracker.utils;

public interface ConnectionListener {

    void checkConnState();

    void connWentOnline();

    void connWentOffline();
}

