package com.inoptra.employeedepartmentdemo.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorModel {
    private LocalDateTime timeStamp;
    private int errorCode;
    private String userMessage;
}
