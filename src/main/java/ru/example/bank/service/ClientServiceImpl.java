package ru.example.bank.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.bank.dto.ClientFullNameDto;
import ru.example.bank.feign.ClientDataFeignClient;
import ru.example.bank.feign.dto.ClientDataDto;
import ru.example.bank.mapper.ClientDataMapper;
import ru.example.bank.service.api.ClientService;

/**
 * Реализация для {@link ClientService}
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientDataFeignClient clientDataFeignClient;
    private final ClientDataMapper clientDataMapper;

    @Override
    public ClientFullNameDto getClientFullName(Long clientId) {
        ClientDataDto clientDataDto = clientDataFeignClient.getClientNameData(clientId)
                .orElseThrow(() -> new RuntimeException("Не удалось найти клиента с clientId: " + clientId));
        return clientDataMapper.toClientFullNameDto(clientDataDto);
    }

}
