package com.PostSharing.PostSharing.Repository;

import com.PostSharing.PostSharing.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

}
