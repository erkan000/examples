package examples.minio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import examples.minio.util.Utils;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.http.Method;

public class DownloadLinkGenerate {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		
		try {
			Utils uu = new Utils();

			MinioClient minioClient = uu.getClient();		      

			uu.checkBucket(minioClient);

			String url =
					minioClient.getPresignedObjectUrl(
							GetPresignedObjectUrlArgs.builder()
							.method(Method.GET)
							.bucket(Utils.minioBucketName)
							.object("myfolder/testFileName.txt")
							.expiry(1, TimeUnit.MINUTES)
							.build());
			
			System.out.println(url);

		} catch (MinioException e) {
			logger.error("Error occurred: " + e);
			logger.error("HTTP trace: " + e.httpTrace());
		}
	}

	private static Logger logger = LoggerFactory.getLogger(DownloadLinkGenerate.class);

}
