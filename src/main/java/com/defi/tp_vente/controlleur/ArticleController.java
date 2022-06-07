package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Article;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ArticleController {
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/artshow")
    public String showAllArticle(Model model)
    {
        model.addAttribute("listeArticle",articleService.changerEtatArticle(articleService.showAllArticles()));
        return "Medilab/article/listeArticle";
    }
    @GetMapping("/artform")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "Medilab/article/formArticle";
    }
    @PostMapping("/article/save")
    public String saveArticle(Article article)
    {
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticles(article);
        return "redirect:/artshow";
    }
    @GetMapping("/artedit{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        model.addAttribute( "Un_article",articleService.showOneArticle(id));
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "Medilab/article/formEdit";
    }
    @PostMapping("article/update")
    public String updateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticles(article);
        return "redirect:/artshow";
    }
    @GetMapping("/artdel{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/artshow";
    }
    @GetMapping("artetatSeuil")
    public String listeSeuil(Model model){
        model.addAttribute("listeSeuil",articleService.articleEtatCritique(articleService.showAllArticles()));
        return "Medilab/article/listeSeuil";
    }
    @GetMapping("/artname")
    public String Liste(Model model, @RequestParam String libelle){
        model.addAttribute("listeByNamer",articleService.findByLibelle(libelle));
        return "/Medilab/article/ListeName";
    }

    @PostMapping("/artnom")
    public String listeByname(@RequestParam String desi){
        articleService.findByLibelle(desi);
        return "redirect:/artname";
    }
}
