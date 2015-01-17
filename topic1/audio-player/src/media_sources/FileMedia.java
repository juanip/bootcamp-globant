package media_sources;

import java.io.File;

import media.Track;
import media.TrackFactory;

public class FileMedia implements MediaSource {

	private File file;

	public FileMedia(File file) {
		this.file = file;
	}

	public Track open() {
		return TrackFactory.getTrackFactory().getTrack(this.file.getPath());
	}
}
