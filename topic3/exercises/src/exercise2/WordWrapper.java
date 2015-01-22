package exercise2;

import java.util.ArrayList;

public class WordWrapper {

	public ArrayList<String> getRows(String str, int length) {
		ArrayList<String> rows = new ArrayList<String>();

		String[] words = str.split(" ");
		StringBuilder sb = new StringBuilder();

		for (String w : words) {
			if (w.length() > length) {
				// number of sub-words
				int count = (int) Math.floor((w.length() / (double) length));

				int begin = 0;
				int end = length;
				for (int i = 0; i < count; i++) {
					rows.add(w.substring(begin, end));
					begin = end;
					end += length;
				}

				rows.add(w.substring(begin));

			} else {
				if (sb.length() == 0) {
					sb.append(w);
				} else if (sb.length() + w.length() + 1 <= length) {
					sb.append(" " + w);
				} else {
					rows.add(sb.toString());
					sb = new StringBuilder();
					sb.append(w);
				}
			}
		}

		if (sb.length() > 0) {
			rows.add(sb.toString());
		}
		return rows;
	}
}
