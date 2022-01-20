package com.userreg.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.userreg.web.Dao.UserRepository;
import com.userreg.web.Model.User;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    // test methods go below
    
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("alex@gmail.com");
        user.setPassword("alex2020");
        user.setFullname("Alexandra");
        user.setPhone(80665534);
        user.setLastname("Hubb");
         
        User savedUser = repo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getId());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }
    
    
}