//package mypackage.FilesUpload;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import mypackage.FilesUpload.Exception.MyFileNotFoundException;
//import mypackage.FilesUpload.property.FileStorageProperties;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.util.*;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FileStorageService 
//{
//	private final Path fileStorageLocation;
//	
//	@Autowired
//	public FileStorageService(FileStorageProperties filestorageproperties)
//	{
//		this.fileStorageLocation=Paths.get(filestorageproperties.getUploadDir()).toAbsolutePath().normalize();
//		try
//		{
//			Files.createDirectories(this.fileStorageLocation);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public String storeFile(MultipartFile file)
//	{
//		// normalize file name
//		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
//		
//		try
//		{
//			// check if the file name contains invalid characters
//			if(fileName.contains(".."))
//			{
//				System.out.println("invalid path source");
//			}	 
//		
//			// Copy file to the target location (Replacing existing file with the same name)
//		
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//            System.out.println(targetLocation.getRoot());
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            
//            
//		}
//		
//		catch(IOException ex)
//		{
//			System.out.println("could not store file please try again ! "+ex);
//		}
//		return fileName;
//	}
//	
//	
//	
//	public Resource loadFileResource(String fileName) throws MalformedURLException
//	{
//		Path filePath=this.fileStorageLocation.resolve(fileName).normalize();
//		UrlResource resource=new UrlResource(filePath.toUri());
//		if(resource.exists())
//		{
//			return (Resource) resource;
//		}
//		else
//		{
//		   throw new MyFileNotFoundException("file not found "+fileName);
//		}
//	}
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
