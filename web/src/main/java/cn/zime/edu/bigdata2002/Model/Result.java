package cn.zime.edu.bigdata2002.Model;

/**
 * 响应码类，通过这个类来定义响应码
 */
public class Result{
    private final int code;
    private String response;

    public Result(int code, String response){
        this.code = code;
        this.response = response;
    }

    public int getCode(){
        return this.code;
    }

    public String getResponse(){
        return this.response;
    }

    public void setResponse(String response){
        this.response = response;
    }

}
