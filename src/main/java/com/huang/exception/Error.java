package com.huang.exception;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/10/16 14:46
 */
public enum  Error {
    SERVER_DO_ERROR                ("0001","交易处理失败"),
    SERVER_FTP_DOWN_ERROR        ("0002","从ftp下载文件失败"),
    SERVER_ALIYUN_UPLOAD_ERROR    ("0003","上传阿里云失败"),
    SERVER_IMG_ERROR            ("0004","图片错误"),
    SERVER_DB_ERROR                ("0005","数据库错误"),
    SERVER_OTHER_ERROR            ("1099","其他异常");
    //枚举类如果写方法的话，此处需要写分号
    private String encode;
    private String emsg;
    Error(String encode,String emsg){
        this.emsg=emsg;
        this.encode=encode;
    }
    public String getEncode(){
        return this.encode;
    }
    public String getEmsg(){
        return this.emsg;
    }
    public static Error statof(String encode){
        for(Error error:values()){
            //获取枚举类之前定义的默认对象，即之前定义好的枚举类对象
            if(error.getEncode().equals(encode)) {
                return error;
            }
        }
        return null;

    }
}
