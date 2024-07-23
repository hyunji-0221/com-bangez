package com.bangez.api.oauthDomain;

import com.bangez.api.oauthVO.Registration;
import com.bangez.api.oauthVO.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String id;
    private String email;
    private String name;
    private String profile;
    private List<Role> roles;
    private Registration registration;
}