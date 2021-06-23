package de.dhbwka.java.exercise.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author Yannik Schiebelhut
 */
public class PageLoader implements Runnable {

	private URL url;
	private boolean loaded = false;
	private String content;

	public PageLoader(String urlStr) {
		try {
			this.url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		StringBuilder buffer = new StringBuilder();
		String line = null;
		System.out.println("Gestartet: " + this.url.toString());
		try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
			while ((line = br.readLine()) != null) {
				buffer.append(line).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.content = buffer.toString();
		this.loaded = true;
	}

	public boolean pageLoaded() {
		return this.loaded;
	}

	public String getPageContent() {
		return this.content;
	}

	public URL getUrl() {
		return url;
	}
}
