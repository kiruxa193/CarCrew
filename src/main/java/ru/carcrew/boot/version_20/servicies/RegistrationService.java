package ru.carcrew.boot.version_20.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.carcrew.boot.version_20.models.User;
import ru.carcrew.boot.version_20.repositories.UsersRepository;

@Service
public class RegistrationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationService(UsersRepository usersRepository,PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Transactional
    public void regtion(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);

    }
}
