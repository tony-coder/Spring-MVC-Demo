package com.demo.controller.C07.FileUploadTest;

import com.demo.domain.C07.FileUploadTest.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping(value = "/07")
public class FileUploadController {
    private static final Log logger = LogFactory.getLog(FileUploadController.class);

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        // 动态挑战页面
        return "forward:/jsp/07/" + formName + ".jsp";
    }

    // 上传文件会自动绑定到MultipartFile中
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        logger.info(description);
        System.out.println(description);
        // 如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));  //File.separator 是系统默认的文件分隔符号
            return "/07/success";
        } else {
            return "/07/error";
        }
    }

    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request,
                           @ModelAttribute User user,
                           Model model) throws Exception {
        System.out.println(user.getUsername());
        logger.info(user.getUsername());
        // 如果文件不为空，写入上传路径
        if (!user.getImage().isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            // 上传文件名
            String filename = user.getImage().getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            user.getImage().transferTo(new File(path + File.separator + filename));
            // 将用户添加到model
            model.addAttribute("user", user);
            return "/07/userInfo";
        } else {
            return "error";
        }
    }

}
