package com.zsl.repository;

import com.zsl.entity.FriendMessage;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by 蛮夷麟爷 on 2017-07-17.
 */
//查询好友圈

public interface FriendMessageRepository extends PagingAndSortingRepository<FriendMessage,Integer> {

    //更新初始化操作(使用原生SQL)
    @Transactional
    @Modifying
    @Query(value = "insert into friend_message(time,username,word) values(now(),:username,:word) ",nativeQuery = true)
    public void saveMessage(@Param("username") String username,@Param("word") String word);


}
