package media_sources;

public abstract class CloudMedia implements MediaSource {

	private final String fileID;

	public CloudMedia(String fileID) {
		this.fileID = fileID;
	}

	public String getFileID() {
		return this.fileID;
	}

}