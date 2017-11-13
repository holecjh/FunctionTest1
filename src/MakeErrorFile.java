import java.io.*;

/**
 * Created by chang on 2017-11-10.
 */
public class MakeErrorFile {
    public static void main(String[] args){
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File(args[0])));
            byte[] buffer = new byte[4096];
            int read = 0;

            for(int i=0; i < 2; i++){
                bis = new BufferedInputStream(new FileInputStream(new File(args[1])));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 20; i++){
                bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\chang\\Documents\\사이냅테스트\\7z")));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 100; i++){
                bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\chang\\Documents\\사이냅테스트\\b")));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 100; i++){
                bis = new BufferedInputStream(new FileInputStream(new File(args[2])));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 100; i++){
                bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\chang\\Documents\\사이냅테스트\\b")));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 100; i++){
                bis = new BufferedInputStream(new FileInputStream(new File(args[1])));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 10; i++){
                bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\chang\\Documents\\사이냅테스트\\b")));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 100; i++){
                bis = new BufferedInputStream(new FileInputStream(new File(args[2])));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }

            for(int i=0; i < 20; i++){
                bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\chang\\Documents\\사이냅테스트\\7z")));
                while((read = bis.read(buffer, 0,4096)) != -1){
                    bos.write(buffer, 0, 4096);
                }
                bis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bis != null) bis.close();
                if(bos != null) bos.close();
            }catch(Exception ee){}
        }

    }
}
