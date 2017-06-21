package com.fundmaster.mss.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tony on 6/13/17.
 */
@Entity
@Table(name = "tbl_faq_content")
public class FaqContent extends GenericModel<FaqContent> implements Serializable {

    private static final long serialVersionUID = 1L;

    public FaqContent() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;
    @Column (columnDefinition = "TEXT")
    private String text;
    private String title;
    private boolean publish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public FaqContent(Long id,String text, String title, boolean publish) {
        super();
        this.id = id;
        this.text = text;
        this.title = title;
        this.publish = publish;
    }
}
