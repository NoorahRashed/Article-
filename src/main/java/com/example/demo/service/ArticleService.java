package com.example.demo.service;

import com.example.demo.Mapper.ArticleMapper;
import com.example.demo.dto.ArticleDto;
import com.example.demo.excption.ArticleNotFoundExcption;
import com.example.demo.excption.UserNotFoundExcption;
import com.example.demo.models.Article;
import com.example.demo.models.User;
import com.example.demo.models.reposetory.ArticleRepo;
import com.example.demo.models.reposetory.UserRebo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ArticleService {

    private ArticleRepo articleRepo;
    private UserRebo userRebo;
    @Autowired
    public ArticleService(ArticleRepo articleRepo, UserRebo userRebo) {
        this.articleRepo = articleRepo;
        this.userRebo = userRebo;
    }

    public Article addarticle(Integer userid,Article article){
        User user= userRebo.findById(userid).orElseThrow(()->new UserNotFoundExcption("I Can't Find The User"));
        log.info(user.getUsername());
        article.setUser(user);
        article.setTitle(article.getTitle());
        article.setBody(article.getBody());
        article.setAuthor(user.getUsername());
        article.setLikes(article.getDisLikes());
        article.setDisLikes(article.getDisLikes());
        log.info(article.toString());
        return this.articleRepo.save(article);
    }

    public ArticleDto getarticle(Integer id) {
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("I Can't Find The Article"));
        if (article.isDisabled()){return null;}
        else {return ArticleMapper.Article2ArticleDto(article);}
    }


    public List<ArticleDto> getarticles(int page, int size){
        Pageable pageable= PageRequest.of(page, size);
        return articleRepo.findAll(pageable).getContent()
                .stream().map(ArticleMapper::Article2ArticleDto).toList();
    }
    public void delete (Integer id){
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("This Article already not exists"));
        this.articleRepo.deleteById(id);
    }
    public Article putliks(Integer id, Integer likeit){
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("I Can't Find The Article"));
        article.setLikes(likeit);
        return articleRepo.save(article);
    }
    public Article putdisliks(Integer id,Integer dislikeit){
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("I Can't Find The Article"));
        article.setDisLikes(dislikeit);
        return articleRepo.save(article);
    }
    public Article disable(Integer id){
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("I Can't Find The Article"));
        article.setDisabled(true);
        return articleRepo.save(article);
    }
    public Article enable(Integer id){
        Article article=articleRepo.findById(id)
                .orElseThrow(()->new ArticleNotFoundExcption("I Can't Find The Article"));
        article.setDisabled(false);
        return articleRepo.save(article);
    }

}
