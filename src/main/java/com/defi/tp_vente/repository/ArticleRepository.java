package com.defi.tp_vente.repository;

import com.defi.tp_vente.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    @Modifying
    @Transactional
    //@Query("UPDATE Article SET qteStock=qteStock+qte where id = idArticle");
    @Query("UPDATE Article a SET a.qteStock = a.qteStock+:qte where a.id=:idArticle")
    void updateStockArticle(@Param("qte") int qte, @Param("idArticle") int idArticle);

    @Query("select a from Article a where a.libelle like %?1%")
    List<Article> findByName(String desi);

    @Modifying
    @Transactional
    @Query("Update Article v set v.qteStock=v.qteStock -:qte_art where v.id=:id_Art")
    void degradeStockArticle(@Param("qte_art") int qte_art, @Param("id_Art") int id_Art);


}
