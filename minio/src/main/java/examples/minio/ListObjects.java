package examples.minio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import examples.minio.util.Utils;
import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.errors.MinioException;
import io.minio.messages.Item;

public class ListObjects {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
		try {
			Utils uu = new Utils();

			MinioClient minioClient = uu.getClient();		      

			uu.checkBucket(minioClient);

			ListObjectsArgs arg = ListObjectsArgs.builder()
					.bucket(Utils.minioBucketName)
					.build();
			Iterable<Result<Item>> items = minioClient.listObjects(arg );
			for (Result<Item> result : items) {
				logger.info(result.get().etag());
				logger.info(result.get().objectName());
			}

		} catch (MinioException e) {
			logger.error("Error occurred: " + e);
			logger.error("HTTP trace: " + e.httpTrace());
		}
	}

	private static Logger logger = LoggerFactory.getLogger(ListObjects.class);

}
