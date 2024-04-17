package ru.carcrew.boot.version_20.models;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Size(min = 5, max = 5000, message = "Ту мач!")
    @NotEmpty(message = "Поле не должно быть пустым!")
    @Column(name = "content")
    private String content;

    @Size(min = 2, max = 50, message = "Придумай что то получше")
    @NotEmpty(message = "Поле не должно быть пустым!")
    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn(name = "owner_of_article", referencedColumnName = "username")
    private User owner;

    public Article(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }




    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", topic='" + topic + '\'' +
                ", owner=" + owner +
                '}';
    }
}
