package ru.example.bank.feign.dto;

import lombok.Data;

@Data
public class ClientDataDto {

    private Long id;

    private String clientFirstName;

    private String clientLastName;

}
