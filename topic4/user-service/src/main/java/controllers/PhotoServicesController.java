package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import services.IPhotoServices;
import services.PhotoServices;
import entities.Photo;

@Controller
@RequestMapping("photos")
public class PhotoServicesController {

	private IPhotoServices photoServices = new PhotoServices();

	// get all the photos of a user
	@RequestMapping(value = "/{userID}", method = RequestMethod.GET)
	public @ResponseBody List<Photo> getPhotos(@PathVariable long userID) {
		return photoServices.getPhotos(userID);
	}

	// get a photo of a user
	@RequestMapping(value = "/{userID}/{photoID}", method = RequestMethod.GET)
	public @ResponseBody Photo getPhoto(@PathVariable long photoID) {
		return photoServices.getPhoto(photoID);
	}

	// upload a photo
	@RequestMapping(value = "/{userID}", method = RequestMethod.POST)
	public @ResponseBody Photo addPhoto(@PathVariable long userID, @RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		return photoServices.addPhoto(userID, name, file);
	}

}
