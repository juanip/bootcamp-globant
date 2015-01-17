package media;

import java.io.File;

public class MP3Track extends Track {

	public MP3Track(File file) {
		super(file, "MPEG-2 Audio Layer III");
	}
}