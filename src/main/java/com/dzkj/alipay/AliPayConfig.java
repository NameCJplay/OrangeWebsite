package com.dzkj.alipay;


import java.io.FileWriter;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Configuration
public class AliPayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101300677039";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCBnuG1U0kwAoywHOHIzK2qqd1DPPxgZq68+YXxcpi30CpY+wy9uLbmAVdDPQRVOHXn4Dw+5yKtRB0Z/A6pfPK4S/yqVwtiag4LVhHEY7B/+2tF0yRgPfpAr04d5pyTaVcr7y5yVYd6uAtrEXzgnk2liM9K7nzsqQkNoYLGFxHpHYhI2Mkt8d7fmDxxp6GNYSXRWaQ5Q5hvi1umT12+0RO0HC24WtUCfnTltgbhp22z6RL2vgnRRaADBAFzsrI4owhPc+YlGPD5DXkRt0Gr3+1ohmPk23S+QNx8GWiZedPvnpqS2Ok8922M+dzyUgszt8XXWRQZ3JZpDA8794xe7qPNAgMBAAECggEAaSUi3l3jHojS6wFiveoabjhAfgx4hRKGaFDYsFVPQLwhvfBYE4ZFByrLSIW0gBS+wAuLk1MXNAnuuWdX1XC/y3QIT30whPKW1edJnk9nm0mtaQSvm0prOBF8gpDRLlrjFYZ93M04ivnEeWPEMsj3H3JtBNGUkL1F1MLRPDL2mmvspR7Uh8R9HywdxBh5Lg8e8z4c4GOL8mhRDVSk2XMnh9sW7Uj862iqTyIqGGXWRWsieQCIJurI9LEzuslb954hHgho/r7NJa8z0LpW0JaEn2+9Bt0DC97le+6+nYibYZQXOiWhI/JtH3iyb9Yv0OEzsLnifCzVC1PSDvqEiM44WQKBgQC9JDA0mwfGEW+zl6SLDt8M949k3H5OyiC66YXT4ucIf7EWzCOa7TpertlGoltDYGDcMqE1FiyJF1j5yHCey79kxnUyqyhPR2vupKCufUzuGl380d2t6gid5qBQBhy1RhaUTtqHBYyNzTUoO1eyt4OoWABU3/taedLePWPBVD2VGwKBgQCvcIiZAshTmBz5Ef7dBhdS2LTMgFrdOxvjTuZTE+sKaQARGB0smQxQu5zmzBU6LDsoRVXyT2QE05l/5tRxefU7Io2KzxaMlJx/HDADL29ARCZIFquOyrvG/hVMLUePsx3eTkGSkNo7PlbMTthejqHd3b3WTTFxwFrnErjznsOBNwKBgEcZn3VnAdkXHOJqEtSjVn3NYf4MVP7RRNR+jGxGU4sCVVO4kXnfy51kJRFEXwJI7KBZ9/e4yi0OtcfP7WYEOYJsiAnwBUsoEg63nB97wruO9d3gFnEWFP8mfwUWBxytqDdAHS28jEWR6nWhOSpZighybE17lUVBnl8kvKckP7IZAoGBAKyvXAUgVAbUZ1BSgkcUQ8jsPao9fTLdh6nKc7O6m1P33nT1A2Juk0y0HtCeeRZ1ixUsilikBJMrpJ/cmafIn7XBYQkMpeliLlh/alL4Uc00R2oVxnAa5ZINbvE4cIPljrTO2oRlyCkgR1d7FEaepn04Ui+qc8y/xbpFF3/U+iMpAoGAV0KqvLA5sFD6+BkwovU78tGK06wnlHdFiU5IavyGiH9qGyEmAb42lfD0awzTIFjPF72oXNH/vDFfZacpN1fFjP5qdQmzaNYkTGj1Vv+FmmK7WC6KriF4kL9EMttbflDBLeIBwaIXWeQtLGqH6PWqaHDu9QGPmBkm7k909eUDahI=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnT90cXoqQuPIgwRsT5DQGD5bpfsgZNx2pavXKs2Ma0zTIKLynstYYfDDkseyJeP9WEmGYPtkiTKH02Jw/etjS5PBMnpOc4Yu0aTit2f2+eL/8L5R8wZzMqAGcUt8rlsUULb9vzCrNMYDjjz9xMgs+Xx/R7pxhQX85lOEIXZ0om7UJPexEEUV1uY+sSHeo1gZI6p3ttN0kEeR1MCmH9HH9vVHNjgUYYaHVpheXN+XQ7uhSFKGtyE2sAkHSt5SB5TUFOIu+G/HF3VoFf6xe0vGqS5cRAjDYRsGdmnbffaATB0Y9RvwQ+jyjsk82Mbc9VkkeMiiBF8kN51QTEGA9zRuCQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/home/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

