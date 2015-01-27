package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entities.Photo;
import entities.User;

public class PhotosRepository {

	private static PhotosRepository instance;
	private static long nextID = 0;

	public static PhotosRepository getInstance() {
		if (instance == null) {
			instance = new PhotosRepository();
		}
		return instance;
	}

	private static long getNextID() {
		nextID++;
		return nextID - 1;
	}

	private List<Photo> photos = new ArrayList<Photo>();

	private PhotosRepository() {
	}

	public List<Photo> getPhotos(long userID) {
		List<Photo> photos = new ArrayList<Photo>();
		for (Photo p : this.photos) {
			if (p.getUser().getId() == userID) {
				photos.add(p);
			}
		}

		return photos;
	}

	public Photo getPhoto(long photoID) {
		for (Photo p : this.photos) {
			if (p.getId() == photoID) {
				return p;
			}
		}

		throw new PhotoNotFoundException();
	}

	class PhotoNotFoundException extends RuntimeException {
		public PhotoNotFoundException() {
			super("Photo not found.");
		}
	}

	public Photo addPhoto(long userID, String name, File photoFile) {
		User user = UserRepository.getInstance().getUser(userID);
		Photo photo = new Photo(getNextID(), name, photoFile, user);

		this.photos.add(photo);

		return photo;
	}
}
