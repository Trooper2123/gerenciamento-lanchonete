package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ItenServiceImpl {

    void saveIten(Iten iten);

    List<Iten> findAllItens();

    void deleteById(Long id) throws Exception;

    Optional<Iten> findItenById(Long id);

    Iten findItenByName(String name);

 void updateItenById(Long id, Integer quantity, LocalDateTime updateTime);

}
