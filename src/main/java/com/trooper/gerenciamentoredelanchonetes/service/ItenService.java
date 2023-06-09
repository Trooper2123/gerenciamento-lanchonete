package com.trooper.gerenciamentoredelanchonetes.service;

import com.trooper.gerenciamentoredelanchonetes.model.Iten;
import com.trooper.gerenciamentoredelanchonetes.repository.ItenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ItenService implements ItenServiceImpl {

    @Autowired
    private ItenRepository itenRepository;

    @Override
    public void saveIten(Iten iten) {
        iten.setCreateTime(LocalDateTime.now());
        itenRepository.save(iten);
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
    @Transactional
    public void updateItenById(Long id, Integer quantity,LocalDateTime updateTime){
        if (itenRepository.findById(id).isEmpty()){

        }else {
            itenRepository.updateQuantity(id,quantity, LocalDateTime.now());
        }



    }
}
