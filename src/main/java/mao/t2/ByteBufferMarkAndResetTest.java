package mao.t2;

import mao.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * Project name(项目名称)：Netty_ByteBuffer
 * Package(包名): mao.t2
 * Class(类名): ByteBufferMarkAndResetTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/5
 * Time(创建时间)： 22:04
 * Version(版本): 1.0
 * Description(描述)： mark 和 reset
 */

public class ByteBufferMarkAndResetTest
{
    private static final Logger log = LoggerFactory.getLogger(ByteBufferPutTest.class);

    public static void main(String[] args)
    {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //调用put方法
        byteBuffer.put(new byte[]{'1', '2', '3', '4'});
        //调用put方法
        byteBuffer.put(new byte[]{'5', '6'});

        //打印
        ByteBufferUtil.debugAll(byteBuffer);

        //调用mark方法
        byteBuffer.mark();

        //调用两次get方法
        byteBuffer.get();
        byteBuffer.get();

        //打印
        ByteBufferUtil.debugAll(byteBuffer);

        //调用reset方法
        byteBuffer.reset();

        //打印
        ByteBufferUtil.debugAll(byteBuffer);

    }
}
