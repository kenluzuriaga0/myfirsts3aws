package com.nek;

import java.io.File;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * Project to learn S3 AWS by Kencito 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//     Connection (static credentials method)
//     There are more methods...  system java properties, environment variables and AWS Client )

       BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);
        
       AmazonS3 client = AmazonS3ClientBuilder.standard()
       .withRegion(Regions.fromName("us-east-1"))
       .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
       .build();


       System.out.println( "Empiezo..." );
       long init = System.currentTimeMillis();

       /* Fill the object to send */
       String bucketName = "bucketsam2k22";
       String fileName = "2.jpg";
       String filePath="/home/nek/Imágenes/Wallpapers/"+fileName;


       //Send to the bucket       
       PutObjectRequest request = new PutObjectRequest(bucketName, fileName, new File(filePath));
       client.putObject(request);

       //Print execution time
       System.out.println(System.currentTimeMillis()-init);

       System.out.println("Terminado...");
    }
}
