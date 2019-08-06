package com.gyt.springboot.repository;

import com.gyt.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @className: UserRepository
 * @author guyt
 * @description: 继承JpaRepository来完成对数据库的配置
 * @date 2019/8/6
 * @version 1.0.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {


}
