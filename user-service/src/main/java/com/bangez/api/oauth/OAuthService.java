package com.bangez.api.oauth;

import com.bangez.api.oauthDomain.LoginDTO;
import com.bangez.api.oauthDomain.PrincipalUserDetails;
import com.bangez.api.oauthDomain.UserModel;
import com.bangez.api.oauthVO.ExceptionStatus;
import com.bangez.api.oauthVO.Role;
import com.bangez.api.user.domain.User;
import com.bangez.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final UserRepository repository;

    public PrincipalUserDetails login(LoginDTO dto) {
        User user = repository.findByUserName(dto.getEmail())
                .orElseThrow(() -> new LoginException(ExceptionStatus.UNAUTHORIZED, "존재하지 않는 사용자입니다."));
        if (user.getPassword().equals(dto.getPassword())){
            return new PrincipalUserDetails(UserModel.builder()
                    .id(String.valueOf(user.getId()))
                    .name(user.getName())
                    .email(user.getEmail())
                    .roles(List.of(Role.ROLE_USER))
                    .build(), null);
        }else{
            throw new LoginException(ExceptionStatus.INVALID_PASSWORD, "비밀번호가 일치하지 않습니다.");
        }
    }

}
