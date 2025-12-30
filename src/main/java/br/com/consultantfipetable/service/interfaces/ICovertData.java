package br.com.consultantfipetable.service.interfaces;

import java.util.List;

public interface ICovertData {
    <T> T getData(String json, Class<T> tClass);
    <T> List<T> getList(String json, Class<T> tClass);
}
