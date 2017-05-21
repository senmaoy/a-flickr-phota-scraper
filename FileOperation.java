package ME;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;

public class FileOperation {
 
 /**
  * �����ļ�
  * @param fileName
  * @return
  */
 public static boolean createFile(File fileName)throws Exception{
  boolean flag=false;
  try{
   if(!fileName.exists()){
    fileName.createNewFile();
    flag=true;
   }
  }catch(Exception e){
   e.printStackTrace();
  }
  return true;
 } 
 
 /**
  * ��TXT�ļ�����
  * @param fileName
  * @return
  */
 public static String readTxtFile(File fileName)throws Exception{
  String result="";
  FileReader fileReader=null;
  BufferedReader bufferedReader=null;
  try{
   fileReader=new FileReader(fileName);
   bufferedReader=new BufferedReader(fileReader);
   try{
    String read=null;
    while((read=bufferedReader.readLine())!=null){
     result=result+read+"\r\n";
    }
   }catch(Exception e){
    e.printStackTrace();
   }
  }catch(Exception e){
   e.printStackTrace();
  }finally{
   if(bufferedReader!=null){
    bufferedReader.close();
   }
   if(fileReader!=null){
    fileReader.close();
   }
  }
  System.out.println("��ȡ�������ļ������ǣ�"+"\r\n"+result);
  return result;
 }
 
 
 public static boolean writeTxtFile(String content,File  fileName)throws Exception{
  RandomAccessFile mm=null;
  boolean flag=false;
  FileOutputStream o=null;
  try {
      o = new FileOutputStream(fileName);
      o.write(content.getBytes("GBK"));
      o.write(content.getBytes("GBK"));
      o.close();
//   mm=new RandomAccessFile(fileName,"rw");
//   mm.writeBytes(content);
   flag=true;
  } catch (Exception e) {
   // TODO: handle exception
   e.printStackTrace();
  }finally{
   if(mm!=null){
    mm.close();
   }
  }
  return flag;
 }



public static void contentToTxt(String filePath, String content) {
        String str = new String(); //ԭ��txt����
        String s1 = new String();//���ݸ���
        try {
            File f = new File(filePath);
            if (f.exists()) {
                System.out.print("�ļ�����");
            } else {
                System.out.print("�ļ�������");
                f.createNewFile();// �������򴴽�
            }
            BufferedReader input = new BufferedReader(new FileReader(f));

            while ((str = input.readLine()) != null) {
                s1 += str + "\n";
            }
            System.out.println(s1);
            input.close();
            s1 += content;

            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(s1);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}