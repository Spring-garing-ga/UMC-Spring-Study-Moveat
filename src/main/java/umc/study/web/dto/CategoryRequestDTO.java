package umc.study.web.dto;

import lombok.Getter;

@Getter
public class CategoryRequestDTO {
    public CategoryRequestDTO(String name) {
        this.name = name;
    }

    String name;
}
