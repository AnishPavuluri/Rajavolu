package com.village.rajavolu.mail.impl;

import com.village.rajavolu.Constants.StringConstants;
import com.village.rajavolu.mail.MailService;
import com.village.rajavolu.mail.VelocityTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Calendar;

/**
 * User: Anish
 * Date: 4/26/14
 * Time: 10:46 PM
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    private static Logger LOGGER = Logger.getLogger(MailServiceImpl.class);

    private VelocityTemplate velocityTemplate;
    private JavaMailSender mailSender;
    static final String fromName="rajavoluvillage";

    public void sendMail(String toMailId, String ccMailId, String vmFileLocation, Object... data) {
        Calendar calendar = Calendar.getInstance();
        LOGGER.debug("Started :: sending mail to:"+toMailId);
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            /*use the true flag to indicate you need a multipart message*/
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(fromName, StringConstants.FROM_NAME);
            mimeMessageHelper.setTo(toMailId);
            String subject = velocityTemplate.prepareStringFromVelocityTemplate(vmFileLocation+"Subject.vm", data);
            mimeMessageHelper.setSubject(subject);
            String text = velocityTemplate.prepareStringFromVelocityTemplate(vmFileLocation+".vm", data);
            /* Use the true flag to indicate the text included is HTML */
            mimeMessageHelper.setText(text, true);
            FileSystemResource fileSystemResource = null;
            String fileName = StringUtils.EMPTY;
            for(Object object : data) {
                if (object instanceof File) {
                    File file = (File)object;
                    fileSystemResource = new FileSystemResource(file);
                    fileName = file.getName();
                }
            }
            if(null != fileSystemResource) {
                mimeMessageHelper.addAttachment(fileName, fileSystemResource);
            }
            mailSender.send(mimeMessage);
            LOGGER.debug("End :: mail sendded successfully to:"+toMailId +": time taken ::"+(Calendar.getInstance().getTimeInMillis()-calendar.getTimeInMillis()));
        } catch (Exception exception) {
            LOGGER.error("ERROR While Sending Mail To::"+toMailId + "Error::"+exception.getMessage());
        }

    }

    @Resource
    public void setVelocityTemplate(VelocityTemplate velocityTemplate) {
        this.velocityTemplate = velocityTemplate;
    }

    @Resource
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
