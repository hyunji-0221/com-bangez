package com.bangez.apigateway.domain.model;

import java.util.List;

import com.bangez.apigateway.domain.vo.Registration;
import com.bangez.apigateway.domain.vo.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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