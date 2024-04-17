package ru.carcrew.boot.version_20.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Как тебя зовут?")
    @Size(min = 2, max = 30, message = "Нет такого имени!")
    @Column(name = "username")
    private String username;
    @NotEmpty(message = "Да, это тоже важное поле...")
    @Size(min = 2, max = 30, message = "Борщ!")
    @Column(name = "nickname")
    private String nickname;
    @NotEmpty(message = "тут тоже надо писать")
    @Email(message = "Загугли что такое Email:)")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Article> articles;
    public User(){

    }
    public User(String username, String nickname){
        this.username = username;
        this.nickname = nickname;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return username;
    }

}
