package services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import data.PhotosRepository;
import data.UserRepository;
import entities.Photo;
import entities.UserNotFoundException;

public class PhotoServices implements IPhotoServices {

	private final PhotosRepository photoRepository = PhotosRepository.getInstance();

	@Override
	public List<Photo> getPhotos(long userID) {
		return photoRepository.getPhotos(userID);
	}

	@Override
	public Photo getPhoto(long photoID) {
		return photoRepository.getPhoto(photoID);
	}

	@Override
	public Photo addPhoto(long userID, String name, MultipartFile file) {
		if (!UserRepository.getInstance().existUser(userID)) {
			throw new UserNotFoundException();
		}

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				File photoFile = new File("/tmp/" + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(photoFile));

				stream.write(bytes);
				stream.close();

				Photo photo = photoRepository.addPhoto(userID, name, photoFile);
				return photo;
			} catch (IOException e) {
				throw new PhotoNotUploadedException(name);
			}
		} else {
			throw new PhotoNotUploadedException(name);
		}
	}
}

class PhotoNotUploadedException extends RuntimeException {
	public PhotoNotUploadedException(String name) {
		super("Cannot upload the file " + name);
	}
}
