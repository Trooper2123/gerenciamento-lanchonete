package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.repository.ItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ItenService implements ItenServiceImpl {

    @Autowired
    private ItenRepository itenRepository;

    @Override
    public void saveIten(Iten iten) {
        Random random = new Random();
        iten.setId(random.nextLong());
        iten.setCreateTime(LocalDateTime.now());
    }

    @Override
    public List<Iten> findAllItens() {
        return itenRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (itenRepository.findById(id).get().getQuantity() != 0) {
            itenRepository.deleteById(id);
        } else {
            throw new Exception("Iten não pode ser deletado, pois possui estoque");
        }
    }

    @Override
    public Optional<Iten> findItenById(Long id) {
        return itenRepository.findById(id);
    }

    @Override
    public Iten findItenByName(String name) {
        return itenRepository.findByName(name);
    }

    @Override
    public void updateItenById(Long id, int quantity) {
        Optional<Iten> updated = itenRepository.findById(id);
        updated.get().setQuantity(updated.get().getQuantity() + quantity);
        updated.get().setUpdateTime(LocalDateTime.now());


    }
}
