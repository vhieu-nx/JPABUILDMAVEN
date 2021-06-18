package com.codegym.converter;

import com.codegym.dto.NewDTO;
import com.codegym.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewDTO toDto(NewEntity entity){
        NewDTO result = new NewDTO();
        result.setId(entity.getId());
        result.setTitle(entity.getTitle());
        result.setShortDescription(entity.getShortDescription());
        result.setContent(entity.getContent());
        result.setThumbnail(entity.getThumbnail());
        result.setCategoryCode(entity.getCategoryEntity().getCode());
        return  result;
    }
    public NewEntity toEntity(NewDTO newDTO){
        NewEntity result = new NewEntity();
        result.setTitle(newDTO.getTitle());
        result.setShortDescription(newDTO.getShortDescription());
        result.setContent(newDTO.getContent());
        result.setThumbnail(newDTO.getThumbnail());
        return result;
    }
    //tra ve enity dưa tren entity da co
    public NewEntity toEntity(NewEntity result,NewDTO newDTO){
        result.setTitle(newDTO.getTitle());
        result.setShortDescription(newDTO.getShortDescription());
        result.setContent(newDTO.getContent());
        result.setThumbnail(newDTO.getThumbnail());
        return result;
    }
}
