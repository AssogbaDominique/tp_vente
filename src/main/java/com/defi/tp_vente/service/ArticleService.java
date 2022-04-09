package com.defi.tp_vente.service;

import com.defi.tp_vente.model.Article;
import com.defi.tp_vente.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void saveArticles(Article article){
        articleRepository.save(article);
    }

    public List<Article> showAllArticles(){
        return articleRepository.findAll();
    }

    public Article showOneArticle(int id){
        return articleRepository.findById(id).get();
    }

    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }
}
