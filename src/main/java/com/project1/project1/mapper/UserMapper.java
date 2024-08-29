package com.project1.project1.mapper;

import com.project1.project1.domain.User;
import com.project1.project1.dto.UserDTO;
import com.project1.project1.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //DTO -> Domain 변환
    @Mapping(target = "id", ignore = true)
    //@Mapping(target = "createdAt", ignore = true)
    User toDomain(UserDTO dto);

    // Domain -> DTO 변환
    UserResponseDTO toDTO(User user);
}
