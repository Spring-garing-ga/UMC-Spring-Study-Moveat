package umc.study.converter;

import umc.study.domain.Address;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.AddressRequestDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO(request.getZip_code(), request.getAddress(), request.getDetail(), 0);
        Address address = AddressConverter.toAddress(addressRequestDTO);

        return User.builder()
                .address(address)
                .gender(gender)
                .name(request.getName())
                .birth(request.getBirth())
                .build();
    }
}