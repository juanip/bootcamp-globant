package exercise3;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

public class RecentFileListTest {

	File file1 = new File("myFile1");
	File file2 = new File("myFile2");
	File file3 = new File("myFile3");
	File file4 = new File("myFile4");
	File file5 = new File("myFile5");
	File file6 = new File("myFile6");
	File file7 = new File("myFile7");
	File file8 = new File("myFile8");
	File file9 = new File("myFile9");
	File file10 = new File("myFile10");
	File file11 = new File("myFile11");
	File file12 = new File("myFile12");
	File file13 = new File("myFile13");
	File file14 = new File("myFile14");
	File file15 = new File("myFile15");
	File file16 = new File("myFile16");

	@Test
	public void testEmptyList() {
		RecentFileList rfl = new RecentFileList();
		ArrayList<File> recentFiles = new ArrayList<File>();

		assertEquals(recentFiles, rfl.getList());
	}

	@Test
	public void testOneFile() {
		RecentFileList rfl = new RecentFileList();
		rfl.add(file1);

		ArrayList<File> recentFiles = new ArrayList<File>();
		recentFiles.add(file1);

		assertEquals(recentFiles, rfl.getList());
	}

	@Test
	public void testThreeFiles() {
		RecentFileList rfl = new RecentFileList();
		rfl.add(file1);
		rfl.add(file2);
		rfl.add(file3);

		ArrayList<File> recentFiles = new ArrayList<File>();
		recentFiles.add(new File("myFile3"));
		recentFiles.add(new File("myFile2"));
		recentFiles.add(new File("myFile1"));

		assertEquals(recentFiles, rfl.getList());
	}

	@Test
	public void testBumpFile() {
		RecentFileList rfl = new RecentFileList();
		rfl.add(file1);
		rfl.add(file2);
		rfl.add(file3);
		rfl.add(file1);
		rfl.add(file4);

		ArrayList<File> recentFiles = new ArrayList<File>();
		recentFiles.add(file4);
		recentFiles.add(file1);
		recentFiles.add(file3);
		recentFiles.add(file2);

		assertEquals(recentFiles, rfl.getList());
	}

	@Test
	public void testMaxNumberFiles() {
		RecentFileList rfl = new RecentFileList();
		rfl.add(file1);
		rfl.add(file2);
		rfl.add(file3);
		rfl.add(file4);
		rfl.add(file5);
		rfl.add(file6);
		rfl.add(file7);
		rfl.add(file8);
		rfl.add(file9);
		rfl.add(file10);
		rfl.add(file11);
		rfl.add(file12);
		rfl.add(file13);
		rfl.add(file14);
		rfl.add(file15);
		rfl.add(file16);

		ArrayList<File> recentFiles = new ArrayList<File>();
		recentFiles.add(file16);
		recentFiles.add(file15);
		recentFiles.add(file14);
		recentFiles.add(file13);
		recentFiles.add(file12);
		recentFiles.add(file11);
		recentFiles.add(file10);
		recentFiles.add(file9);
		recentFiles.add(file8);
		recentFiles.add(file7);
		recentFiles.add(file6);
		recentFiles.add(file5);
		recentFiles.add(file4);
		recentFiles.add(file3);
		recentFiles.add(file2);

		assertEquals(recentFiles, rfl.getList());
	}
}
