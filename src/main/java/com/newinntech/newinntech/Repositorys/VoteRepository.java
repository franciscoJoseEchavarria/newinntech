package com.newinntech.newinntech.Repositorys;


import com.newinntech.newinntech.Entitys.VoteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VoteRepository extends JpaRepository<VoteEntity, Long> {


}
