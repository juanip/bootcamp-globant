package media;

import java.io.File;

public abstract class Track {

	private final String name;

	private final String codec;

	public Track(File file, String codec) {
		this.name = file.getName();
		this.codec = codec;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getCodec() {
		return this.codec;
	}
}