package com.hard.dao.accessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class FileDatasourceAccessor {
	public BufferedReader load() throws FileNotFoundException {
		File file = new File(getDatasourceName());
		return new BufferedReader(new FileReader(file));
	}
	
	public abstract String getDatasourceName();
}