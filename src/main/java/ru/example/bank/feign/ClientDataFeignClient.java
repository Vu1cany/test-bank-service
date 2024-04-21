package ru.example.bank.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.example.bank.feign.dto.ClientDataDto;

import java.util.Optional;

/**
 * Клиент для взаимодействия с вымышленным сервисом клиентов.
 */
@FeignClient(name = "client-data-feign-client", url = "${feign.client-data}")
public interface ClientDataFeignClient {

    /**
     * Получить данные о имени клиента.
     *
     * @param clientId идентификатор клиента
     * @return данные о имени клиента
     */
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/client/{clientId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Optional<ClientDataDto> getClientNameData(@PathVariable Long clientId);

}
