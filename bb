import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter file source : ");
        String sourceFilePath = in.nextLine();
        System.out.print("Enter file dest : ");
        String targetFilePath = in.nextLine();

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(targetFilePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            long totalBytesCopied = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
            }

            System.out.println("File copied successfully.");
            System.out.println("Total bytes copied: " + totalBytesCopied);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred during file copy: " + e.getMessage());
        }
    }
}
