package com.village.rajavolu.controller;

import com.village.rajavolu.Constants.StringConstants;
import com.village.rajavolu.form.ImagesLocationForm;
import com.village.rajavolu.form.UploadItem;
import com.village.rajavolu.service.ImagesLocationService;
import com.village.rajavolu.util.DateUtils;
import com.village.rajavolu.util.ZipUtil;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.texen.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * User: Anish
 * Date: 11/30/15
 * Time: 11:59 PM
 */
@Controller
public class ImageUploadController {

    private static final Logger LOGGER = Logger.getLogger(ImageUploadController.class);
    @Autowired
    private ImagesLocationService imagesLocationService;

    @RequestMapping(value = "loadUploadImagesPage" ,method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getUploadForm(HttpServletRequest request, Model model) {
        model.addAttribute(new UploadItem());
        List<ImagesLocationForm> imagesLocationFormList = imagesLocationService.loadAllImageLocations();
        ModelMap modelMap = new ModelMap();
        if(null != imagesLocationFormList && !imagesLocationFormList.isEmpty()) {
            String filePath = StringConstants.IMAGES_PATH + imagesLocationFormList.get(0).getImagesLocation();
            File[] files = new File(filePath).listFiles();
            modelMap.put("imagesLocationList", imagesLocationFormList);
            modelMap.put("noOfImages", files.length);
            modelMap.put("imagesDirectory", imagesLocationFormList.get(0).getImagesLocation());
            request.setAttribute("noOfImages", files.length);
            request.setAttribute("filePath", filePath);
        }
        return new ModelAndView("uploadImages", modelMap);
    }

    @RequestMapping(value = "uploadImage", method = RequestMethod.POST)
    public String create(UploadItem uploadItem, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            MultipartFile file = uploadItem.getFileData();
            LOGGER.warn("file----->" + file);
            InputStream inputStream = null;
            if(file.getOriginalFilename().endsWith(StringConstants.DOT+StringConstants.ZIP)) {
                if (file.getSize() > 0) {
                    inputStream = file.getInputStream();
                    ImagesLocationForm imagesLocationForm = new ImagesLocationForm();
                    imagesLocationForm.setEventName(uploadItem.getEventName());
                    String dateInString = DateUtils.convertDateToString(Calendar.getInstance().getTime(), StringConstants.DD_MM_YYYY_HH_MM_SS);
                    imagesLocationForm.setImagesLocation(dateInString+StringConstants.DOUBLE_SLASH+StringUtils.substringBefore(file.getOriginalFilename(), String.valueOf(StringConstants.DOT)));
                    ZipUtil.unzip(inputStream, dateInString);
                    imagesLocationService.saveImageLocation(imagesLocationForm);
                }
            } else {
                request.setAttribute("errorMessage", "Please select zip file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/loadUploadImagesPage";
    }

    @RequestMapping(value = "showImage" ,method = RequestMethod.GET)
    public void showImage(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam("index") int index, @RequestParam("filePath") String filePath) {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        try {
            File[] files = new File(filePath).listFiles();
            String fileName = filePath+StringConstants.DOUBLE_SLASH+files[index].getName();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            response.getOutputStream().write(IOUtils.toByteArray(inputStream));
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "loadImagesByEvent" ,method = RequestMethod.GET)
    public ModelAndView loadImageByEventName(@RequestParam("imagesDirectory") String imagesDirectory, HttpServletRequest request,
                   HttpServletResponse response) {
        String filePath = StringConstants.IMAGES_PATH+imagesDirectory;
        request.getSession().setAttribute("filePath", filePath);
        request.setAttribute("filePath", filePath);
        File[] files = new File(filePath).listFiles();
        request.setAttribute("noOfImages", files.length);
        return new ModelAndView("imagesPage");
    }
}
