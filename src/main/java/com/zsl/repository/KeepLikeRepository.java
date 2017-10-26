package com.zsl.repository;

import com.zsl.entity.KeepLike;
import com.zsl.entity.User;
import com.zsl.entity.UserDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

/**
 * Created by 蛮夷麟爷 on 2017-06-30.
 */

@RepositoryDefinition(domainClass = KeepLike.class, idClass = Integer.class)
public interface KeepLikeRepository {

    public KeepLike findByUsername(String username);


}
