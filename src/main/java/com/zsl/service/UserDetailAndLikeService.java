package com.zsl.service;


import com.zsl.dao.SavaUserDetailDao;
import com.zsl.dao.SaveKeepLikeDao;
import com.zsl.entity.KeepLike;
import com.zsl.entity.UserDetail;
import com.zsl.repository.UserDetailRepository;
import com.zsl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;


/**
 * Created by 蛮夷麟爷 on 2017-06-29.
 */
//文件上传业务
public class UserDetailAndLikeService {

    @Autowired
    private SavaUserDetailDao savaUserDetailDao;
    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SaveKeepLikeDao saveKeepLikeDao;

    //这个方法用来保存上传用户图片
    public boolean UploadFile(MultipartFile uploadfile, String leftPath,String filename) {
            try {
                System.out.println("完整路径" + leftPath);
                //判断路径是否存在，如果不存在则新建路径
                //路径按照时间分文件夹
                if (!(new File(leftPath).isDirectory())) {
                    System.out.println("路径不存在已经新建路径");
                    new File(leftPath).mkdir();
                }
                File file = new File(leftPath, filename);
                uploadfile.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            //全部步骤完成上传成功
            return true;
    }

    //这个方法用来保存UserDetail和Keeplike
    @Transactional
    public boolean SaveUserDetailAndLike(UserDetail userDetail, KeepLike keepLike){
        savaUserDetailDao.SaveUserDetail(userDetail);
        if(userDetailRepository.findByUsername(userDetail.getUsername())!=null){
            //能查询到这条记录
            //将用户表里面的初始化参数改变
            saveKeepLikeDao.SaveKeepLike(keepLike);
            userRepository.updateInitialize(userDetail.getUsername());
            //成功返回true
            return true;
        }
        return false;
    }


    //这个方法是用力封装用户获得的喜好表
    public KeepLike PackageKeepLike(String[] like){
        //创建keeplike实例
        KeepLike keepLike = new KeepLike();
        //遍历springmvc得到的字符数组
        for(String str : like){
            switch(str)
            {
                case "Design":
                    keepLike.setDesign(1);
                    break;

                case "Code":
                    keepLike.setCode(1);
                    break;

                case "Develop":
                    keepLike.setDevelop(1);
                    break;

                case "Muics":
                    keepLike.setMuics(1);
                    break;

                case "Sport":
                    keepLike.setSport(1);
                    break;

                case "Write":
                    keepLike.setWritting(1);
                    break;

                default:
                    System.out.println("没有这种喜好");
                    break;
            }
        }
        return keepLike;
    }







}

