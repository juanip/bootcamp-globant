import java.io.File;

import media_sources.DropBoxMedia;
import media_sources.FileMedia;
import media_sources.MediaSource;
import player.MusicPlayer;

public class App {

	public static void main(String[] args) {
		MusicPlayer mp = new MusicPlayer();

		MediaSource dropbox = new DropBoxMedia("1445256");
		MediaSource fileMedia = new FileMedia(new File("Oasis - Lyla.ogg"));

		mp.addTrackToLibrary(dropbox.open());
		mp.addTrackToLibrary(fileMedia.open());

		mp.addAllLibraryToPlayList();

		System.out.println(mp);
		mp.play();
		System.out.println(mp);
		mp.pause();
		System.out.println(mp);
		mp.play();
		System.out.println(mp);
		mp.nextTrack();
		System.out.println(mp);
		mp.stop();
		System.out.println(mp);
		mp.nextTrack();
		System.out.println(mp);
		mp.nextTrack();
		System.out.println(mp);
		mp.previousTrack();
		System.out.println(mp);
	}
}
