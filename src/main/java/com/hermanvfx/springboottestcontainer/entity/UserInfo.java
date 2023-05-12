package com.hermanvfx.springboottestcontainer.entity;

import java.sql.Timestamp;
import java.util.List;

public interface UserInfo {
    Long getId();
    String getName();
    Timestamp getBirthDate();
    List<String> getPhone();
    List<String> getEmail();
}
