package services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import entities.Photo;

public interface IPhotoServices {

	public List<Photo> getPhotos(long userID);

	public Photo getPhoto(long photoID);

	public Photo addPhoto(long userID, String name, MultipartFile file);

}
