package com.hwq.jpa.repository;

import com.hwq.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承JpaRepository来完成对数据库的操作，JpaRepository<操作的实体类,id的类型>
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
