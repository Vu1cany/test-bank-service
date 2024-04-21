package ru.example.bank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.example.bank.dto.ClientFullNameDto;
import ru.example.bank.feign.dto.ClientDataDto;

@Mapper(componentModel = "spring")
public interface ClientDataMapper {

    @Mapping(target = "fullName", source = "clientDataDto", qualifiedByName = "getConcatFullName")
    ClientFullNameDto toClientFullNameDto(ClientDataDto clientDataDto);

    @Named("getConcatFullName")
    default String getConcatFullName(ClientDataDto clientDataDto){
        return String.format("%s %s", clientDataDto.getClientLastName(), clientDataDto.getClientFirstName());
    }

}
