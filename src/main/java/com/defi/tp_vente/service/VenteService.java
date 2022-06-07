package com.defi.tp_vente.service;

import com.defi.tp_vente.model.Vente;
import com.defi.tp_vente.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    private VenteRepository venteRepository;
    public void saveVente(Vente vente) { venteRepository.save(vente); }

    public List<Vente> showAllVentes() { return venteRepository.findAll(); }

    public Vente showOneVente(int id) { return venteRepository.findById(id).get(); }

    public void deleteVente(int id) { venteRepository.deleteById(id); }
}
