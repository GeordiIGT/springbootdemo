package com.geordi.demo.controller;

public class SpinResponse {
    private int[] result;
    private int wins;

    public SpinResponse() {
        this.result = new int[3];
        for (int i = 0; i < 3; i++) {
            this.result[i] = (int) (Math.random() * 3);
        }
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }
}
