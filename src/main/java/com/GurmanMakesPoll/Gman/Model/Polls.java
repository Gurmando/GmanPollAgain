package com.GurmanMakesPoll.Gman.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Polls {

    @Id
    @GeneratedValue
    @Column(name="POLL_ID")
    private Long id;

    @Column(name="QUESTION")
    private String questions;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="POLL_ID")
    @OrderBy
    private Set<Options> options;

    public Polls() {
    }

    public Polls(Long id, String questions, Set<Options> options) {
        this.id = id;
        this.questions = questions;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Polls{" +
                "id=" + id +
                ", questions='" + questions + '\'' +
                ", options=" + options +
                '}';
    }
}
