package mao.t4;

import mao.utils.ByteBufferUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：Netty_ByteBuffer
 * Package(包名): mao.t4
 * Class(类名): StickyAndHalfPackedTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/8
 * Time(创建时间)： 21:41
 * Version(版本): 1.0
 * Description(描述)： 黏包和半包
 */

public class StickyAndHalfPackedTest
{

    private static final Logger log = LoggerFactory.getLogger(StickyAndHalfPackedTest.class);

    public static void main(String[] args)
    {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.put("Hello,world\nI'm zhangsan\nHo".getBytes(StandardCharsets.UTF_8));
        split(byteBuffer);
        byteBuffer.put("w are you?\nhaha!\n".getBytes(StandardCharsets.UTF_8));
        split(byteBuffer);
    }


    /**
     * 分割
     *
     * @param byteBuffer 字节缓冲区
     */
    private static void split(ByteBuffer byteBuffer)
    {
        //切换到读模式
        byteBuffer.flip();
        //得到limit
        int limit = byteBuffer.limit();
        for (int i = 0; i < limit; i++)
        {
            //判断是否遇到了换换行符
            if (byteBuffer.get(i) == '\n')
            {
                //换行符
                log.debug(String.valueOf(i));
                //开辟一个一行长度的ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(i + 1 - byteBuffer.position());
                //设置limit
                byteBuffer.limit(i + 1);
                //从byteBuffer读，向target写
                target.put(byteBuffer);
                //打印
                ByteBufferUtil.debugAll(target);
                byteBuffer.limit(limit);
            }
        }
        //切换到写模式，未读完的部分继续
        byteBuffer.compact();
    }
}
