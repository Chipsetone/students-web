package com.igor2i.students.modules.pojo.university.objects;

import org.springframework.stereotype.Component;


@Component
public class User {
  private Long id;
  private String login;
  private String passwd;
  private int enabled;

  public User() {
  }

  @Deprecated
  public User(Long id, String user, String passwd) {
    this.id = id;
    this.login = user;
    this.passwd = passwd;
  }

  public User(Long id, String login, String passwd, boolean enabled) {
    this.id = id;
    this.login = login;
    this.passwd = passwd;
    setEnabled(enabled);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }

  public boolean isEnabled() {
    return enabled != 0;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled ? 1 : 0;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", user='" + login + '\'' +
            ", passwd='" + passwd + '\'' +
            '}';
  }
}
