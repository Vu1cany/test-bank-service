package ru.example.bank.service.api;


import ru.example.bank.dto.ClientFullNameDto;

/**
 * Сервис для работы с данными о клиентах.
 */
public interface ClientService {

    /**
     * Получение полного имени клиента.
     *
     * @param clientId идентификатор клиента
     */
    ClientFullNameDto getClientFullName(Long clientId);

}
