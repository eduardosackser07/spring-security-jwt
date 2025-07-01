package com.example.spring_security_jwt.config;

import com.example.spring_security_jwt.entities.User;
import com.example.spring_security_jwt.entities.Values;
import com.example.spring_security_jwt.repository.RoleRepository;
import com.example.spring_security_jwt.repository.UserRepository;
import com.example.spring_security_jwt.entities.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleRepository.findByName(Values.admin.name());

        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setName(Values.admin.name());
            roleAdmin = roleRepository.save(roleAdmin); // Persistir a nova role
            System.out.println("Role 'admin' criada com sucesso!");
        }

        final Role finalRoleAdmin = roleAdmin; // Variável final para uso na lambda

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> System.out.println("admin ja existe"),
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(finalRoleAdmin)); // Usando finalRoleAdmin
                    userRepository.save(user);
                    System.out.println("Usuário admin criado com sucesso!");
                }
        );
    }
}