package com.qccr.livtrip.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2017/2/22 17:33 user Exp $$
 * @name
 */

public class Mail {


    private Message message;
    private Multipart multipart;//共用一个容器
    private static Map<String, String> hosts = new HashMap<String, String>();
    static{
        hosts.put("qq", "smtp.qq.com");
        hosts.put("qccr", "smtp.qq.com");
        hosts.put("toowell", "smtp.exmail.qq.com");
        hosts.put("163", "smtp.163.com");
        hosts.put("126", "smtp.126.com");
        hosts.put("sina", "smtp.sina.com.cn");
        hosts.put("189", "smtp.189.cn");
        hosts.put("sohu", "smtp.sohu.com");
        hosts.put("21cn", "smtp.21cn.com");
        hosts.put("tourongjia", "smtp.tourongjia.com");
        hosts.put("livtrip", "smtp.mxhichina.com");

    }

    public static enum ReceiveType{TO, CC, BCC};
    public static enum Mode{TEXT_MAIL,HTML_MAIL};

    /**
     * host比较特殊，无法根据邮箱后缀得出时传入host
     * @param host
     * @param account
     * @param password
     * @param fromAddress
     */
    public Mail(String host, String account, String password, String fromAddress){
        Properties p = new Properties();
        p.put("mail.smtp.host", host);	//p.put("mail.smtp.port", "25");//pop3 110
        p.put("mail.smtp.auth", "true");
        message = new MimeMessage(Session.getDefaultInstance(p, new MyAuthenticator(account, password)));
        try {
            message.setFrom(new InternetAddress(fromAddress));
//			Address[] adds = new Address[fromAddress.length];for(int i=0; i<fromAddress.length; i++){adds[i] = new InternetAddress(fromAddress[i]);}message.setReplyTo(adds);
        } catch (MessagingException e) {
            throw new RuntimeException("发信人地址有误", e);
        }
    }
    /**
     * 需要验证使用该构造器
     * @param account	发信人邮箱账号
     * @param password	发信人邮箱密码
     * @param fromAddress	发信人邮箱地址
     */
    public Mail(String account, String password, String fromAddress){
        String host = fromAddress.substring(fromAddress.indexOf('@')+1, fromAddress.indexOf('.'));
        if(hosts.containsKey(host)){
            host = hosts.get(host);
        }else{
            host = fromAddress.substring(fromAddress.indexOf('@')+1);
        }

        Properties p = new Properties();
        p.put("mail.smtp.host", host);	//p.put("mail.smtp.port", "25");
        p.put("mail.smtp.auth", "true");
        message = new MimeMessage(Session.getDefaultInstance(p, new MyAuthenticator(account, password)));
        try {
            message.setFrom(new InternetAddress(fromAddress));
//			Address[] adds = new Address[fromAddress.length];for(int i=0; i<fromAddress.length; i++){adds[i] = new InternetAddress(fromAddress[i]);}message.setReplyTo(adds);
        } catch (MessagingException e) {
            throw new RuntimeException("发信人地址有误", e);
        }
    }
    /**
     * 需要验证使用该构造器(发信地址等于邮箱账号)<br>
     * this(account, password, account);
     */
    public Mail(String account, String password){
        this(account, password, account);
    }

    /**
     * 设置邮件接收人，区分收件/抄送/秘密抄送，每种类型各需要调用一次方法<br>
     * 不同host的邮箱一起发送会出错
     * @param type	RECEIVE_TYPE_TO-收件<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 				RECEIVE_TYPE_CC-抄送<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 				RECEIVE_TYPE_BCC-秘密抄送
     * @param toAddress	地址
     */
    public void addToAddress(final ReceiveType type, final String... toAddress) {
        RecipientType recipientType;
        switch(type){
            case TO : recipientType = Message.RecipientType.TO;break;//收件人
            case CC : recipientType = Message.RecipientType.CC;break;//抄送
            case BCC : recipientType = Message.RecipientType.BCC;break;//秘密抄送
            default: throw new RuntimeException("无此收件类型");
        }
        try {
            for(String curr : toAddress){
                message.addRecipient(recipientType, new InternetAddress(curr));
            }
        } catch (MessagingException e) {
            throw new RuntimeException("收件人地址有误", e);
        }
    }

