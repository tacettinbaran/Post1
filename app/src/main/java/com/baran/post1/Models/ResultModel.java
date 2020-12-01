package com.baran.post1.Models;

public class ResultModel {

    private String Result;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "Result='" + Result + '\'' +
                '}';
    }
}
