package com.example.springboot1.dao;

import com.example.springboot1.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
@CacheConfig(cacheNames = "access")
public interface UserMapperDao {
    @Cacheable
    Map<String, Object> queryAccessInfo(@Param("accessId") Long accessId);

}