    /**
     * 设置邮件信息，使用utf-8编码
     * @param subject 主题
     * @param content 内容
     * @param mode	纯文本邮件-MODE_TEXT_MAIL <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * 				HTML邮件-MODE_HTML_MAIL
     */
    public void setMailInfo(final Mode mode, final String subject, final String content) {
        try {
            message.setSubject(subject);
            if(mode == Mode.HTML_MAIL){	//--HTML 邮件
                if(multipart == null){
                    multipart = new MimeMultipart();	// MiniMultipart类是一个容器类，容纳MimeBodyPart类型的对象
                }
                BodyPart bodyPart = new MimeBodyPart();	// 创建一个包含HTML类型邮件内容的MimeBodyPart
                bodyPart.setContent(content, "text/html; charset=utf-8");
                multipart.addBodyPart(bodyPart);
            }else if(mode == Mode.TEXT_MAIL){			//--text 邮件
                message.setText(content);
            }else{
                throw new RuntimeException("邮件信息有误，无此邮件模式");
            }
        } catch (MessagingException e) {
            throw new RuntimeException("邮件主题或内容有误", e);
        }
    }

    public void setAttachFile(final String filePath, final String fileName){
        try {
            if(multipart == null){
                multipart = new MimeMultipart();	// MiniMultipart类是一个容器类，容纳MimeBodyPart类型的对象
            }
            BodyPart bodyPart = new MimeBodyPart();	// 创建一个包含HTML类型邮件内容的MimeBodyPart
            DataSource datasource = new FileDataSource(filePath);
            bodyPart.setDataHandler(new DataHandler(datasource));
            bodyPart.setFileName(MimeUtility.encodeWord(fileName,"utf-8", null));
            multipart.addBodyPart(bodyPart);
        } catch (Exception e) {
            throw new RuntimeException("设置附件失败，请核实地址", e);
        }
    }

    /**
     * 发送邮件
     * 失败抛出 RuntimeException("发送失败", e)
     */
    public void send() {
        try {
            if(multipart != null){
                message.setContent(multipart);				// 将MimeMultipart对象设置为邮件内容
            }
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("发送失败", e);
        }
    }

    /**
     * 鉴权器实现
     */
    private class MyAuthenticator extends Authenticator {
        private PasswordAuthentication authenticator;
        public MyAuthenticator(String account, String password) {
            authenticator = new PasswordAuthentication(account, password);
        }
        protected PasswordAuthentication getPasswordAuthentication(){
            return authenticator;
        }
    }

    public static void main(String[] args) {
//		Mail mail = new Mail("545739504@qq.com", "qccr20160328");
//		mail.addToAddress(ReceiveType.TO, "1160755272@qq.com");
//		mail.addToAddress(ReceiveType.TO, "xierongli@qccr.com");
//		mail.setMailInfo(Mode.TEXT_MAIL, "验证码", "验证码是: 111111");
//		mail.send();

        //Mail mail = new Mail("mark@livtrip.com", "Welcome123");
       // Mail mail = new Mail("xierongli@tourongjia.com", "Tourongjia2017");
        Mail mail = new Mail("livtrip@163.com", "livtrip2017");
        //mail.addToAddress(Mail.ReceiveType.TO, "livtrip@163.com");
        mail.addToAddress(Mail.ReceiveType.TO, "545739504@qq.com");
        mail.setMailInfo(Mail.Mode.TEXT_MAIL, "sa退款回调测试信息", "命中黑名单》退款通知修改订单状态异常,订单编号:"+122+" 请尽快协助处理！！！");
        mail.send();
        System.out.println("success");
    }
}
