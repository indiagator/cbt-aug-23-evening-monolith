package com.cbt.cbtaug23eve;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertypelinks")
public class Usertypelink {
    @Id
    @Column(name = "linkid", nullable = false, length = 10)
    private String linkid;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "type", length = 10)
    private String type;

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}