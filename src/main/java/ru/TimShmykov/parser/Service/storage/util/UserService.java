package ru.TimShmykov.parser.Service.storage.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.TimShmykov.parser.model.User;
import ru.TimShmykov.parser.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


   // public List<User> getUsers(Long user_Id) {
   //     return userRepository.getAllByUserId(user_Id);
   // }


}
