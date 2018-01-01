package com.initKay.bauble.tool;

import javax.mail.Session;
import java.util.Properties;

/**
 * 2017 12 06 添加
 * 用于发送邮件的方法类
 *
 * @author initKay
 * @version 1.0
 */
public class sendMail {
    public sendMail() {
    }

    //发送邮箱的地址
    private String username;
    //发送邮箱的密码
    private String password;
    //发送邮箱的服务器地址
    private String mailserver;
    //需要发送的模式
    private boolean needauthsend = "1".equals("1");

    private String needSSL;
    private String smtpServerPort;

    public boolean sendmail(){
        boolean flag=true;
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.sohu.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //邮件发送的五个步骤
        //1创建session
       // Session session = new Session.getInstance(prop);
        return flag;
    }
    public String getSmtpServerPort() {
        return smtpServerPort;
    }

    public void setSmtpServerPort(String smtpServerPort) {
        this.smtpServerPort = smtpServerPort;
    }

    public String getNeedSSL() {
        return needSSL;
    }

    public void setNeedSSL(String needSSL) {
        this.needSSL = needSSL;
    }

    public void setNeedauthsend(boolean needauthsend) {
        this.needauthsend = needauthsend;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailServer(String mailserver) {
        this.mailserver = mailserver;
    }

}
