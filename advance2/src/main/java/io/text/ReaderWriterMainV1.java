package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        // 문자 - byte UTF-8 인코딩
        byte[] writeBytes = writeString.getBytes(StandardCharsets.UTF_8);
        System.out.println("write string = " + writeString);
        System.out.println("write bytes = " + Arrays.toString(writeBytes));

        // 파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();
        
        // 파일에 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fis.readAllBytes();
        fis.close();

        // byte -> String UTF-8 디코딩
        String readString = new String(readAllBytes, StandardCharsets.UTF_8);
        System.out.println("read string = " + Arrays.toString(readAllBytes));
        System.out.println("read bytes = " + readString);
    }
}
