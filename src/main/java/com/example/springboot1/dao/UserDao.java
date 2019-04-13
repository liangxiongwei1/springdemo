package com.example.springboot1.dao;


import com.example.springboot1.dto.AccessInfo;
import com.example.springboot1.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@CacheConfig(cacheNames = "access")
public interface UserDao  extends JpaRepository<User, Long> {

    @Cacheable
    User findUserByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);

    @CachePut(keyGenerator = "keyGenerator")
    @Modifying
    @Query(value = "update accessInfo set accessName = :accessName where accessid = :accessid",nativeQuery = true)
    void updateNameById(@Param("accessid") Long accessid, @Param("accessName") String accessName);

    @Modifying
    @Query(value = "insert into testInt(param) values(?1)",nativeQuery = true)
    int testInt(Long param);

    @Query(value = "select id from testInt where param<(?1)",nativeQuery = true)
    List<Integer> queryTest(Long param);

}
