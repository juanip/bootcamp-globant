package media_sources;

import media.Track;
import media.TrackFactory;

public class DriveMedia extends CloudMedia {

	public DriveMedia(String fileID) {
		super(fileID);
	}

	private String getFileName() {
		// some magic
		return "myTrack.mp3";
	}

	public Track open() {
		return TrackFactory.getTrackFactory().getTrack(this.getFileName());
	}
}
