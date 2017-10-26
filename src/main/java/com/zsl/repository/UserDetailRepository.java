package com.zsl.repository;

import com.zsl.entity.User;
import com.zsl.entity.UserDetail;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by 蛮夷麟爷 on 2017-06-30.
 */
//UserDetail仓库
@RepositoryDefinition(domainClass = UserDetail.class, idClass = Integer.class)
public interface UserDetailRepository {

    public UserDetail findByUsername(String username);




}
