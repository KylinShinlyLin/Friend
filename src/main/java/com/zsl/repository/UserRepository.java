package com.zsl.repository;

import com.zsl.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 蛮夷麟爷 on 2017-06-24.
 */
//user仓库
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface UserRepository {

    public User findByUsername(String username);

    @Query("select o from User o where o.username=:username")
    public User getUserByUserName(@Param("username")String username);


    //更新初始化操作
    @Modifying
    @Query("update User o set o.initialize = 1 where o.username = :username")
    public void updateInitialize(@Param("username") String username);


    //更新初始化操作
    @Transactional
    @Modifying
    @Query("update User o set o.email = :email where o.username = :username")
    public void updateEmail(@Param("username") String username,@Param("email") String email);





}
