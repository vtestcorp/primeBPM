package helperMethods;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.defineConstants;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Bobby
 */
public class slackUtils {
    private static String slackWebhookUrl = "https://hooks.slack.com/services/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";
    //Vtest link
    // https://hooks.slack.com/services/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
    //https://hooks.slack.com/services/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 - manisha


    //Nexlp link
    // https://hooks.slack.com/services/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

    public static void sendMessage(slackMessage message, String zipFileName) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(slackWebhookUrl);
        try {
		/*	String zipMsg="Please find the attached zip file. \nWhich contains screenshots for failed test cases and \nhtml report file for complete script execution";
			InputStream inputStream = new FileInputStream(defineConstants.reportData);
			File file = new File(zipFileName);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addBinaryBody("upfile", file, ContentType.DEFAULT_BINARY, zipFileName);
			builder.addBinaryBody("upstream", inputStream, ContentType.create("application/zip"), zipFileName);
			builder.addTextBody("text", zipMsg, ContentType.TEXT_PLAIN);
			HttpEntity entity1 = builder.build();*/
            File file = new File(zipFileName);
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(message);
			//String json = objectMapper.writeValue();
		//	String json1 = objectMapper.writeValueAsString(entity1);
			StringEntity entity = new StringEntity(json);
			//StringEntity entity2 = new StringEntity(json1);
			httpPost.setEntity(entity);
			//httpPost.setEntity(json1);
			httpPost.setHeader("Accept", "multipart/form-data");
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

            client.execute(httpPost);
            client.close();
            //System.out.println(json+entity1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}