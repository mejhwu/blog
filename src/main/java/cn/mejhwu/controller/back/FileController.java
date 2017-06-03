package cn.mejhwu.controller.back;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * Author: jhwu
 * E-mail: mejhwu@163.com
 * Date: 17-4-10
 * Time: 下午10:03.
 */
@Controller
@RequestMapping("back/file")
public class FileController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);


    @RequestMapping(value = "/uploadfile",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String fileUpload(HttpServletRequest request, @RequestParam(value = "editormd-image-file", required = false) CommonsMultipartFile attach) {

	    String res = null;
        try {
            request.setCharacterEncoding( "utf-8" );
            String rootPath = request.getSession().getServletContext().getRealPath("/upload/");

           //文件路径不存在则需要创建文件路径
            File filePath=new File(rootPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }

            //TODO
            logger.info(rootPath);
            logger.info(rootPath + System.currentTimeMillis() + attach.getOriginalFilename());
            long currentTime = System.currentTimeMillis();
            //最终文件名
            File realFile=new File(rootPath + currentTime + attach.getOriginalFilename());
            FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);
            //下面response返回的json格式是editor.md所限制的，规范输出就OK
            res = "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/upload/" + currentTime + attach.getOriginalFilename() + "\"}";
        } catch (Exception e) {
            res = "{\"success\": 0, \"message\":\"上传失败\"}";
        }
        return res;
    }
}
