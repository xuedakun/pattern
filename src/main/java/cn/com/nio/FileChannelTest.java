package cn.com.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xuekun
 * @create 2019-12-09 16:02
 **/
public class FileChannelTest {
    public static void test1() {
        try {
            RandomAccessFile raf = new RandomAccessFile("D:\\工作日常\\大数据模块说明.txt", "rw");
            FileChannel fileChannel = raf.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
            }
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("D:\\工作日常\\大数据模块说明.txt", "rw");
            RandomAccessFile toFile = new RandomAccessFile("D:\\工作日常\\测试.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            toChannel.transferFrom(fromChannel, position, count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("D:\\工作日常\\大数据模块说明.txt", "rw");
            RandomAccessFile toFile = new RandomAccessFile("D:\\工作日常\\测试.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            long position = 0;
            long count = fromChannel.size();
            fromChannel.transferTo(position, count, toChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSelector() {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("D:\\工作日常\\大数据模块说明.txt", "rw");
            RandomAccessFile toFile = new RandomAccessFile("D:\\工作日常\\测试.txt", "rw");
            SocketChannel fromChannel = null;
            SocketChannel toChannel = null;

            //创建选择器
            Selector selector = Selector.open();

            SelectionKey key1 = fromChannel.register(selector,
                    SelectionKey.OP_READ);
            SelectionKey key2 = toChannel.register(selector,
                    SelectionKey.OP_READ);

            while (true) {
                int i = selector.select();
                if (i == 0) {
                    continue;
                }
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                    }
                    keyIterator.remove();
                }
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }

    public static void receiveDataGramChannel() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        channel.receive(buf);
    }

    public static void sendDataGramChannel() throws Exception {
        DatagramChannel channel = DatagramChannel.open();
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        int bytesSent = channel.send(buf, new InetSocketAddress("127.0.0.1", 9999));
    }

    public static void testSocketChannel() {
        try {
            //创建一个sockchannel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = socketChannel.read(buf);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testPipe() {
        try {
            Pipe pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                sinkChannel.write(buf);
            }

            Pipe.SourceChannel sourceChannel = pipe.source();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = sourceChannel.read(byteBuffer);
            System.out.println(bytesRead);
            while (bytesRead != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                bytesRead = sourceChannel.read(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileChannelTest.testPipe();
    }
}
