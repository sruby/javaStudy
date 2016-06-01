package io.github.sruby.callbackMode;

/**
 * 模拟服务端
 * @author sruby on 2016年4月15日 下午11:49:38
 */
public class Server
{
    public void getMsg(ClientCallback clientCallback,String msg)
    {
        System.out.println(msg);
        
        String status = "200";
        clientCallback.process(status );
    }
}
