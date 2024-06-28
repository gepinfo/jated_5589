package com.geppetto.jated.service;

import com.geppetto.jated.dto.NameDto;
import java.util.List;
import java.util.Map;

public interface NameService {

    NameDto create(NameDto nameDto);


    NameDto getEntityById(String id);


    List<NameDto> getAllValues();


    NameDto update(NameDto nameDto);


    String delete(String id);


    List<NameDto> search(Map<String, String> allParams);


}
