package media;

import java.io.File;

public class TrackFactory {

	private static TrackFactory trackFactory;

	public static TrackFactory getTrackFactory() {
		if (trackFactory == null) {
			trackFactory = new TrackFactory();
		}

		return trackFactory;
	}

	// singleton
	private TrackFactory() {

	}

	public Track getTrack(String fileName) {
		if (fileName.matches("(.*).mp3")) {
			return new MP3Track(new File(fileName));
		} else {
			return new OGGTrack(new File(fileName));
		}
	}
}
