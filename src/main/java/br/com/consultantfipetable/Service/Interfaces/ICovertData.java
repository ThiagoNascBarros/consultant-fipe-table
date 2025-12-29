package br.com.consultantfipetable.Service.Interfaces;

import java.util.List;

public interface ICovertData {
    <T> T getData(String json, Class<T> tClass);
    <T> List<T> getList(String json, Class<T> tClass);
}
