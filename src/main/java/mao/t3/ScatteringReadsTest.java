package mao.t3;

import mao.utils.ByteBufferUtil;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Project name(项目名称)：Netty_ByteBuffer
 * Package(包名): mao.t3
 * Class(类名): ScatteringReadsTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/3/5
 * Time(创建时间)： 22:39
 * Version(版本): 1.0
 * Description(描述)： Scattering Reads
 */

public class ScatteringReadsTest
{
    public static void main(String[] args)
    {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("data2.txt", "rw"))
        {
            FileChannel fileChannel = randomAccessFile.getChannel();

            //构建4个ByteBuffer
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(3);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(3);
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(5);
            ByteBuffer byteBuffer4 = ByteBuffer.allocate(4);

            //ByteBuffer数组
            ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3, byteBuffer4};

            //读取，并写入到4个ByteBuffer中
            fileChannel.read(byteBuffers);

            //打印
            ByteBufferUtil.debugAll(byteBuffer1);
            ByteBufferUtil.debugAll(byteBuffer2);
            ByteBufferUtil.debugAll(byteBuffer3);
            ByteBufferUtil.debugAll(byteBuffer4);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
