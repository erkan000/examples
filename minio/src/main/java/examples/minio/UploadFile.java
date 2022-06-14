package examples.minio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import examples.minio.util.Utils;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;

public class UploadFile {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		try {
			Utils uu = new Utils();

			MinioClient minioClient = uu.getClient();		      

			uu.checkBucket(minioClient);

			UploadObjectArgs file = UploadObjectArgs.builder()
					.bucket(Utils.minioBucketName)
					.object("testFileName.txt")
					.filename("src/main/resources/test.txt")
					.build();
			
			ObjectWriteResponse response = minioClient.uploadObject(file);
			logger.info("Etag is: " + response.etag());

			logger.info("File successfully uploaded to bucket.");

		} catch (MinioException e) {
			logger.error("Error occurred: " + e);
			logger.error("HTTP trace: " + e.httpTrace());
		}
	}

	private static Logger logger = LoggerFactory.getLogger(UploadFile.class);

}
