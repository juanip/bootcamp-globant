package exercise3;

import java.io.File;
import java.util.ArrayList;

public class RecentFileList {

	private ArrayList<File> recentFiles = new ArrayList<File>();

	public ArrayList<File> getList() {
		return this.recentFiles;
	}

	public void add(File file) {

		boolean flag = true;
		for (File f : recentFiles) {
			if (f.equals(file)) {
				recentFiles.remove(f);
				flag = true;
				break;
			}
		}

		if (flag) {
			recentFiles.remove(file);
		}

		recentFiles.add(0, file);

		if (recentFiles.size() > 15) {
			recentFiles.remove(15);
		}
	}
}
