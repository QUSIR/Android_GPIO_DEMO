package com.gpio.demo;

public class GpioJni {
    static {
        System.loadLibrary("native-lib");
    }
    public native int SetGpio();
}
