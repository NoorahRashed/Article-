package com.example.demo.Component;

import com.example.demo.models.Article;
import com.example.demo.models.Comment;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.reposetory.ArticleRepo;
import com.example.demo.reposetory.CommentRepo;
import com.example.demo.reposetory.RoleRebo;
import com.example.demo.reposetory.UserRebo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
@Component
public class DbInit {
    private RoleRebo roleRebo;
    private UserRebo userRebo;
    private ArticleRepo articleRepo;
    private CommentRepo commentRepo;
    @Autowired
    public DbInit(RoleRebo roleRebo,UserRebo userRebo,ArticleRepo articleRepo,CommentRepo commentRepo) {
        this.roleRebo = roleRebo;
        this.userRebo=userRebo;
        this.articleRepo=articleRepo;
        this.commentRepo=commentRepo;
    }
    @PostConstruct
    private void postConstruct(){
        Role userrole = new Role(1,"USER");
        Role adminrole = new Role(2,"ADMIN");
//        Role role = new Role();
//        role.setId(3);
//        role.setRoleName("new");
//
//        roleRebo.save(role);
        roleRebo.save(userrole);
        roleRebo.save(adminrole);

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        User user= new User(1,
                "Norah",
                "Norah@gmail.com",
                "0587438296",
                bCryptPasswordEncoder.encode("norah123"),
                new ArrayList<>(),
                Arrays.asList(userrole,adminrole));

        User user1= new User(2,
                "Aljoharah",
                "Aljoharah@gmail.com",
                "0587438296",
                bCryptPasswordEncoder.encode("Aljoharah123"),
                new ArrayList<>(),
                Arrays.asList(userrole));

        User user2= new User(3,
                "Lama",
                "Lama@gmail.com",
                "0587438296",
                bCryptPasswordEncoder.encode("lama123"),
                new ArrayList<>(),
                Arrays.asList(adminrole));

        userRebo.save(user);
        userRebo.save(user1);
        userRebo.save(user2);

        Article article1=new Article(
          1,
          user1.getUsername(),
          "Mental Health",
          "Mental health includes our emotional, psychological, and social well-being. It affects how we think, feel, and act.",
          null,
                user1,
                new ArrayList<>(),
          304,
          14,
          false );

        Article article2=new Article(
                2,
                user2.getUsername(),
                "programing",
                "Hello World is the most common word that any programmer will defiantly know.",
                null,
                user2,
                new ArrayList<>(),
                984,
                38,
                false );

        Article article3=new Article(
                3,
                user.getUsername(),
                "Artificial intelligence",
                "in its broadest sense, is intelligence exhibited by machines, particularly computer systems. It is a field of research in computer science that develops and studies methods and software that enable machines to perceive their environment and use learning and intelligence to take actions that maximize their chances of achieving defined goals.",
                null,
                user,
                new ArrayList<>(),
                2689,
                478,
                false );
        Article article4=new Article(
                4,
                user2.getUsername(),
                "Article to go",
                "the people read articles to achieving defined goals.",
                null,
                user2,
                new ArrayList<>(),
                3570,
                658,
                false );
        Article article5=new Article(
                5,
                user.getUsername(),
                "Hi some info to know me ",
                "I am a student in the cdog college i like to spend my free time with my family i study in medical school .",
                null,
                user,
                new ArrayList<>(),
                9876,
                1257,
                false );
        Article article6=new Article(
                6,
                user1.getUsername(),
                "this is Title",
                "hear are the the content that you want every one to see .",
                null,
                user1,
                new ArrayList<>(),
                3570,
                658,
                false );

        articleRepo.save(article1);
        articleRepo.save(article2);
        articleRepo.save(article3);
        articleRepo.save(article4);
        articleRepo.save(article5);
        articleRepo.save(article6);

        Comment comment=new Comment(1,
                user.getUsername(),"i didn't know",
                null,user,article2);
        Comment comment1=new Comment(2,
                user2.getUsername(),"this is correct",
                null,user2,article2);
        Comment comment2=new Comment(3,
                user.getUsername(),"this is magical word",
                null,user,article1);
        Comment comment3=new Comment(4,
                user1.getUsername(),"what do you mean",
                null,user1,article1);

        commentRepo.save(comment);
        commentRepo.save(comment1);
        commentRepo.save(comment2);
        commentRepo.save(comment3);
    }

}
