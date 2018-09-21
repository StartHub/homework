package com.dx.dky.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chentaoping
 * @ClassName: EmailSenderUtil
 * @Description:邮件发送工具类
 * @date 2015-10-28 下午4:18:18
 */
@Component
public class EmailSenderUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailSenderUtil.class);

    public static final String Mail_from = "dx@gbdex.com";
//	private String Mail_from = SysConfigUtils.getValue("mailFrom");

    @Autowired
    private JavaMailSender mailSender;

//	public EmailSenderUtil(){
//		mailSender = (JavaMailSender) ApplicationContextHolder.getBean("emailSender");
//		System.out.println("--------------------------------2222----------------------");
//		System.out.println(mailSender);
//	}


    /**
     * @param emailTitle
     * @param emailContent
     * @param string
     * @Title: sendTextEmail
     * @Description: 发送普通文本邮件
     */
    public void sendTextEmail(String emailTitle, String emailContent, String[] string) {
        logger.info("sendMail() Begin at: " + new Date());

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(Mail_from);
            msg.setTo(string);
            msg.setSubject(emailTitle);
            msg.setText(emailContent);
            mailSender.send(msg);
            logger.info("sendMail() Send mail success! ");
        } catch (Exception e) {
            logger.error("error", e);
            return;
        }
    }


    /**
     * @param emailTitle
     * @param emailContent
     * @param emailTo
     * @throws Exception
     * @Title: sendMail
     * @Description: 特殊邮件
     */
//    public void sendMail(String emailTitle, String emailContent, String[] emailTo) throws Exception {
//        logger.info("sendMail() Begin at: " + new Date());
//
//        try {
//            MimeMessage mmage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mmage, true, "utf-8");
//
//            // 设定邮件参数
//            helper.setFrom(Mail_from);
//            helper.setTo(emailTo);
//            helper.setSubject(emailTitle);
//            helper.setText(emailContent, true);
//
//            mailSender.send(mmage);
//            logger.info("sendMail() Send mail success! ");
//        } catch (Exception e) {
//            logger.error("error", e);
//            throw e;
//        }
//    }
//
//    public void sendMail(String emailTitle, String emailContent, String[] sendTo, List<String> attachmentName, List<InputStreamSource> attachmentPath) throws Exception {
//        logger.info("sendMail() Begin at: " + new Date());
//
//        try {
//            MimeMessage mmage = mailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mmage, true, "utf-8");
//
//            // 设定邮件参数
//            helper.setFrom(Mail_from);
//            helper.setTo(sendTo);
//            helper.setSubject(emailTitle);
//            helper.setText(emailContent, true);
//            for (int i = 0; i < attachmentName.size(); i++) {
//                helper.addAttachment(attachmentName.get(i), attachmentPath.get(i));
//            }
//
//            mailSender.send(mmage);
//            logger.info("sendMail() Send mail success! ");
//        } catch (Exception e) {
//            logger.error("error", e);
//        }
//    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static void main(String[] args) throws Exception {
        StringBuffer emailBuffer = new StringBuffer();
        emailBuffer.append("<div style=' width:600px; font-size:12px; padding:0; margin:0 auto; font-family:Arial, '宋体'; overflow:hidden'>");
        emailBuffer.append("<div style='border:1px solid #eee; overflow:hidden'>");
        emailBuffer.append("<div style='padding:30px 20px; font-size:14px; color:#000; line-height:24px'>");
        emailBuffer.append("<p style='padding-bottom:10px'>亲爱的贵交所用户 <b>" + "ctp" + "</b>：</p>");
        emailBuffer.append("<p style='padding-bottom:10px'>" + "你账户在2015年10月入账100.00元！" + "</p>");
        emailBuffer.append("贵阳大数据交易所邮件中心<br>" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "</div>");
        emailBuffer.append("<div style='padding:10px 20px; line-height:24px; color:#666; border-top:1px solid #eee; overflow:hidden'>");
        emailBuffer.append("① 此邮件为trade.gbdex.com/trade.web/系统发出，请勿回复邮件<br>");
        emailBuffer.append("② 贵阳大数据交易所（<a style='color:#0000cc' href='http://trade.gbdex.com/trade.web/' target='_blank'>http://trade.gbdex.com/trade.web/</a>）是中国首家成立的大数据交易平台！<br>");
        emailBuffer.append("</div></div><div style='background:#f7f7f7; height:3px; margin:0 3px; overflow:hidden;'></div></div>");

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.exmail.qq.com");
        mailSender.setUsername("mail@pranceclouds.com");
        mailSender.setPassword("Mimaxytjqk111");
        MimeMessage mmage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mmage, true, "utf-8");
        helper.setFrom(mailSender.getUsername());
        System.out.println("ceshi:" + mailSender.getUsername());
        String[] arr = {"877895695@qq.com"};
        helper.setTo(arr);
        helper.setSubject("警告处理！！！");
        helper.setText(emailBuffer.toString(), true);
        mailSender.send(mmage);

    }

}
