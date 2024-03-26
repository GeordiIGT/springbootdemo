package com.itheima.demo.controller;

public class SpinResponse {
    public int[] result;
    public int wins;

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
