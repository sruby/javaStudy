package io.github.sruby.callbackmode;

/**
 * 模拟客户端类
 * @author sruby on 2016年4月15日 下午11:47:44
 */
public class Client implements ClientCallback
{
    private Server server = new Server();
    
    public void sendMsg(final String msg)
    {
        /**
         * 异步发送消息
         */
        new Thread(new Runnable()
        {
            public void run()
            {
                server.getMsg(Client.this, msg);
            }
        }).start();
        
    }

    /**
     * 实现回调接口的业务逻辑
     * @author sruby on 2016年4月15日 下午11:53:26
     * @param status
     */
    @Override
    public void process(String status)
    {
        System.out.println("响应状态为:"+status);
    }
    
    public static void main(String[] args)
    {
        Client client = new Client();
        client.sendMsg("发起一个请求");
    }
}
