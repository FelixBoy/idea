package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by zhj on 2017/3/12.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public void testUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,
                           HttpServletResponse resp, HttpServletRequest resq) throws Exception {
        if (!file.isEmpty()) {
            if (file == null) {
                throw new Exception("上传失败：文件为�空");
            }
            if(file.getSize()>10000000)
            {
                throw new Exception("上传失败：文件大小不能超过10M");
            }
            System.out.println(name);
            String filename=file.getOriginalFilename();
            System.out.println(filename);
            byte[] bytes = file.getBytes();
            System.out.println(bytes.length);
            System.out.println();
            file.transferTo(new File(resq.getSession().getServletContext().getRealPath("/")+"//file//hahah.png"));
            // store the bytes somewhere
            resp.setCharacterEncoding("gbk");
            resp.getWriter().print(filename);
        }
    }
}
