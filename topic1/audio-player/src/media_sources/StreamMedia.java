package media_sources;

import java.net.URL;

import media.Track;
import media.TrackFactory;

public class StreamMedia implements MediaSource {

	private final URL url;

	public StreamMedia(URL url) {
		this.url = url;
	}

	private String getFileName() {
		// some magic
		return "myFile.mp3";
	}

	public Track open() {
		return TrackFactory.getTrackFactory().getTrack(this.getFileName());
	}
}
