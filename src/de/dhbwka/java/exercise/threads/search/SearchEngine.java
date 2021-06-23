package de.dhbwka.java.exercise.threads.search;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yannik Schiebelhut
 */
public class SearchEngine {

	public static void main(String[] args) {
		ArrayList<String> urls = new ArrayList<>();
		urls.add("https://www.tagesschau.de");
		urls.add("https://www.sueddeutsche.de");
		urls.add("https://www.spiegel.de");
		urls.add("https://www.dhbw.de");
		urls.add("https://www.google.de");

		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		ArrayList<PageLoader> loaders = new ArrayList<>();
		for (String url : urls) {
			PageLoader tmp = new PageLoader(url);
			loaders.add(tmp);
			threadPool.execute(tmp);
		}
		threadPool.shutdown();

		while (!threadPool.isTerminated()) {
			for (int i = loaders.size() - 1; i >= 0; i--) {
				PageLoader p = loaders.get(i);
				if (p.pageLoaded()) {
					synchronized (p) {
						System.out.println("Geladen: " + p.getUrl().toString());
						System.out.print("  Inhalt: ");
						System.out.println(p.getPageContent().substring(0, 40).replaceAll(System.lineSeparator(),
								"##"));
						loaders.remove(i);
					}
				}
			}
		}
	}
}
