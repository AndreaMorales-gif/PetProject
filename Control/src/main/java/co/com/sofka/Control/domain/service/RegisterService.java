package co.com.sofka.Control.domain.service;

import co.com.sofka.Control.domain.repository.RegisterData;

public interface RegisterService {
    Iterable<RegisterData> listar();
    String delete(String id);
}
