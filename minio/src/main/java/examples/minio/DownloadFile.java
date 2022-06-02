package examples.minio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import examples.minio.util.Utils;
import io.minio.DownloadObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class DownloadFile {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		try {
			Utils uu = new Utils();

			MinioClient minioClient = uu.getClient();		      

			uu.checkBucket(minioClient);

			DownloadObjectArgs file = DownloadObjectArgs.builder()
					.bucket(Utils.minioBucketName)
					.object("testFileName.txt")
					.filename("src/main/resources/downloadedFile.txt")
					.build();

			minioClient.downloadObject(file);

			logger.info("File successfully downloaded to " + file.filename());

		} catch (MinioException e) {
			logger.error("Error occurred: " + e);
			logger.error("HTTP trace: " + e.httpTrace());
		}
	}

	private static Logger logger = LoggerFactory.getLogger(DownloadFile.class);

}
