package ru.carcrew.boot.version_20.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.carcrew.boot.version_20.models.User;
import ru.carcrew.boot.version_20.repositories.UsersRepository;
import ru.carcrew.boot.version_20.security.PersonDetails;

import java.util.Optional;



@Service
public class PersonDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public PersonDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByUsername(username);

        if (user.isEmpty()) {
            System.out.println("ОБОСРАМС");
            throw new UsernameNotFoundException("User not found");
        }
        else
            return new PersonDetails(user.get());

    }


}
