package com.bangez.api.oauth;


import com.bangez.api.oauthDomain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthRepository extends JpaRepository<UserModel,Long> {
}
