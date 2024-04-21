package ru.example.bank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.bank.dto.ClientFullNameDto;
import ru.example.bank.service.api.ClientService;

/**
 * Контроллер для взаимодействия с данными о клиентах.
 */
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/{clientId}/name")
    public ClientFullNameDto getClientName(@PathVariable Long clientId) {
        return clientService.getClientFullName(clientId);
    }

}
