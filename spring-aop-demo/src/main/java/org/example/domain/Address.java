package org.example.domain;

import lombok.Data;

@Data
public class Address {
    private String province;
    private String city;
    private String county;
    private String detail;
}
