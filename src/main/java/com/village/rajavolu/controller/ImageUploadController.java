package com.village.rajavolu.controller;

import com.village.rajavolu.form.UploadItem;
import com.village.rajavolu.util.ZipUtil;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * User: Anish
 * Date: 11/30/15
 * Time: 11:59 PM
 */
@Controller
public class ImageUploadController {

    @RequestMapping(value = "uploadImage" ,method = RequestMethod.GET)
    public ModelAndView getUploadForm(Model model) {
        model.addAttribute(new UploadItem());
        return new ModelAndView("uploadImages");
    }

    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    public String create(UploadItem uploadItem, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            MultipartFile file = uploadItem.getFileData();
            System.out.println("file----->"+file);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            if (file.getSize() > 0) {
                inputStream = file.getInputStream();
                //System.out.println("file.getBytes().length------------>"+file.getBytes().length);
              /*  outputStream = new FileOutputStream("C:\\RajavoluImages\\" + file.getOriginalFilename());
                System.out.println(file.getOriginalFilename());
                System.out.println("=============");
                //int length = inputStream.read();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                bufferedOutputStream.write(file.getBytes());
                bufferedOutputStream.close();*/
                //System.out.println("====22========="+length);
                ZipUtil.unzip(inputStream);
                session.setAttribute("uploadImage", "C:\\RajavoluImages\\" + file.getOriginalFilename());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/uploadImageIndex";
        //return new ModelAndView("uploadImages");
    }

    @RequestMapping(value = "uploadImageIndex" ,method = RequestMethod.GET)
    public ModelAndView loadImage(Model model) {

        return new ModelAndView("uploadImageIndex");
    }

    @RequestMapping(value = "showImage" ,method = RequestMethod.GET)
    public void showImage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        try {
            String fileName = (String)session.getAttribute("uploadImage");
            System.out.println("fileName----------->"+fileName);
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            response.getOutputStream().write(IOUtils.toByteArray(inputStream));
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
