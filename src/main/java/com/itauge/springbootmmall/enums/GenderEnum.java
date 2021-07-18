package com.itauge.springbootmmall.enums;

import lombok.Getter;

@Getter
public enum GenderEnum {
    WOMAN(0,"女"),
    MAN(1,"男");

    private Integer code;
    private String value;

    GenderEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }
}
