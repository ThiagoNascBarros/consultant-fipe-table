package br.com.consultantfipetable.service;

import br.com.consultantfipetable.exceptions.FailedConvertJson;
import br.com.consultantfipetable.service.interfaces.ICovertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements ICovertData {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T getData(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new FailedConvertJson(e.getMessage());
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> tClass) {
        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, tClass);
        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            throw new FailedConvertJson(e.getMessage());
        }
    }

}
