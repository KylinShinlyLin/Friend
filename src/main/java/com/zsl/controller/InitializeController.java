package com.zsl.controller;

import com.zsl.entity.KeepLike;
import com.zsl.entity.UserDetail;
import com.zsl.service.UserDetailAndLikeService;
import com.zsl.util.CreateFileNameUtil;
import com.zsl.util.GetDateAndTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by 蛮夷麟爷 on 2017-06-29.
 */
//这个是用来做用户信息初始化，以及用户信息收集的控制器
@Controller
public class InitializeController {

    @Autowired
    private UserDetailAndLikeService userDetailAndLikeService;



    @RequestMapping("/initialize")
    public ModelAndView Initialize(ModelAndView model, MultipartFile uploadfile, HttpSession httpSession, UserDetail userDetail, String[] like,
                                   @CookieValue(value="CengshilinPlatformUserName",required=false) String username)  {

        KeepLike keepLike = null;
        //封装喜好
        if(like != null) {
            keepLike = userDetailAndLikeService.PackageKeepLike(like);
            keepLike.setUsername(username);
        }

        System.out.println("城市："+userDetail.getCity());
        userDetail.setUsername(username);

        //上传文件不为空
            if (uploadfile.getSize() > 0) {
                String filename = uploadfile.getOriginalFilename();
                if (filename.endsWith("jpg") || filename.endsWith("gif") || filename.endsWith("png")) {
                    //路径按照时间分文件夹
                    String path = "userimage/" + GetDateAndTimeUtil.getDateNoTime()+"/";
                    String leftPath = httpSession.getServletContext().getRealPath(path);
                    //随机生成文件名，然后将这个名字保存
                    String SaveFileName = CreateFileNameUtil.CreatefileName(username);
                    userDetail.setImagUrl(path+SaveFileName);
                    if(userDetailAndLikeService.UploadFile(uploadfile,leftPath,SaveFileName)){
                        //如果这个判断正确证明上传成功
                        //保存用户信息到数据库
                        if(userDetailAndLikeService.SaveUserDetailAndLike(userDetail,keepLike)){
                            model.setViewName("redirect:/ToWorld");
                            return model;

                        }else{
                            System.out.println("保存失败");
                        }
                    }else{
                        //上传出现错误失败
                        System.out.println("上传失败");
                    }
                }else{
                    //判断失败证明，文件名后缀不合法
                    System.out.println("文件名不合法！");
                }
            }else{
                if(userDetailAndLikeService.SaveUserDetailAndLike(userDetail,keepLike)){
                    System.out.println("没有用户图片，保存成功！");
                    model.setViewName("redirect:/ToWorld");
                    return model;
                }

            }

        return null;
    }


















}
