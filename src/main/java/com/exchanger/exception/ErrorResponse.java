package com.exchanger.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.List;

@XmlRootElement(name = "error")
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    private Instant time;
    private String message;
    private List<String> messages;
}
