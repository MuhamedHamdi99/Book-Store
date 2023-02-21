package com.bookStore.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookStore.entity.MyBook_List;

@Repository
public interface MyBookReposetory extends JpaRepository<MyBook_List, Integer> {

}
