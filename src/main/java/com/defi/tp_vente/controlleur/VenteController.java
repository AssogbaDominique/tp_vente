package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Vente;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/venteshow")
    public String showAllVentes(Model model)
    {
        model.addAttribute("Liste_Ventes",venteService.showAllVentes());
        return "Medilab/Vente/ListeVente";
    }
    @GetMapping("/venteform")
    public String showFromVente(Model model) {
        model.addAttribute("Liste_Ventes",articleService.showAllArticles());
        return  "Medilab/Vente/formVente"; }

    @PostMapping("/vente/save")
    public String saveVente(Vente vente){
        vente.setQteVente(vente.getQteVente());
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        articleService.degrade(vente.getQteVente(),vente.getArticle_id());
        return "redirect:/venteshow";
    }
    @GetMapping("/venteedit{id}")
    public String venteEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_vente",venteService.showOneVente(id));
        model.addAttribute("listeVente",articleService.showAllArticles());
        return "Medilab/vente/venteEdit";
    }
    @PostMapping("vente/update")
    public  String updateVente(@ModelAttribute("vente") Vente vente){
        venteService.saveVente(vente);
        return "redirect:/venteshow";

    }
    @GetMapping("/ventedel{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/venteshow";

    }
}
