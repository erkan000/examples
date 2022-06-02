package examples.minio.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class Utils {

	public static final String minioUrl = "http://localhost:9000";
	public static final String minioUser = "minioadmin";
	public static final String minioPass = "minioadmin";
	public static final String minioBucketName = "kovam";

	public MinioClient getClient() {
		return MinioClient.builder()
				.endpoint(minioUrl)
				.credentials(minioUser, minioPass)
				.build();
	}

	public void checkBucket(MinioClient minioClient) throws MinioException, IOException, InvalidKeyException, NoSuchAlgorithmException {
		
		boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioBucketName).build());
		if (!found) {
			logger.info("Bucket doesnt exists, creating new one.");
			minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioBucketName).build());
		} else {
			logger.info("Bucket already exists.");
		}
		
	}
	
	private Logger logger = LoggerFactory.getLogger(Utils.class);

}
