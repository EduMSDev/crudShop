package com.sprinter.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorMessage {

    private int code;
    private Date date;
    private String message;
    private String description;
}
