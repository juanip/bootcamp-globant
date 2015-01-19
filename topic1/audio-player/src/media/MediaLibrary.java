package media;

import java.util.ArrayList;

public class MediaLibrary {

	private static MediaLibrary mediaLibrary;

	public static MediaLibrary getMediaLibrary() {
		if (mediaLibrary == null) {
			mediaLibrary = new MediaLibrary();
		}

		return mediaLibrary;
	}

	private ArrayList<Track> library = new ArrayList<Track>();

	// singleton
	private MediaLibrary() {

	}

	public void addMedia(Track track) {
		this.library.add(track);
	}

	public void removeMedia(Track track) {
		this.library.remove(track);
	}

	public ArrayList<Track> searchMedia(String name) {
		ArrayList<Track> search = new ArrayList<Track>();

		for (Track t : this.library) {
			if (t.getName().contains(name)) {
				search.add(t);
			}
		}

		return search;
	}

	public ArrayList<Track> getAllMedia() {
		return this.library;
	}
}
