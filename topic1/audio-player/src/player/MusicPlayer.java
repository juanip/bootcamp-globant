package player;

import java.util.ArrayList;

import media.MediaLibrary;
import media.Track;

public class MusicPlayer {

	private MediaLibrary library = new MediaLibrary();
	private ArrayList<Track> playlist = new ArrayList<Track>();
	private Track currentTrack;
	private MediaPlayerState state;

	public MusicPlayer() {
		this.stop();
	}

	public void nextTrack() {
		this.stop();

		int index = this.playlist.indexOf(this.currentTrack);

		if (index < this.playlist.size() - 1) {
			this.currentTrack = this.playlist.get(index + 1);
		} else {
			this.currentTrack = this.playlist.get(0);
		}

		this.play();
	}

	public void previousTrack() {
		this.stop();

		int index = this.playlist.indexOf(this.currentTrack);

		if (index > 0) {
			this.currentTrack = this.playlist.get(index - 1);
		} else {
			this.currentTrack = this.playlist.get(this.playlist.size() - 1);
		}

		this.play();
	}

	public void play() {
		if (this.currentTrack == null) {
			this.currentTrack = this.playlist.get(0);
		}
		this.state = new PlayState();
		this.toString();
	}

	public void pause() {
		this.state = new PauseState();
		this.toString();
	}

	public void stop() {
		this.state = new StopState();
		this.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Music Player: ");
		sb.append(this.currentTrack == null ? "No track" : this.currentTrack);
		sb.append(" - ");
		sb.append(this.state);

		return sb.toString();
	}

	public void addTracksToPlaylist(String name) {
		for (Track t : searchLibrary(name)) {
			this.playlist.add(t);
		}
	}

	public void addAllLibraryToPlayList() {
		for (Track t : this.library.getAllMedia()) {
			this.playlist.add(t);
		}
	}

	public void addTrackToLibrary(Track track) {
		this.library.addMedia(track);
	}

	public ArrayList<Track> searchLibrary(String name) {
		return this.library.searchMedia(name);
	}

}
