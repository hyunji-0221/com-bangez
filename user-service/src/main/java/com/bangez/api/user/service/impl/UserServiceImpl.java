package com.bangez.api.user.service.impl;

import com.bangez.api.common.MessengerVO;
import com.bangez.api.user.domain.UserDTO;
import com.bangez.api.user.repository.UserRepository;
import com.bangez.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public MessengerVO save(UserDTO t){
        entityToDTO((repository.save(dtoToEntity(t))));
        return MessengerVO.builder().message("True").build();
    }
}