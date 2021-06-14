package com.PostSharing.PostSharing.Repository;


import com.PostSharing.PostSharing.Modle.Restraunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestrauntRepo extends JpaRepository<Restraunt,Long> {

}
