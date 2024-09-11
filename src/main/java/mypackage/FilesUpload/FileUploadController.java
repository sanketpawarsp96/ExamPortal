//package mypackage.FilesUpload;
//
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//import ch.qos.logback.classic.Logger;
//import mypackage.FilesUpload.payload.UploadFileResponce;
//
//@RestController
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
//
//public class FileUploadController 
//{
//	//private static final Logger logger=LoggerFactory.getLogger()
//	
//	@Autowired 
//	private FileStorageService filestorageservice;
//	
//	@PostMapping("/uploadFile")
//	public UploadFileResponce uploadFile(@RequestParam("file") MultipartFile file)
//	{
//		String fileName=filestorageservice.storeFile(file);
//		String fileDownloadUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadfile/")
//																					.path(fileName)
//																					.toUriString();
//																				
//		return new UploadFileResponce(fileName,fileDownloadUri,file.getContentType(),file.getSize());
//	}
//	
//	@PostMapping("/uploadMultipleFiles")
//    public List<Object> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) 
//	{
//        return Arrays.asList(files).stream().map(new Function<MultipartFile, Object>() {
//			public Object apply(MultipartFile file) {
//				return uploadFile(file);
//			}
//		}).collect(Collectors.toList());
//    }
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
