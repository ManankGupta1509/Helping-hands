package com.PostSharing.PostSharing.Repository;


import com.PostSharing.PostSharing.Modle.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepo extends JpaRepository<Menu,Long> {

    @Query("SELECT new Menu(m.id,m.iteamName,m.price,m.restraunt.id) from Menu m where m.restraunt.id=:keyword")
    public List<Menu> getAllByRestId(Long keyword);
}
