package umc.study.converter;

import umc.study.domain.Address;
import umc.study.domain.Category;
import umc.study.web.dto.AddressRequestDTO;
import umc.study.web.dto.CategoryRequestDTO;

public class CategoryConverter {
    public static Category toCategory(CategoryRequestDTO request){

        return Category.builder()
                .name(request.getName())
                .build();
    }
}
