package umc.study.converter;

import umc.study.domain.Address;
import umc.study.domain.Category;
import umc.study.domain.Store;
import umc.study.web.dto.*;
import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store){
        return StoreResponseDTO.JoinResultDTO.builder()
                .name(store.getName())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDto request){

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO(request.getZip_code(), request.getAddress(), request.getDetail(), 0);
        Address address = AddressConverter.toAddress(addressRequestDTO);

        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(request.getCategory_name());
        Category category = CategoryConverter.toCategory(categoryRequestDTO);


        return Store.builder()
                .address(address)
                .name(request.getName())
                .category(category)
                .build();
    }
}
