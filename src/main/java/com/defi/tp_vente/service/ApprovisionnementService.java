package com.defi.tp_vente.service;


import com.defi.tp_vente.model.Approvisionnement;
import com.defi.tp_vente.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;
    public void saveApprovisionnement(Approvisionnement approvisionnement)
    {
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllApprovisionnements() { return approvisionnementRepository.findAll(); }

    public Optional<Approvisionnement> showOneApprovisionnement(int id) { return approvisionnementRepository.findById(id); }

    public void deleteApprovisionnement(int id) { approvisionnementRepository.deleteById(id); }

}
