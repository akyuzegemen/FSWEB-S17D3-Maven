package com.workintech.zoo.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ZooErrorResponse {
    private String message;
    private int status;
    private long timestamp;
}
