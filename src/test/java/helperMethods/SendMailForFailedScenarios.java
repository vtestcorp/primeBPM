package helperMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailForFailedScenarios {

	public static Properties prop = new Properties();

	public static void SendMail(int count, int Status, int failedCount, int skipcoun,String hypen,String space,String atest) throws IOException {

		FileInputStream ip = new FileInputStream("Test_Data//config.properties");
		prop.load(ip);

		// Recipient's email ID needs to be mentioned.
		final String username = prop.getProperty("FromEmailUsername");
		final String password = prop.getProperty("EmailPassword");

		System.out.println(username);
		System.out.println(password);

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			String email = prop.getProperty("ToEmailUsername");
			String subject = "Vtest - Automation Test Cases Execution status"+new DateUtils().getDate1();

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(username));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			// Set Subject: header field
			message.setSubject(subject);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
//			messageBodyPart.setText("Hello Sir/Madam"
//					+ ",\n\n Hope you are doing good.\n\nTest status -"
//					+" \n | No | PackageName.className.TestCaseName | status |\n"
//					+status+" Attached is the screenshots for the failed scenarios.\n\n For further details, contact the QA team.\n\n"
//					+ "\n\n Regards" + "\n QA Team");
			messageBodyPart.setText("Hi,\nExecution status for test cases-\n\n" + hypen + hypen + hypen + "\n"
					+ hypen + hypen + hypen + "\n" + "Total test cases = " + count
					+ "\n\n" + "Pass Test cases = " + Status + "\n\n" + "Failed Test cases = " + failedCount + "\n\n" + "Skip Test cases = " + skipcoun + "\n\n" + hypen + hypen + hypen+" Please check Attached report and sample test data, Thanks");
			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

//			File directory = new File("report\\" + newFolderName);
//			Path dir = directory.toPath();
//			DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
//			for (Path file : stream) {
//				if (file.getFileName().toString().contains("png") && file.getFileName().toString().contains("fail"))
//				{
//					addAttachment(multipart, "screenshot\\" + newFolderName + "\\" + file.getFileName());
//				}
//			}
			addAttachment(multipart, "report\\DetailedReport.zip");
			addAttachment(multipart, "Test_Data\\Test_Data.xlsx");
			System.out.println("after status");
			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully to " + email);

		} catch (Exception mex) {
			// mex.printStackTrace();
		}
	}

	private static void addAttachment(Multipart multipart, String filename) throws MessagingException {
		DataSource source = new FileDataSource(filename);
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(new File(filename).getName());
		multipart.addBodyPart(messageBodyPart);
	}
}