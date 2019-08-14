package cn.com.pattern.composite.killVirus;

/**
 * @author xuekun
 * @create 2019-07-26 16:21
 **/
public class KillVirus {
    public static void main(String[] args) {
        AbstractFile folder, folder1,folder2,file1,file2,file3,file4,file;
        folder1 =new Folder("图片文件夹");
        folder2 =new Folder("文本文件夹");

        file1=new ImgFile("jpg");
        file2=new ImgFile("gif");
        file3=new TextFile("txt");
        file4=new TextFile("doc");file=new TextFile("文件说明");

        folder1.add(file1);
        folder1.add(file2);
        folder2.add(file3);
        folder2.add(file4);
        folder=new Folder("总文件");
        folder.add(folder1);
        folder.add(folder2);
        folder.add(file);
        folder.killVirus();
    }
}
